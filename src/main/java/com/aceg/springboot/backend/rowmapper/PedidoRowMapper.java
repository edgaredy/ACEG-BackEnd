/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.pedido.PedidoBean;

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
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PedidoRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_PEDIDO de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return pedido 		   -  El valor resultante (puede ser null)
	 */
	@Override
	public PedidoBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - Pedido");

		PedidoBean pedido = new PedidoBean();

		pedido.setIdPedido(rs.getInt("ID_PEDIDO_PK"));
		pedido.setIdNota(rs.getInt("ID_NOTA_PK"));
		pedido.setPesoTotal(rs.getInt("PESO_TOTAL_KG"));
		pedido.setFechaEntrega(rs.getDate("FECHA_ENTREGA"));
		pedido.setTotal(rs.getInt("TOTAL"));
		pedido.setDescripcion(rs.getString("DESCRIPCION"));
		pedido.setIdCarniceria(rs.getInt("ID_CARNICERIA_FK"));
		pedido.setIdCliente(rs.getInt("ID_CLIENTE_FK"));

		return pedido;
	}

}
