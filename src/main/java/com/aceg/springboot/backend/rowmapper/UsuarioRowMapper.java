/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.UsuarioBean;

/**
 * Clase UsuarioRowMapper que contiene el mapeo de la tabla ACEG_USUARIO de la
 * base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public class UsuarioRowMapper implements RowMapper<UsuarioBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_LOGIN de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return loginBean 	   -  El valor resultante (puede ser null)
	 */
	@Override
	public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - LoginBean");

		UsuarioBean loginBean = new UsuarioBean();

		loginBean.setPassword(rs.getString("ID_USUARIO_PK"));
		loginBean.setUsername(rs.getString("EMAIL"));
		loginBean.setPassword(rs.getString("PASSWORD"));
		loginBean.setPassword(rs.getString("ROLE_FK"));

		return loginBean;
	}

}
