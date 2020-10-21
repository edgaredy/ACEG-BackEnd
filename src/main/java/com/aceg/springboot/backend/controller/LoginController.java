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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.models.LoginResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.jwt.JwtUtils;
import com.aceg.springboot.backend.service.UserDetailsImpl;

/**
 * - Descripcion: Clase LoginController para le gestion de inicio de sesion de
 * un usuario asi como la validacion de este, generacion de token de acceso 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@RestController
@RequestMapping("/login")
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

	/**
	 * Realiza el login de un usuario por username and password
	 * 
	 * Valida nombre de usuario y contraseña
	 * Valida token / crea token de acceso
	 * Obtiene el rol del usuario
	 * 
	 * @param usuario - nombre de usuario
	 * @return token del usuario, id del usuario, nombre usuario, password, rol del usuario
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	@PostMapping("/login-usuario")
	public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody UsuarioBean usuario) throws AcegServiceException {
		
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

}
