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
import com.aceg.springboot.backend.util.ERole;
import com.aceg.springboot.backend.util.MessageResponse;

/**
 * - Descripcion: Clase RegistroController para le gestion de registro de un
 * nuevo usuario asi como la validacion de la existencia del mismo
 *  - Numero de Metodos: 4
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@RestController
@RequestMapping("/aceg/api")
public class RegistroController {

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
			return ResponseEntity.badRequest().body(new MessageResponse("Error: El email ya esta registrado"));
		}

		Set<RoleBean> roles = new HashSet<>();
		String role = usuario.getRole();
		UsuarioBean datosUsuario = null;

		switch (role) {
		case "ADMINISTRADOR":
			UsuarioBean usrAdmin = null;
			try {
				roles.add(findByRole(ERole.ADMINISTRADOR));
				usrAdmin = createInstance(usuario, "ADMINISTRADOR");
				usrAdmin.setRole("ADMINISTRADOR");
				usrAdmin.setRoles(roles);
				datosUsuario = usrAdmin;
				registrarUsuario(usrAdmin, "ADMINISTRADOR");
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		case "CARNICERO":
			UsuarioBean usrCarnicero = null;
			try {
				roles.add(findByRole(ERole.CARNICERO));
				usrCarnicero = createInstance(usuario, "CARNICERO");
				usrCarnicero.setRole("CARNICERO");
				usrCarnicero.setRoles(roles);
				datosUsuario = usrCarnicero;
				registrarUsuario(usrCarnicero, "CARNICERO");
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		case "CLIENTE":
			UsuarioBean usrCliente = null;
			try {
				roles.add(findByRole(ERole.CLIENTE));
				usrCliente = createInstance(usuario, "CLIENTE");
				usrCliente.setRole("CLIENTE");
				usrCliente.setRoles(roles);
				datosUsuario = usrCliente;
				registrarUsuario(usrCliente, "CLIENTE");
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		case "PROVEEDOR":
			UsuarioBean usrProveedor = null;
			try {
				roles.add(findByRole(ERole.PROVEEDOR));
				usrProveedor = createInstance(usuario, "PROVEEDOR");
				usrProveedor.setRole("PROVEEDOR");
				usrProveedor.setRoles(roles);
				datosUsuario = usrProveedor;
				registrarUsuario(usrProveedor, "PROVEEDOR");
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		}

		return new ResponseEntity<>(datosUsuario, HttpStatus.OK);
	}

	/**
	 * Metodo que crea un nueva instancia de la clase UsuarioBean dependiendo del  
	 * tipo de rol del usuario (CARNICERO, ADMINISTRADOR, CLIENTE, PROVEEDOR)
	 * 
	 * @param usuario - bean con los datos del usuario
	 * @param role - rol del usuario
	 * @return - bean con los datos especificos del usuario
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	private UsuarioBean createInstance(UsuarioBean usuario, String role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - getDataUser()");

		UsuarioBean usuarioBean = null;

		if (role.equals("CARNICERO") || role.equals("ADMINISTRADOR")) {
			usuarioBean = new UsuarioBean(usuario.getNombre(), usuario.getApellido(), usuario.getGenero(),
					usuario.getEmail(), encoder.encode(usuario.getPassword()), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getSueldoMensual(), usuario.getIdCarniceria(),
					usuario.getIdEstado(), usuario.getRole());
		} else if (role.equals("CLIENTE")) {
			usuarioBean = new UsuarioBean(usuario.getNombre(), usuario.getApellido(), usuario.getGenero(),
					usuario.getEmail(), encoder.encode(usuario.getPassword()), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getIdEstado(), usuario.getRole());
		} else if (role.equals("PROVEEDOR")) {
			usuarioBean = new UsuarioBean(usuario.getNombreEmpresa(), usuario.getNombre(), usuario.getApellido(),
					usuario.getGenero(), usuario.getEmail(), encoder.encode(usuario.getPassword()),
					usuario.getTelefono(), usuario.getDireccion(), usuario.getCp(), usuario.getRole());
		} else {
			LOGGER.error("Error, no se pudo obtener el rol");
			throw new AcegServiceException("Error, no se encontro el rol");
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
			throw new AcegServiceException("Error, no se encontro el rol");
		}

		return roleBean;
	}

	/**
	 * Metodo que realiza el registro de un usuario en la DB
	 * 
	 * @param usuario - bean con los datos del usuario a registrar 
	 * @param role - rol del usuario
	 * @throws AcegServiceException - excepcion de capa de servicio
	 */
	private void registrarUsuario(UsuarioBean usuario, String role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - registrarUsuario()");

		switch (role) {
		case "ADMINISTRADOR":
			try {
				registroService.registrarUsuario(usuario, ERole.ADMINISTRADOR);
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		case "CARNICERO":
			try {
				registroService.registrarUsuario(usuario, ERole.CARNICERO);
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		case "CLIENTE":
			try {
				registroService.registrarUsuario(usuario, ERole.CLIENTE);
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		case "PROVEEDOR":
			try {
				registroService.registrarUsuario(usuario, ERole.PROVEEDOR);
			} catch (AcegServiceException e) {
				e.printStackTrace();
			}
			break;
		}

	}

}
