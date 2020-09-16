/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aceg.springboot.backend.dao.login.ILoginDao;
import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;

/**
 * - Descripcion: Clase UserDetailsServiceImpl que contiene los metodos relacionados
 * al registro de un usuario
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * Referencia hacia ILoginDao
	 */
	@Autowired
	private ILoginDao loginDao;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	/**
	 * Verific
	 * 
	 * @param username - nombre de usuario
	 * @return usuario - datos del usuario
	 * @throws UsernameNotFoundException - en caso de que no se encuntre el usuario
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LOGGER.info("Entra UserDetailsServiceImpl - loadUserByUsername()");

		UsuarioBean usuario = null;

		try {
			usuario = loginDao.getByUsername(username);
		} catch (AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new UsernameNotFoundException("Usuario o contraseña no validos, verifica tus credenciales");
		}

		return UserDetailsImpl.build(usuario);
	}

}
