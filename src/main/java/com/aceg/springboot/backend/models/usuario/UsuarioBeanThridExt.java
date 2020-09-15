/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.usuario;

import java.io.Serializable;
import java.util.Set;

/**
 * - Descripcion: Clase UsuarioBeanThridExt que contiene los atributos de las
 * tablas de la DB
 *  - Numero de Metodos: 6
 *  - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 14/09/2020
 */

public class UsuarioBeanThridExt implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -3512137482498091316L;

	/**
	 * nombre de la empresa del usuario - proveedor
	 */
	public String nombreEmpresa;

	/**
	 * role del usuario
	 */
	private Set<String> role;
	
	/**
	 * rol del usuario de la DB
	 */
	public String roleDb;

	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return the role
	 */
	public Set<String> getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Set<String> role) {
		this.role = role;
	}

	/**
	 * @return the roleDb
	 */
	public String getRoleDb() {
		return roleDb;
	}

	/**
	 * @param roleDb the roleDb to set
	 */
	public void setRoleDb(String roleDb) {
		this.roleDb = roleDb;
	}

}
