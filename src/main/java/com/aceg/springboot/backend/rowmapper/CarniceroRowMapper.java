/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.carnicero.CarniceroBean;

/**
 * Clase CarniceroRowMapper que contiene el mapeo de la tabla ACEG_CARNICERIA de
 * la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class CarniceroRowMapper implements RowMapper<CarniceroBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarniceroRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_CARNICERO de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return carnicero 	   -  El valor resultante (puede ser null)
	 */
	@Override
	public CarniceroBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - Carnicero");

		CarniceroBean carnicero = new CarniceroBean();

		carnicero.setIdCarnicero(rs.getInt("ID_CARNICERO_PK"));
		carnicero.setNombre(rs.getString("NOMBRE"));
		carnicero.setApellido(rs.getString("APELLIDO"));
		carnicero.setGenero(rs.getString("GENERO"));
		carnicero.setEmail(rs.getString("EMAIL"));
		carnicero.setTelefono(rs.getString("TELEFONO"));
		carnicero.setDireccion(rs.getString("DIRECCION"));
		carnicero.setCp(rs.getString("CP"));
		carnicero.setSueldoMensual(rs.getInt("SUELDO_MENSUAL"));
		carnicero.setIdCarniceria(rs.getInt("ID_CARNICERIA_FK"));
		carnicero.setIdEstado(rs.getInt("ID_ESTADO_FK"));
		carnicero.setPassword(rs.getString("PASSWORD"));

		return carnicero;
	}

}
