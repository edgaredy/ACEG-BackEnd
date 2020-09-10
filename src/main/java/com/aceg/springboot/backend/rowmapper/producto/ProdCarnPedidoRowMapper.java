/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper.producto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.producto.ProductoCarniceriaPedidoBean;

/**
 * Clase ProdCarnPedidoRowMapper que contiene el mapeo de la tabla
 * ACEG_CARNICERIA de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class ProdCarnPedidoRowMapper implements RowMapper<ProductoCarniceriaPedidoBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProdCarnPedidoRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_PROD_CARN_PEDIDO de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return prodCarnPedido  -  El valor resultante (puede ser null)
	 */
	@Override
	public ProductoCarniceriaPedidoBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - ProductoCarniceriaPedido");

		ProductoCarniceriaPedidoBean prodCarnPedido = new ProductoCarniceriaPedidoBean();

		prodCarnPedido.setIdProducto(rs.getInt("ID_PRODUCTO_FK"));
		prodCarnPedido.setIdPedido(rs.getInt("ID_PEDIDO_FK"));
		prodCarnPedido.setIdCarniceria(rs.getInt("ID_CARNICERIA_FK"));
		prodCarnPedido.setIdCliente(rs.getInt("ID_CLIENTE_FK"));
		prodCarnPedido.setIdNota(rs.getInt("ID_NOTA_FK"));

		return prodCarnPedido;
	}

}
