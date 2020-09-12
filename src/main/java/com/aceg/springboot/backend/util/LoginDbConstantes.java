/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.util;

/**
 * - Descripcion: Clase LoginDbConstantes que contiene las constantes de datos
 * de ACEG 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public final class LoginDbConstantes {

	/**
	 * Constante SELECT
	 */
	public static final String SELECT = "SELECT ";
	
	/**
	 * Constante INSERT
	 */
	public static final String INSERT = "INSERT ";
	
	/**
	 * Constante UPDATE
	 */
	public static final String UPDATE = "UPDATE ";
	
	/**
	 * Constante DELETE
	 */
	public static final String DELETE = "DELETE ";
	
	/**
	 * Constante INTO
	 */
	public static final String IN_TO = "INTO ";
	
	/**
	 * Constante VALUES
	 */
	public static final String VALUES = "VALUES ";
	
	/**
	 * Constante FROM
	 */
	public static final String FROM = "FROM ";
	
	/**
	 * Constante WHERE
	 */
	public static final String WHERE = "WHERE ";
	
	/**
	 * Constante ORDER BY
	 */
	public static final String ORDER_BY = "ORDER BY ";
	
	/**
	 * Constante que contiene el query para insertar un carnicero
	 */
	public static final String INSERT_CARNICERO = queryInsertCarnicero();
	
	/**
	 * Constante que realiza un select por username 
	 */
	public static final String GETBYUSERNAME = "SELECT * FROM LOGIN WHERE USERNAME = ?";
	
	/**
	 * Constructor privado de la clase
	 */
	private LoginDbConstantes () {
	}

	/**
	 * - Metodo que contiene la consulta para insertar un nuevo carnicero en la DB -
	 * - Nombre de tabla: ACEG_CARNICERO
	 * 
	 * @return - Insert_carnicero query en formato string
	 */
	public static String queryInsertCarnicero() {

		StringBuilder query = new StringBuilder();

		query.append(INSERT);
		query.append(IN_TO);
		query.append("ACEG_CARNICERO ");
		query.append("(NOMBRE, ");
		query.append("APELLIDO, ");
		query.append("GENERO, ");
		query.append("EMAIL, ");
		query.append("TELEFONO, ");
		query.append("DIRECCION, ");
		query.append("CP, ");
		query.append("SUELDO_MENSUAL, ");
		query.append("ID_CARNICERIA_FK, ");
		query.append("ID_ESTADO_FK) ");
		query.append(VALUES);
		query.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		return query.toString();
	}

}
