/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.Carniceria;

/**
 * Clase CarniceriaRowMapper que contiene el mapeo de la tabla CARNICERIA de la
 * base de datos
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */
public class CarniceriaRowMapper implements RowMapper<Carniceria> {

	/**
	 * Metodo que realiza el mapeo de la tabla CLIENTES de la base de datos
	 * 
	 * @param 		rs				- 	el nombre de la columna (pre-inicializado por la fila actual)
	 * @param 		rowNum			-	el numero actual de la fila
	 * @exception 	SQLException	-	Si una SQLException es encontrada al momento de obtener el valor (no es necesario realiza un catch a SQLException)
	 * @return		cliente			- 	El valor resultante (puede ser null)
	 */
	@Override
	public Carniceria mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Carniceria carniceria = new Carniceria();
		
		carniceria.setId(rs.getInt("ID_CARNICERIA_PK"));
		
		
		return null;
	}

}
