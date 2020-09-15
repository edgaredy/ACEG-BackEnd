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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.JwtResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.service.login.ILoginService;
import com.aceg.springboot.backend.jwt.JwtUtils;
import com.aceg.springboot.backend.service.UserDetailsImpl;

/**
 * - Descripcion: Clase LoginController para le gestion de inicio de sesion de
 * un usuario asi como la validacion de este, generacion de token de acceso 
 * - Numero de Metodos: 4
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@RestController
@RequestMapping("/aceg/api")
public class LoginController {

	/**
	 * Referencia hacia ILoginDao
	 */
	@Autowired
	private ILoginService iLoginService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Pagina de prueba de funcionamiento de seguridad JWT
	 * 
	 * @return - hello + name
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	@GetMapping("/hello")
	public String helloWorld() throws AcegServiceException {

		LOGGER.info("Ejecutando LoginController - helloWorld()");

		return "Hello World!!";
	}

	/**
	 * Valida el nombre de usuario y contraseña Devuelve el usuario y contraseña en
	 * un ResponseEntity
	 * 
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @return - usuario y contraseña
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	@PostMapping("/validar/datos/{username}")
	public ResponseEntity<UsuarioBean> verifyUsernamePassword(@PathVariable String username,
			@PathVariable String password) throws AcegServiceException {

		LOGGER.info("Ejecutando LoginController - verifyUsernamePassword()");

		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean = iLoginService.getByUsername(username);

		return new ResponseEntity<>(usuarioBean, HttpStatus.OK);
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UsuarioBean usuario) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getPassword(), roles));
	}

}
