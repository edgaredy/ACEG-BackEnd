/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceg.springboot.backend.dao.login.ILoginDao;
import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;

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
	 * Obtiene el nombre de usuario 
	 * 
	 * @param username - nombre de usuario
	 * @return - nombre de usuario y contraseña
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	public UsuarioBean getByUsername(String username) throws AcegServiceException {

		LOGGER.info("Entra LoginService - getUsernamePassword()");

		UsuarioBean usuarioBean = null;
		
		try {
			usuarioBean = loginDao.getByUsername(username);
		} catch(AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegServiceException(ex.getError());
		}

		LOGGER.info("Sale LoginService - getUsernamePassword()");

		return usuarioBean;
	}
}
