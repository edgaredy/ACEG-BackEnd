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
 * - Descripcion: Clase ProvProdcutoProv que contiene los atributos de la tabla
 * PROV_PROD_PROV la cual es resultado de la ralacion n --> m de las tablas
 * PROVEEDOR - PROD_PROVEEDOR
 * 
 * - Nombre Tabla en DB: PROV_PROD_PROV
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProvProdcutoProv implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -2014527372068276047L;

	/**
	 * id del proveedor
	 */
	private Integer proveedor_id;

	/**
	 * id del prodcuto del proveedor
	 */
	private Integer prod_proveedor_id;

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
	 * @return the prod_proveedor_id
	 */
	public Integer getProd_proveedor_id() {
		return prod_proveedor_id;
	}

	/**
	 * @param prod_proveedor_id the prod_proveedor_id to set
	 */
	public void setProd_proveedor_id(Integer prod_proveedor_id) {
		this.prod_proveedor_id = prod_proveedor_id;
	}

}
