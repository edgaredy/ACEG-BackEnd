/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper.producto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.producto.ProductoCarniceriaBean;

/**
 * Clase ProdCarniceriaRowMapper que contiene el mapeo de la tabla
 * ACEG_CARNICERIA de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class ProdCarniceriaRowMapper implements RowMapper<ProductoCarniceriaBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProdCarniceriaRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_PROD_CARNICERIA de la DB
	 * 
	 * @param rs     		       -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		       -  El numero actual de la fila
	 * @exception SQLException 	   -  Si una SQLException es encontrada al momento de
	 *                         	      obtener el valor (no es necesario realiza un catch a
	 *                         	      SQLException)
	 * @return productoCarniceria  -  El valor resultante (puede ser null)
	 */
	@Override
	public ProductoCarniceriaBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - ProductoCarniceria");

		ProductoCarniceriaBean productoCarniceria = new ProductoCarniceriaBean();

		productoCarniceria.setIdProducto(rs.getInt("ID_PRODUCTO_PK"));
		productoCarniceria.setProducto(rs.getString("PRODUCTO"));
		productoCarniceria.setPrecio(rs.getInt("PRECIO_KG"));
		productoCarniceria.setTipoCarne(rs.getString("TIPO_CARNE"));
		productoCarniceria.setDescripcion(rs.getString("DESCRIPCION"));

		return productoCarniceria;
	}

}
