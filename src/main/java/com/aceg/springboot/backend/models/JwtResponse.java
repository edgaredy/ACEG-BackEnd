/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

/**
 * - Descripcion: Clase JwtResponse que contiene el token - response
 * - Numero de Metodos: 2
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public class JwtResponse implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -8091879091924046844L;
	
	/**
	 * token del usuario 
	 */
	private final String jwttoken;

	/**
	 * 
	 * @param jwttoken the jwttoken to set
	 */
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	/**
	 * @return the jwttoken
	 */
	public String getToken() {
		return this.jwttoken;
	}
}