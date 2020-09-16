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
			return ResponseEntity.badRequest().body(new MessageResponse(AcegConstantes.ERROR_EX + "El email ya esta registrado"));
		}

		Set<RoleBean> roles = new HashSet<>();
		String role = usuario.getRole();
		UsuarioBean datosUsuario = null;

		switch (role) {
		case AcegConstantes.ADMINISTRADOR:
			UsuarioBean usrAdmin = null;
			try {
				roles.add(findByRole(ERole.ROLE_ADMINISTRADOR));
				usrAdmin = createInstance(usuario, AcegConstantes.ADMINISTRADOR);
				usrAdmin.setRole("ROLE_ADMINISTRADOR");
				usrAdmin.setRoles(roles);
				datosUsuario = usrAdmin;
				registrarUsuario(usrAdmin, AcegConstantes.ADMINISTRADOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.CARNICERO:
			UsuarioBean usrCarnicero = null;
			try {
				roles.add(findByRole(ERole.ROLE_CARNICERO));
				usrCarnicero = createInstance(usuario, AcegConstantes.CARNICERO);
				usrCarnicero.setRole("ROLE_CARNICERO");
				usrCarnicero.setRoles(roles);
				datosUsuario = usrCarnicero;
				registrarUsuario(usrCarnicero, AcegConstantes.CARNICERO);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.CLIENTE:
			UsuarioBean usrCliente = null;
			try {
				roles.add(findByRole(ERole.ROLE_CLIENTE));
				usrCliente = createInstance(usuario, AcegConstantes.CLIENTE);
				usrCliente.setRole("ROLE_CLIENTE");
				usrCliente.setRoles(roles);
				datosUsuario = usrCliente;
				registrarUsuario(usrCliente, AcegConstantes.CLIENTE);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.PROVEEDOR:
			UsuarioBean usrProveedor = null;
			try {
				roles.add(findByRole(ERole.ROLE_PROVEEDOR));
				usrProveedor = createInstance(usuario, AcegConstantes.PROVEEDOR);
				usrProveedor.setRole("ROLE_PROVEEDOR");
				usrProveedor.setRoles(roles);
				datosUsuario = usrProveedor;
				registrarUsuario(usrProveedor, AcegConstantes.PROVEEDOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		default:
			LOGGER.error(INVALID_PARAM);
			break;
		}

		return new ResponseEntity<>(datosUsuario, HttpStatus.OK);
	}

	/**
	 * Metodo que crea un nueva instancia de la clase UsuarioBean dependiendo del
	 * tipo de rol del usuario (CARNICERO, ADMINISTRADOR, CLIENTE, PROVEEDOR)
	 * 
	 * @param usuario - bean con los datos del usuario
	 * @param role    - rol del usuario
	 * @return - bean con los datos especificos del usuario
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	private UsuarioBean createInstance(UsuarioBean usuario, String role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - getDataUser()");

		UsuarioBean usuarioBean = null;

		if (role.equals(AcegConstantes.CARNICERO) || role.equals(AcegConstantes.ADMINISTRADOR)) {
			usuarioBean = new UsuarioBean(usuario.getNombre(), usuario.getApellido(), usuario.getGenero(),
					usuario.getEmail(), encoder.encode(usuario.getPassword()), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getSueldoMensual(), usuario.getIdCarniceria(),
					usuario.getIdEstado(), usuario.getRole());
		} else if (role.equals(AcegConstantes.CLIENTE)) {
			usuarioBean = new UsuarioBean(usuario.getNombre(), usuario.getApellido(), usuario.getGenero(),
					usuario.getEmail(), encoder.encode(usuario.getPassword()), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getIdEstado(), usuario.getRole());
		} else if (role.equals(AcegConstantes.PROVEEDOR)) {
			usuarioBean = new UsuarioBean(usuario.getNombreEmpresa(), usuario.getNombre(), usuario.getApellido(),
					usuario.getGenero(), usuario.getEmail(), encoder.encode(usuario.getPassword()),
					usuario.getTelefono(), usuario.getDireccion(), usuario.getCp(), usuario.getRole());
		} else {
			LOGGER.error(INVALID_PARAM);
			throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
		}

		return usuarioBean;

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
		case AcegConstantes.ADMINISTRADOR:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_ADMINISTRADOR);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.CARNICERO:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_CARNICERO);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.CLIENTE:
			try {
				registroService.registrarUsuario(usuario, ERole.ROLE_CLIENTE);
			} catch (AcegServiceException ex) {
				LOGGER.error(AcegConstantes.ERROR_EX, ex);
				throw new AcegServiceException(ErrorEnum.EXC_ERROR_PARAMS);
			}
			break;
		case AcegConstantes.PROVEEDOR:
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
