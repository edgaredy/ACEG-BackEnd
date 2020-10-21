/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;
import java.util.List;

/**
 * - Descripcion: Clase LoginResponse que contiene la respuesta de tipo LoginResponse
 * - Numero de Metodos: 7
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

public class LoginResponse implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -5507000218568022700L;

	/**
	 * token del usuario
	 */
	private String token;
	
	/**
	 * tipo de token
	 */
	private String type = "Bearer";
	
	/**
	 * id del usuario
	 */
	private Integer id;
	
	/**
	 * email del usuario
	 */
	private String email;
	
	/**
	 * contraseña del usuario
	 */
	private String password;

	/**
	 * Lista de roles del usuario
	 */
	private List<String> roles;

	/**
	 * Constructor publico de la clase
	 * 
	 * @param accessToken - token del usuario
	 * @param id - id del usuario
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @param roles - lista de roles del usuario
	 */
	public LoginResponse(String accessToken, Integer id, String username, String password, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.email = username;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * 
	 * @return the token
	 */
	public String getAccessToken() {
		return token;
	}

	/**
	 * 
	 * @return the type
	 */
	public String getTokenType() {
		return type;
	}

	/**
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @return the email
	 */
	public String getUsername() {
		return email;
	}
	
	/**
	 * 
	 * @return the password
	 */
	public String getpassword() {
		return password;
	}
	
	/**
	 * 
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

}
