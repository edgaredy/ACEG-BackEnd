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
 * nuevo usuario asi como la validacion de la existencia del mismo - Numero de
 * Metodos: 4
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

	@Autowired
	PasswordEncoder encoder;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);

	/**
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UsuarioBean usuario) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - registerUser()");

		boolean resultado;
		resultado = registroService.existsByUsername(usuario.getEmail());

		if (resultado) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: El email ya esta registrado"));
		}

		Set<String> strRoles = usuario.getRole();
		Set<RoleBean> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "ADMINISTRADOR":
				UsuarioBean usrAdmin = null;
				try {
					roles.add(findByRole(ERole.ADMINISTRADOR));
					usuario.setRoleDb("ADMINISTRADOR");
					usrAdmin = getDataUser(usuario, "ADMINISTRADOR");
					usrAdmin.setRoles(roles);
					registrarUsuario(usrAdmin, "ADMINISTRADOR");
				} catch (AcegServiceException e) {
					e.printStackTrace();
				}
				break;
			case "CARNICERO":
				UsuarioBean usrCarnicero = null;
				try {
					roles.add(findByRole(ERole.CARNICERO));
					usuario.setRoleDb("CARNICERO");
					usrCarnicero = getDataUser(usuario, "CARNICERO");
					usrCarnicero.setRoles(roles);
					registrarUsuario(usrCarnicero, "CARNICERO");
				} catch (AcegServiceException e) {
					e.printStackTrace();
				}
				break;
			case "CLIENTE":
				UsuarioBean usrCliente = null;
				try {
					roles.add(findByRole(ERole.CLIENTE));
					usuario.setRoleDb("CLIENTE");
					usrCliente = getDataUser(usuario, "CLIENTE");
					usrCliente.setRoles(roles);
					registrarUsuario(usrCliente, "CLIENTE");
				} catch (AcegServiceException e) {
					e.printStackTrace();
				}
				break;
			case "PROVEEDOR":
				UsuarioBean usrProveedor = null;
				try {
					roles.add(findByRole(ERole.PROVEEDOR));
					usuario.setRoleDb("PROVEEDOR");
					usrProveedor = getDataUser(usuario, "PROVEEDOR");
					usrProveedor.setRoles(roles);
					registrarUsuario(usrProveedor, "PROVEEDOR");
				} catch (AcegServiceException e) {
					e.printStackTrace();
				}
				break;
			}
		});

		return ResponseEntity.ok(new MessageResponse("Se registro al usuario correctamente"));
	}

	private UsuarioBean getDataUser(UsuarioBean usuario, String role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - getDataUser()");

		UsuarioBean usuarioBean = null;

		if (role.equals("CARNICERO") || role.equals("ADMINISTRADOR")) {
			usuarioBean = new UsuarioBean(usuario.getNombre(), usuario.getApellido(), usuario.getGenero(),
					usuario.getEmail(), encoder.encode(usuario.getPassword()), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getSueldoMensual(), usuario.getIdCarniceria(),
					usuario.getIdEstado(), usuario.getRoleDb());
		} else if (role.equals("CLIENTE")) {
			usuarioBean = new UsuarioBean(usuario.getNombre(), usuario.getApellido(), usuario.getGenero(),
					usuario.getEmail(), encoder.encode(usuario.getPassword()), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getIdEstado(), usuario.getRoleDb());
		} else if (role.equals("PROVEEDOR")) {
			usuarioBean = new UsuarioBean(usuario.getNombreEmpresa(), usuario.getNombre(), usuario.getApellido(),
					usuario.getGenero(), usuario.getEmail(), encoder.encode(usuario.getPassword()),
					usuario.getTelefono(), usuario.getDireccion(), usuario.getCp(), usuario.getRoleDb());
		} else {
			LOGGER.error("Error, no se pudo obtener el rol");
			throw new AcegServiceException("Error, no se encontro el rol");
		}

		return usuarioBean;

	}

	private RoleBean findByRole(ERole role) throws AcegServiceException {

		LOGGER.info("-- Ejecutando RegistroController - findByRole()");

		boolean existe = false;
		RoleBean roleBean = new RoleBean();

		existe = registroService.findByRole(role);

		if (existe == true) {
			roleBean.setRole(role.name());
			roleBean.setName(role);
		} else {
			throw new AcegServiceException("Error, no se encontro el rol");
		}

		return roleBean;
	}

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
