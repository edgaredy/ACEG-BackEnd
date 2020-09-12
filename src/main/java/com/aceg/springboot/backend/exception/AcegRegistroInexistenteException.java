/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.exception;

import com.aceg.springboot.backend.util.ErrorEnum;

/**
 * - Descripcion: Clase de excepcion de negocio cuando no existe un registro en
 * DB 
 * - Numero de Metodos: 2
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 11/09/2020
 */

public class AcegRegistroInexistenteException extends AcegDaoException {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = 1303454450535514738L;

	/**
	 * Constructor
	 * 
	 * @param code    - Codigo de error
	 * @param message - Mensaje de error
	 */
	public AcegRegistroInexistenteException(String code, String message) {
		super(code, message);
	}

	/**
	 * Constructor de la interfaz del enumerador de error
	 * 
	 * @param errorEnum - Interfaz de enumerador de error
	 */
	public AcegRegistroInexistenteException(ErrorEnum errorEnum) {
		super(errorEnum);
	}
}