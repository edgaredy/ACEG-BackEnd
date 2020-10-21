/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.role;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.aceg.springboot.backend.util.ERole;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * - Descripcion: Clase RoleBean que contiene los atributos de la tabla de la DB
 * - Numero de Metodos: 8
 * - Nombre de la tabla: ACEG_ROLE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
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
	 * nombre del rol del usuario
	 */
	@Enumerated(EnumType.STRING)
	private ERole name;
	
	/**
	 * Constructor vacio de la clase
	 */
	public RoleBean() {
	}
	
	/**
	 * Constructor de la clase con 1 parametro
	 * 
	 * @param name - nombre del rol del usuario
	 */
	public RoleBean(ERole name) {
		this.name = name;
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
	
	/**
	 * 
	 * @return the name
	 */
	public ERole getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(ERole name) {
		this.name = name;
	}

}
