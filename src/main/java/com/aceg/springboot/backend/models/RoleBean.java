/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.aceg.springboot.backend.util.ERole;

/**
 * - Descripcion: Clase RoleBean que contiene los atributos de la tabla de la DB
 * - Numero de Metodos: 4 - Nombre de la tabla: ACEG_ROLE
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

	@Enumerated(EnumType.STRING)
	private ERole name;

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

	public RoleBean() {

	}
	
	public RoleBean(ERole name) {
		this.name = name;
	}
	
	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
