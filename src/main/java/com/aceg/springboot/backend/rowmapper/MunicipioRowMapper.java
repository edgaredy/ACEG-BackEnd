/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.municipio.MunicipioBean;

/**
 * Clase MunicipioRowMapper que contiene el mapeo de la tabla ACEG_MUNICIPIO de la
 * base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/10/2020
 */

public class MunicipioRowMapper implements RowMapper<MunicipioBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MunicipioRowMapper.class);

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
	public MunicipioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LOGGER.info("-- Ejecutando ROW MAPPER - MUNICIPIO");
		
		MunicipioBean municipio = new MunicipioBean();
		
		municipio.setId(rs.getInt("ID_MUNICIPIO_PK"));
		municipio.setMunicipio(rs.getString("MUNICIPIO"));
		municipio.setIdEstado(rs.getInt("ID_ESTADO_FK"));
		
		return municipio;
	}

}
