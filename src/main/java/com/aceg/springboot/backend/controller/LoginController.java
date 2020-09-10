/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.jwt.JwtTokenUtil;
import com.aceg.springboot.backend.models.JwtRequest;
import com.aceg.springboot.backend.models.JwtResponse;
import com.aceg.springboot.backend.models.UsuarioBean;
import com.aceg.springboot.backend.service.login.ILoginService;

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

	/**
	 * Referencia hacia AuthenticationManager
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Referencia hacia JwtTokenUtil
	 */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * Referencia hacia UserDetailsService
	 */
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	
	/**
	 * Pagina de prueba de funcionamiento de seguridad JWT
	 * 
	 * @param name - nombre, valor por defecto es world
	 * @return - hello + name
	 */
	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {

		LOGGER.info("Ejecutando LoginController - helloWorld()");

		return "Hello " + name + "!!";
	}

	/**
	 * Valida el nombre de usuario y contraseña 
	 * Devuelve el usuario y contraseña en un ResponseEntity
	 * 
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @return - usuario y contraseña
	 */
	@PostMapping("/validar/datos/{username}/{password}")
	public ResponseEntity<UsuarioBean> verifyUsernamePassword(@PathVariable String username,
			@PathVariable String password) {

		LOGGER.info("Ejecutando LoginController - verifyUsernamePassword()");

		UsuarioBean loginBean = new UsuarioBean();
		loginBean = iLoginService.getUsernamePassword(username, password);

		return new ResponseEntity<>(loginBean, HttpStatus.OK);
	}

	/**
	 * Crea el token de autenticacion
	 * 
	 * @param authenticationRequest - bean con usuario y contraseña
	 * @return - token
	 * @throws Exception - excepcion en caso de que ocurra algun error
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		LOGGER.info("Ejecutando LoginController - createAuthenticationToken()");

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	/**
	 *  Autenticacion del usuario y contraseña del usuario
	 * 
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @throws Exception - excepcion en caso de que ocurra algun error
	 */
	private void authenticate(String username, String password) throws Exception {
		
		LOGGER.info("Ejecutando LoginController - authenticate()");
		
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

}
