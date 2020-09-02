/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.PedidoBean;

/**
 * Clase PedidoRowMapper que contiene el mapeo de la tabla ACEG_CARNICERIA de la
 * base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
public class PedidoRowMapper implements RowMapper<PedidoBean> {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PedidoRowMapper.class);

	@Override
	public PedidoBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - Pedido");
		
		PedidoBean pedido = new PedidoBean();

		return pedido;
	}

}
