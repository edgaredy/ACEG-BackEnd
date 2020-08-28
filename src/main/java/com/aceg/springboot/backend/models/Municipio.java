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
 * - Descripcion: Clase Municipio que contiene los atributos de la tabla
 * MUNICIPIO
 * 
 * - Nombre Tabla en DB: MUNICIPIO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class Municipio implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -1309289148963681982L;

	/**
	 * id del municipio
	 */
	private Integer id;

	/**
	 * nombre del municipio
	 */
	private String municipio;

	/**
	 * id del estado al que pertenece el municipio
	 */
	private Integer estado_id;

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
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the estado_id
	 */
	public Integer getEstado_id() {
		return estado_id;
	}

	/**
	 * @param estado_id the estado_id to set
	 */
	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}

}
