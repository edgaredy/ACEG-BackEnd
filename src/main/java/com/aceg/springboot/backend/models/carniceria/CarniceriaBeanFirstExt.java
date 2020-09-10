/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carniceria;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarniceriaBeanFirstExt que contiene algunos atributos de
 * la tabla de la DB
 * - Numero de Metodos: 4
 * - Nombre de la tabla: ACEG_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class CarniceriaBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 7597111743360998938L;

	/**
	 * descripcion de la carniceria
	 */
	private String descripcion;

	/**
	 * id del estado al que pertenece la carniceria
	 */
	private String idEstado;

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
	 * @return the idEstado
	 */
	public String getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

}
