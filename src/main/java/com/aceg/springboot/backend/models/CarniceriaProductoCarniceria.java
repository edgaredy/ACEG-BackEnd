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
 * - Descripcion: Clase CarniceriaProductoCarniceria que contiene los atributos
 * de la tabla CARN_PROD_CARN la cual es resultado de la ralacion n --> m de las
 * tablas CARNICERIA - PROD_CARNICERIA
 * 
 * - Nombre Tabla en DB: CARN_PROD_CARN
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class CarniceriaProductoCarniceria implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 2206774566367473749L;

	/**
	 * id de la carniceria
	 */
	private Integer carniceria_id;

	/**
	 * id del producto de la carniceria
	 */
	private Integer prod_carniceria_id;

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

	/**
	 * @return the prod_carniceria_id
	 */
	public Integer getProd_carniceria_id() {
		return prod_carniceria_id;
	}

	/**
	 * @param prod_carniceria_id the prod_carniceria_id to set
	 */
	public void setProd_carniceria_id(Integer prod_carniceria_id) {
		this.prod_carniceria_id = prod_carniceria_id;
	}

}
