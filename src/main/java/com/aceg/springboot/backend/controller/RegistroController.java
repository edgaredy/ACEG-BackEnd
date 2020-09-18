/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.RoleBean;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.service.registro.IRegistroService;
import com.aceg.springboot.backend.util.AcegConstantes;
import com.aceg.springboot.backend.util.ERole;
import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.MessageResponse;

/**
 * - Descripcion: Clase RegistroController para le gestion de registro de un
 * nuevo usuario asi como la validacion de la existencia del mismo 
 * - Numero de Metodos: 4
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@RestController
@RequestMapping("/aceg/api")
public class RegistroController {
	
	/**
	 * Constante Parametro invalido
	 */
	private static final String INVALID_PARAM = "Parametro invalido";

	/**
	 * Referencia hacia IRegistroService
	 */
	@Autowired
	private IRegistroService registroService;
	
	/**
	 * Referencia hacia PasswordEncoder
	 */
	@Autowired
	PasswordEncoder encoder;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);

	/**
	 * Metodo que registra a un nuevo usuario en la DB
	 * 
	 * Valida existencia del usuario en la DB 
	 * Valida existencia del rol del usuario
	 * Registra al nuevo usuario
	 * 
	 * @param usuario
	 * @return
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	@PostMapping("/registro")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UsuarioBean usuario) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - registerUser()");

		boolean exmailExiste;
		exmailExiste = registroService.existsByUsername(usuario.getEmail());

		if (exmailExiste) {
			LOGGER.error(AcegConstantes.ERROR_EX + "El email ya esta registrado");
			throw new AcegServiceException(ErrorEnum.EXC_ERROR_LOGIN);
		}

		Set<RoleBean> roles = new HashSet<>();
		String role = usuario.getRole();
		UsuarioBean datosUsuario = null;
		
		// encripta la contraseña
		String password = encoder.encode(usuario.getPassword());
		usuario.setPassword(password);

		switch (role) {
		case AcegConstantes.ROLE_ADMINISTRADOR:
			UsuarioBean usrAdmin = null;
			try {
				roles.add(findByRole(ERole.ROLE_ADMINISTRADOR));
				usrAdmin = usuario;
				usrAdmin.setRoles(roles);
				datosUsuario = usrAdmin;
				registrarUsuario(usrAdmin, AcegConstantes.ROLE_ADMINISTRADOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.ROLE_CARNICERO:
			UsuarioBean usrCarnicero = null;
			try {
				roles.add(findByRole(ERole.ROLE_CARNICERO));
				usrCarnicero = usuario;
				usrCarnicero.setRoles(roles);
				datosUsuario = usrCarnicero;
				registrarUsuario(usrCarnicero, AcegConstantes.ROLE_CARNICERO);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.ROLE_CLIENTE:
			UsuarioBean usrCliente = null;
			try {
				roles.add(findByRole(ERole.ROLE_CLIENTE));
				usrCliente = usuario;
				usrCliente.setRoles(roles);
				datosUsuario = usrCliente;
				registrarUsuario(usrCliente, AcegConstantes.ROLE_CLIENTE);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.ROLE_PROVEEDOR:
			UsuarioBean usrProveedor = null;
			try {
				roles.add(findByRole(ERole.ROLE_PROVEEDOR));
				usrProveedor = usuario;
				usrProveedor.setRoles(roles);
				datosUsuario = usrProveedor;
				registrarUsuario(usrProveedor, AcegConstantes.ROLE_PROVEEDOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		default:
			LOGGER.error(INVALID_PARAM);
			return ResponseEntity.badRequest().body(new MessageResponse(AcegConstantes.ERROR_EX + INVALID_PARAM));
		}

		return new ResponseEntity<>(datosUsuario, HttpStatus.OK);
	}

	/**
	 * Metodo que valida la existencia del rol del usuario en la DB
	 * 
	 * @param role - rol del usuario
	 * @return - beanRole con los datos del rol
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	private RoleBean findByRole(ERole role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - findByRole()");

		boolean rolExiste = false;
		RoleBean roleBean = new RoleBean();

		rolExiste = registroService.findByRole(role);

		if (rolExiste) {
			roleBean.setRole(role.name());
			roleBean.setName(role);
		} else {
			LOGGER.error(INVALID_PARAM);
			throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
		}

		return roleBean;
	}

	/**
	 * Metodo que realiza el registro de un usuario en la DB
	 * 
	 * @param usuario - bean con los datos del usuario a registrar
	 * @param role    - rol del usuario
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	private void registrarUsuario(UsuarioBean usuario, String role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - registrarUsuario()");

		switch (role) {
		case AcegConstantes.ROLE_ADMINISTRADOR:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_ADMINISTRADOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.ROLE_CARNICERO:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_CARNICERO);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.ROLE_CLIENTE:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_CLIENTE);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.ROLE_PROVEEDOR:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_PROVEEDOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		default:
			LOGGER.error(INVALID_PARAM);
			break;
		}

	}

}
