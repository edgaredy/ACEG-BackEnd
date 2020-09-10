/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

/**
 * - Descripcion: Clase EstadoBean que contiene los atributos de la tabla 
 * de la DB
 * - Numero de Metodos: 6
 * - Nombre Tabla en DB: ACEG_ESTADO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class EstadoBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -1490569355758388205L;

	/**
	 * id del estado
	 */
	private Integer idEstado;

	/**
	 * nombre del estado
	 */
	private String estado;

	/**
	 * abreviacion del estado
	 */
	private String abreviacion;

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

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the abreviacion
	 */
	public String getAbreviacion() {
		return abreviacion;
	}

	/**
	 * @param abreviacion the abreviacion to set
	 */
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

}
