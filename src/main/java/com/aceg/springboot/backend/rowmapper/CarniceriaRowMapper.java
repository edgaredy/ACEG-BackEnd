/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.CarniceriaBean;

/**
 * Clase CarniceriaRowMapper que contiene el mapeo de la tabla ACEG_CARNICERIA de la
 * base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */
public class CarniceriaRowMapper implements RowMapper<CarniceriaBean> {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarniceriaRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_CARNICERIA de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return cliente 		   -  El valor resultante (puede ser null)
	 */
	@Override
	public CarniceriaBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - Carniceria ");

		CarniceriaBean carniceria = new CarniceriaBean();

		carniceria.setIdCarniceria(rs.getInt("ID_CARNICERIA_PK"));
		carniceria.setNombre(rs.getString("NOMBRE"));
		carniceria.setDireccion(rs.getString("DIRECCION"));
		carniceria.setCp(rs.getString("CP"));
		carniceria.setTelefono(rs.getString("TELEFONO"));
		carniceria.setDescripcion(rs.getString("DESCRIPCION"));
		carniceria.setIdEstado(rs.getString("ID_ESTADO_FK"));

		return carniceria;
	}

}
