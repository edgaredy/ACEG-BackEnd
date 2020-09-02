/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.ProveedorBean;

/**
 * Clase ProveedorRowMapper que contiene el mapeo de la tabla ACEG_CARNICERIA de
 * la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
public class ProveedorRowMapper implements RowMapper<ProveedorBean> {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_PROVEEDOR de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return cliente 		   -  El valor resultante (puede ser null)
	 */
	@Override
	public ProveedorBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - Proveedor");

		ProveedorBean proveedor = new ProveedorBean();

		proveedor.setIdProveedor(rs.getInt("ID_PROVEEDOR_PK"));
		proveedor.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
		proveedor.setNombreProveedor(rs.getString("NOMBRE_PROVEEDOR"));
		proveedor.setApellido(rs.getString("APELLIDO"));
		proveedor.setGenero(rs.getString("GENERO"));
		proveedor.setEmail(rs.getString("EMAIL"));
		proveedor.setTelefono(rs.getString("TELEFONO"));
		proveedor.setDireccion(rs.getString("DIRECCION"));
		proveedor.setCp(rs.getString("CP"));

		return proveedor;
	}

}
