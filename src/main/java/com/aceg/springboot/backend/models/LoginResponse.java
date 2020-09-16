/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;
import java.util.List;

/**
 * - Descripcion: Clase LoginResponse que contiene el response del metodo login
 * ubicado en LoginController 
 * - Numero de Metodos: 10
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

public class LoginResponse extends LoginResponseExt implements Serializable {

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
	 * Constructor publico de la clase
	 * 
	 * @param accessToken - token del usuario
	 * @param id - id del usuario
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @param roles - lista de roles del usuario
	 * @param role - rol del usuario
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
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
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
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.type = tokenType;
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
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the email
	 */
	public String getUsername() {
		return email;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.email = username;
	}

	

}
