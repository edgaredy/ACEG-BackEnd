/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.models.LoginResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.jwt.JwtUtils;
import com.aceg.springboot.backend.service.UserDetailsImpl;

/**
 * - Descripcion: Clase LoginController para le gestion de inicio de sesion de
 * un usuario asi como la validacion de este, generacion de token de acceso 
 * - Numero de Metodos: 5
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@RestController
@RequestMapping("/aceg/api")
public class LoginController {

	/**
	 * Referencia hacia AuthenticationManager
	 */
	@Autowired
	AuthenticationManager authenticationManager;

	/**
	 * Referencia hacia JwtUtils
	 */
	@Autowired
	JwtUtils jwtUtils;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody UsuarioBean usuario) {
		
		LOGGER.info("Ejecutando LoginController - authenticateUser()");

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return new ResponseEntity<>(new LoginResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getPassword(), roles), HttpStatus.OK);
	}

	/**
	 * Metodo de prueba para el funcionamiento del rol carnicero
	 * @return - String Solo Carniceros
	 */
	@GetMapping("/home/carnicero")
	public String carniceroAccess() {
		return "Solo Carniceros.";
	}
	
	/**
	 * Metodo de prueba para el funcionamiero del rol cliente
	 * @return - String Solo Clientes
	 */
	@GetMapping("/home/cliente")
	public String clienteAccess() {
		return "Solo Clientes.";
	}
	
	/**
	 * Metodo de prueba para el funcionamiero del rol proveedor
	 * @return - String Solo Proveedores
	 */
	@GetMapping("/home/proveedor")
	public String proveedorAccess() {
		return "Solo Proveedores.";
	}
	
	/**
	 * Metodo de prueba para el funcionamiero del rol admin
	 * @return - String Solo Administradores
	 */
	@GetMapping("/home/admin")
	public String adminAccess() {
		return "Solo Administradores.";
	}

}
