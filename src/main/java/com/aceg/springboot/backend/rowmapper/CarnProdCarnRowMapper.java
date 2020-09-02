/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.CarnicProdCarnicBean;

/**
 * Clase CarnProdCarnRowMapper que contiene el mapeo de la tabla ACEG_CARNICERIA
 * de la base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
public class CarnProdCarnRowMapper implements RowMapper<CarnicProdCarnicBean> {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarnProdCarnRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_CARNICERIA_PROD_CARN de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return cliente 		   -  El valor resultante (puede ser null)
	 */
	@Override
	public CarnicProdCarnicBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.info("-- Ejecutando ROW MAPPER - CarnicProdCarnic");

		CarnicProdCarnicBean carnProdCarn = new CarnicProdCarnicBean();

		carnProdCarn.setIdCarniceria(rs.getInt("ID_CARNICERIA_FK"));
		carnProdCarn.setIdProducto(rs.getInt("ID_PRODUCTO_FK"));

		return carnProdCarn;
	}

}
