/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper.carniceria;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.carniceria.CarniceriaClienteBean;

/**
 * Clase CarniceriaClienteRowMapper que contiene el mapeo de la tabla
 * ACEG_CARNICERIA de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class CarniceriaClienteRowMapper implements RowMapper<CarniceriaClienteBean> {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarniceriaClienteRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_CARNICERIA_CLIENTE de la DB
	 * 
	 * @param rs     		     -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   	 -  El numero actual de la fila
	 * @exception SQLException 	 -  Si una SQLException es encontrada al momento de
	 *                         	    obtener el valor (no es necesario realiza un catch a
	 *                         	    SQLException)
	 * @return carniceriaCliente -  El valor resultante (puede ser null)
	 */
	@Override
	public CarniceriaClienteBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - CarniceriaCliente");

		CarniceriaClienteBean carniceriaCliente = new CarniceriaClienteBean();

		carniceriaCliente.setIdCliente(rs.getInt("ID_CLIENTE_FK"));
		carniceriaCliente.setIdCarniceria(rs.getInt("ID_CARNICERIA_FK"));

		return carniceriaCliente;
	}

}
