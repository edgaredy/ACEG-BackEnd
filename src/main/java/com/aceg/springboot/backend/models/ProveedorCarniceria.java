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
 * - Descripcion: Clase ProveedorCarniceria que contiene los atributos de la
 * tabla PROVEEDOR_CARNICERIA la cual es resultado de la ralacion n --> m de las
 * tablas CARNICERIA - PROVEEDOR
 * 
 * - Nombre Tabla en DB: PROVEEDOR_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProveedorCarniceria implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -6616559989301127686L;

	/**
	 * id del proveedor
	 */
	private Integer proveedor_id;

	/**
	 * id de la carniceria
	 */
	private Integer carniceria_id;

	/**
	 * @return the proveedor_id
	 */
	public Integer getProveedor_id() {
		return proveedor_id;
	}

	/**
	 * @param proveedor_id the proveedor_id to set
	 */
	public void setProveedor_id(Integer proveedor_id) {
		this.proveedor_id = proveedor_id;
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
