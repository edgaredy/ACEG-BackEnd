/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

/**
 * - Descripcion: Clase RoleBean que contiene los atributos de la tabla de
 * la DB 
 * - Numero de Metodos: 4
 * - Nombre de la tabla: ACEG_ROLE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class RoleBean implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = 761115879202399448L;

	/**
	 * role del usuario
	 */
	private String role;

	/**
	 * descripcion del role
	 */
	private String descripcion;

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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
