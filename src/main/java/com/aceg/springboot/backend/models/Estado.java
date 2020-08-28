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
 * - Descripcion: Clase Estado que contiene los atributos de la tabla ESTADO
 * 
 * - Nombre Tabla en DB: ESTADO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class Estado implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -1490569355758388205L;

	/**
	 * id del estado
	 */
	private Integer id;

	/**
	 * nombre del estado
	 */
	private String estado;

	/**
	 * abreviacion del estado
	 */
	private String abreviacion;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
