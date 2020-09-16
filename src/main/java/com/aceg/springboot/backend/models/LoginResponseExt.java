/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.util.List;

/**
 * - Descripcion: Clase LoginResponse que contiene el response del metodo login
 * ubicado en LoginController 
 * - Numero de Metodos: 4
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 16/09/2020
 */

public class LoginResponseExt {
	
	/**
	 * contraseña del usuario
	 */
	public String password;

	/**
	 * Lista de roles del usuario
	 */
	public List<String> roles;
	
	/**
	 * 
	 * @return the password
	 */
	public String getpassword() {
		return password;
	}

	/**
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}
	
}
