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
 * - Descripcion: Clase NotaAdeudadaBeanFirstExt que contiene los atributos de
 * la tabla de la DB
 * 
 * - Numero de Metodos: 6
 * 
 * - Nombre Tabla en DB: ACEG_NOTA_ADEUDADA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class NotaAdeudadaBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -71258794673390545L;

	/**
	 * descripcion de la nota adeudada
	 */
	private String descripcion;

	/**
	 * id del carnicero que adeuda la nota
	 */
	private Integer idCarnicero;

	/**
	 * id de la carniceria donde trabaja el carnicero que adeuda la nota
	 */
	private Integer idCarniceria;

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
	 * @return the idCarnicero
	 */
	public Integer getIdCarnicero() {
		return idCarnicero;
	}

	/**
	 * @param idCarnicero the idCarnicero to set
	 */
	public void setIdCarnicero(Integer idCarnicero) {
		this.idCarnicero = idCarnicero;
	}

	/**
	 * @return the idCarniceria
	 */
	public Integer getIdCarniceria() {
		return idCarniceria;
	}

	/**
	 * @param idCarniceria the idCarniceria to set
	 */
	public void setIdCarniceria(Integer idCarniceria) {
		this.idCarniceria = idCarniceria;
	}

}
