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
 * - Descripcion: Clase ProdCarniProdAdeCliente que contiene los atributos de la
 * tabla PROD_CAR_PRO_ADE_CLI la cual es resultado de la ralacion n --> m de las
 * tablas PROD_CARNICERIA - PRO_ADE_CLIENTE
 * 
 * - Nombre Tabla en DB: PROD_CAR_PRO_ADE_CLI
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProdCarniProdAdeCliente implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 521099817535614128L;

	/**
	 * id del producto adeudado del cliente
	 */
	private Integer prod_ade_cliente_id;

	/**
	 * id del cliente que adeuda el producto
	 */
	private Integer pro_ade_cliente_cliente_id;

	/**
	 * id de la carniceria a la que el cliente la adeuda el producto
	 */
	private Integer prod_carniceria_id;

	/**
	 * @return the prod_ade_cliente_id
	 */
	public Integer getProd_ade_cliente_id() {
		return prod_ade_cliente_id;
	}

	/**
	 * @param prod_ade_cliente_id the prod_ade_cliente_id to set
	 */
	public void setProd_ade_cliente_id(Integer prod_ade_cliente_id) {
		this.prod_ade_cliente_id = prod_ade_cliente_id;
	}

	/**
	 * @return the pro_ade_cliente_cliente_id
	 */
	public Integer getPro_ade_cliente_cliente_id() {
		return pro_ade_cliente_cliente_id;
	}

	/**
	 * @param pro_ade_cliente_cliente_id the pro_ade_cliente_cliente_id to set
	 */
	public void setPro_ade_cliente_cliente_id(Integer pro_ade_cliente_cliente_id) {
		this.pro_ade_cliente_cliente_id = pro_ade_cliente_cliente_id;
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
