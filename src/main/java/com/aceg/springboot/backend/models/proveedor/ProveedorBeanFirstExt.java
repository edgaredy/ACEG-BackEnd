/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.proveedor;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProveedorBeanFirstExt que contiene los atributos de la
 * tabla de la DB
 * - Numero de Metodos: 8
 * - Nombre de la tabla: ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class ProveedorBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -8239627845674933577L;

	/**
	 * email del proveedor
	 */
	private String email;

	/**
	 * telefono del proveedor
	 */
	private String telefono;

	/**
	 * direccion del proveedor
	 */
	private String direccion;

	/**
	 * codigo postal del proveedor
	 */
	private String cp;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

}
