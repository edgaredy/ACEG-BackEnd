/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.RoleBean;

/**
 * Clase RolRowMapper que contiene el mapeo de la tabla ACEG_ROLE de la base de
 * datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

public class RolRowMapper implements RowMapper<RoleBean> {
	
	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RolRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_MUNICIPIO de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return roleBean 	   -  El valor resultante (puede ser null)
	 */
	@Override
	public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LOGGER.info("-- Ejecutando ROW MAPPER - ROLE");
		
		RoleBean roleBean = new RoleBean();
		
		roleBean.setRole(rs.getString("ROLE_PK"));
		roleBean.setDescripcion(rs.getString("DESCRIPCION"));
		
		return roleBean;
	}

}
