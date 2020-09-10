/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceg.springboot.backend.dao.login.ILoginDao;
import com.aceg.springboot.backend.models.UsuarioBean;

/**
 * - Descripcion: Clase LoginService de la aplicacion que implementa la interfaz
 * ILoginService que realiza consultas a la DB para el acceso de usuario mediante el
 * login 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@Service
public class LoginService implements ILoginService {

	/**
	 * Referencia hacia loginDao
	 */
	@Autowired
	private ILoginDao loginDao;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	/**
	 * Obtiene el nombre de usuario y contraseña del usuario
	 * 
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @return - nombre de usuario y contraseña
	 */
	@Override
	public UsuarioBean getUsernamePassword(String username, String password) {

		LOGGER.debug("Entra getUsernamePassword()");

		UsuarioBean loginBean = null;

		loginBean = loginDao.getUsernamePassword(username, password);

		return loginBean;
	}
}
