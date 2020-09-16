/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.util;

/**
 * - Descripcion: Clase MessageResponse que contiene un posible
 * mensaje que de desee añadir en un response
 * - Numero de Metodos: 3
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

public class MessageResponse {
	
	/**
	 * mensaje a enviar
	 */
	private String message;

	/**
	 * constructor publico de la clase
	 * 
	 * @param message - mensaje a enviar
	 */
	public MessageResponse(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message the message to set 
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
