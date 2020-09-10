/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

/**
 * - Descripcion: Clase UsuarioBean que contiene los atributos de la tabla de
 * la DB 
 * - Numero de Metodos: 8
 * - Nombre de la tabla: ACEG_USUARIO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public class UsuarioBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -710542227816292086L;

	/**
	 * id del usuario
	 */
	private Integer idUsuario;

	/**
	 * username del usuario
	 */
	private String username;

	/**
	 * password del usuario
	 */
	private String password;

	/**
	 * rol del usuario
	 */
	private String role;

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
