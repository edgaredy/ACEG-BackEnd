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
 * - Descripcion: Clase CarniceriaCliente que contiene los atributos de la tabla
 * CARNICERIA_CLIENTE la cual es resultado de la ralacion n --> m de las tablas
 * CARNICERIA - CLIENTE
 * 
 * - Nombre Tabla en DB: CARNICERIA_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class CarniceriaCliente implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 6557500973532353610L;

	/**
	 * id del cliente
	 */
	private Integer cliente_id;

	/**
	 * id de la carniceria
	 */
	private Integer carniceria_id;

	/**
	 * @return the cliente_id
	 */
	public Integer getCliente_id() {
		return cliente_id;
	}

	/**
	 * @param cliente_id the cliente_id to set
	 */
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	/**
	 * @return the carniceria_id
	 */
	public Integer getCarniceria_id() {
		return carniceria_id;
	}

	/**
	 * @param carniceria_id the carniceria_id to set
	 */
	public void setCarniceria_id(Integer carniceria_id) {
		this.carniceria_id = carniceria_id;
	}

}
