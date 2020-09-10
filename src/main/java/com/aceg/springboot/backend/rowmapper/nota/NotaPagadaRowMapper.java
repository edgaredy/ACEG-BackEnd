/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper.nota;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.nota.NotaPagadaBean;

/**
 * Clase NotaPagadaRowMapper que contiene el mapeo de la tabla ACEG_CARNICERIA
 * de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class NotaPagadaRowMapper implements RowMapper<NotaPagadaBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaPagadaRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_NOTA_PAGADA de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return notaPagada 	   -  El valor resultante (puede ser null)
	 */
	@Override
	public NotaPagadaBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - NotaPagada");

		NotaPagadaBean notaPagada = new NotaPagadaBean();

		notaPagada.setIdNota(rs.getInt("ID_NOTA_PK"));
		notaPagada.setIdNotaProv(rs.getInt("ID_NOTA_PROV_PK"));
		notaPagada.setFechaCompraProd(rs.getDate("FECHA_COMPRA_PROD"));
		notaPagada.setFechaPagoProd(rs.getDate("FECHA_PAGO_PROD"));
		notaPagada.setPesoProducto(rs.getString("PESO_PROD_KG"));
		notaPagada.setTotal(rs.getInt("TOTAL"));
		notaPagada.setDescripcion(rs.getString("DESCRIPCION"));
		notaPagada.setIdCarnicero(rs.getInt("ID_CARNICERO_FK"));
		notaPagada.setIdCarniceria(rs.getInt("ID_CARNICERIA_FK"));

		return notaPagada;
	}

}
