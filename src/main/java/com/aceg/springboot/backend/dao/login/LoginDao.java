/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegRegistroInexistenteException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.rowmapper.UsuarioRowMapper;
import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.LoginDbConstants;

/**
 * - Descripcion: Clase LoginDao de la aplicacion que implementa la interfaz
 * ILoginDao que realiza consultas a la DB para el acceso de usuario mediante 
 * el login 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@Repository
public class LoginDao implements ILoginDao {

	/**
	 * Referencia hacia JdbcTemplate
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);

	/**
	 * - Verifica la existencia del email en la DB, obtiene los datos del usuario 
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @param username - email del usuario
	 * @return loginBean - bean con datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public UsuarioBean getByUsername(String username) throws AcegDaoException {

		LOGGER.info("Ejecutando LoginDao - getByUsername()");

		UsuarioBean loginBean = null;

		try {
			loginBean = jdbcTemplate.queryForObject(LoginDbConstants.GETBYUSERNAME, new Object[] { username },
					new UsuarioRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERRO_AUT);
		}

		return loginBean;
	}

}
