/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.ProductoAdeudadoClienteBean;

/**
 * Clase ProdAdeuClienteRowMapper que contiene el mapeo de la tabla
 * ACEG_CARNICERIA de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
public class ProdAdeuClienteRowMapper implements RowMapper<ProductoAdeudadoClienteBean> {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProdAdeuClienteRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_PROD_ADE_CLIENTE de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return cliente 		   -  El valor resultante (puede ser null)
	 */
	@Override
	public ProductoAdeudadoClienteBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - ProductoAdeudadoCliente");

		ProductoAdeudadoClienteBean prodAdeCli = new ProductoAdeudadoClienteBean();

		prodAdeCli.setIdProdAde(rs.getInt("ID_PROD_ADE_PK"));
		prodAdeCli.setFechaCompra(rs.getDate("FECHA_COMPRA"));
		prodAdeCli.setPesoProducto(rs.getInt("PESO_PRODUCTO_KG"));
		prodAdeCli.setTotal(rs.getInt("TOTAL"));
		prodAdeCli.setDescripcion(rs.getString("DESCRIPCION"));
		prodAdeCli.setIdCliente(rs.getInt("ID_CLIENTE_FK"));

		return prodAdeCli;
	}

}
