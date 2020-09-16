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
	 * Constante que realiza un select por username
	 */
	public static final String GETBYUSERNAME = "SELECT * FROM ACEG_USUARIO WHERE EMAIL = ?";

	/**
	 * Constructor privado de la clase
	 */
	private LoginDbConstants() {
	}

}
