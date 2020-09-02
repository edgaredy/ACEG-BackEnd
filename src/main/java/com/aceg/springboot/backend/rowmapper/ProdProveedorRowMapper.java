/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.ProductoProveedorBean;

/**
 * Clase ProdProveedorRowMapper que contiene el mapeo de la tabla
 * ACEG_CARNICERIA de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
public class ProdProveedorRowMapper implements RowMapper<ProductoProveedorBean> {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProdProveedorRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_PROD_PROVEEDOR de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return cliente 		   -  El valor resultante (puede ser null)
	 */
	@Override
	public ProductoProveedorBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - ProductoProveedor");

		ProductoProveedorBean productoProveedor = new ProductoProveedorBean();

		productoProveedor.setIdProduProv(rs.getInt("ID_PROD_PROV_PK"));
		productoProveedor.setProducto(rs.getString("PRODUCTO"));
		productoProveedor.setPrecio(rs.getInt("PRECIO_KG"));
		productoProveedor.setTipoCarne(rs.getString("TIPO_CARNE"));
		productoProveedor.setDescripcion(rs.getString("DESCRIPCION"));

		return productoProveedor;
	}

}
