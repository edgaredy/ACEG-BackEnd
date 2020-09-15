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

public final class LoginDbConstants {

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
	 * Constante que realiza un select por username
	 */
	public static final String GETBYUSERNAME = "SELECT * FROM ACEG_USUARIO WHERE EMAIL = ?";

	/**
	 * Constructor privado de la clase
	 */
	private LoginDbConstants() {
	}

}
