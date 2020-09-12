/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.exception;

import com.aceg.springboot.backend.util.ErrorEnum;

/**
 * - Descripcion: Clase AcegServiceException para la excepcion de la capa de
 * negocio de los metodos de ACEG 
 * - Numero de Metodos: 9
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 11/09/2020
 */

public class AcegServiceException extends Exception {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = 2929646604362360166L;

	/**
	 * Numero del codigo de error
	 */
	private String code;

	/**
	 * Enumerado de error
	 */
	private ErrorEnum error;

	/**
	 * Constructor
	 * 
	 * @param message Mensaje de error
	 */
	public AcegServiceException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param code    Codigo de error
	 * @param message Mensaje de error
	 */
	public AcegServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * Constructor
	 * 
	 * @param message Mensaje de error
	 * @param causa   Causa completa del error
	 */
	public AcegServiceException(String message, Throwable causa) {
		super(message, causa);
	}

	/**
	 * Constructor que la interfaz del enumerador de error
	 * 
	 * @param errorEnum Interfaz de enumerador de error
	 */
	public AcegServiceException(ErrorEnum errorEnum) {
		super(errorEnum.getMessage());
		this.error = errorEnum;
	}

	/**
	 * Constructor que la interfaz del enumerador de error
	 * 
	 * @param errorEnum Interfaz de enumerador de error
	 * @param causa     Causa completa del error
	 */
	public AcegServiceException(ErrorEnum errorEnum, Throwable causa) {
		super(errorEnum.getMessage(), causa);
	}

	/**
	 * Enumerado de error
	 * 
	 * @return enumerado de errores
	 */
	public ErrorEnum getError() {
		return error;
	}

	/**
	 * Enumerado de error
	 * 
	 * @param error enumerado de errores
	 */
	public void setError(ErrorEnum error) {
		this.error = error;
	}

	/**
	 * Codigo de error
	 * 
	 * @return codigo de error
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Codigo de error
	 * 
	 * @param code codigo de error
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
