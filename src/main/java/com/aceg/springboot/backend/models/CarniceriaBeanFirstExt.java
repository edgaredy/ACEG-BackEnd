/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * - Descripcion: Clase CarniceriaBeanFirstExt que contiene algunos atributos de
 * la tabla de la DB
 * 
 * - Numero de Metodos: 4
 * 
 * - Nombre Tabla en DB: ACEG_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
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
