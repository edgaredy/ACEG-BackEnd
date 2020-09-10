/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aceg.springboot.backend.models.UsuarioBean;
import com.aceg.springboot.backend.rowmapper.UsuarioRowMapper;
import com.aceg.springboot.backend.util.LoginDbConstantes;

/**
 * - Descripcion: Clase JwtUserDetailsService de la aplicacion que implementa la interfaz
 * UserDetailsService 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@Service
@Repository
public class JwtUserDetailsService implements UserDetailsService {

	/**
	 * Varible para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUserDetailsService.class);

	/**
	 * Referencia hacia JdbcTemplate
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Verifica la existencia del usuario y contraseña realizando una consulta a la DB
	 * 
	 * @param username - nombre del usuario
	 * @exception RuntimeException - excepcion en caso de algun fallo
	 * @exception UsernameNotFoundException - excepcion en caso de que no se encuentra el usuario / contraseña
	 * @return - el usuario y contraseña
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LOGGER.debug("Ejecutando UserDetails - loadUserByUsername()");

		UsuarioBean loginBean = null;

		try {
			loginBean = jdbcTemplate.queryForObject(LoginDbConstantes.GETBYUSERNAME, new Object[] { username },
					new UsuarioRowMapper());
		} catch (Exception ex) {
			LOGGER.error("El usuario o contraseña no existen, verifica tus credenciales");
			throw new RuntimeException("El usuario o contraseña no existen, verifica tus credenciales");
		}

		if (loginBean.getUsername().equals(username)) {
			return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("El usuario o contraseña no existen, verifica tus credenciales");
		}

		/*
		 * if ("javainuse".equals(username)) { return new User("javainuse",
		 * "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new
		 * ArrayList<>()); } else { throw new
		 * UsernameNotFoundException("User not found with username: " + username); }
		 */
	}

}