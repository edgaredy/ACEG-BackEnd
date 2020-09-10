/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.cliente;

import java.io.Serializable;

/**
 * - Descripcion: Clase ClienteBeanFirstExt que contiene algunos atributos de la
 * tabla de la DB
 * - Numero de Metodos: 8
 * - Nombre de la tabla: ACEG_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class ClienteBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -4230238004884590322L;

	/**
	 * telefono del carnicero
	 */
	private String telefono;

	/**
	 * direccion del carnicero
	 */
	private String direccion;

	/**
	 * codigo postal de la vivienda del carnicero
	 */
	private String cp;

	/**
	 * id del estado en el que vive el carnicero
	 */
	private Integer idEstado;

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

	/**
	 * @return the idEstado
	 */
	public Integer getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

}
