/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

/**
 * - Descripcion: Clase JwtRequest que contiene los atributos para la validacion
 * del usuario 
 * - Numero de Metodos: 4
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	/**
	 * nombre de usuario
	 */
	private String username;

	/**
	 * contraseña del usuario
	 */
	private String password;

	// Es necesario el contructor por defecto para el Parseo JSON
	public JwtRequest() {
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param username - nombre de usuario
	 * @param password - contraseña del usuario
	 */
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}