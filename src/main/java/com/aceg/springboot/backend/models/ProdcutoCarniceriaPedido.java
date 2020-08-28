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
 * - Descripcion: Clase ProdcutoCarniceriaPedido que contiene los atributos de
 * la tabla PROD_CAR_PED la cual es resultado de la ralacion n --> m de las
 * tablas PROD_CARNICERIA - PEDIDO
 * 
 * - Nombre Tabla en DB: PROD_CAR_PED
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProdcutoCarniceriaPedido implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -9070930472818906173L;

	/**
	 * id del prodcuto de la carniceria
	 */
	private Integer prod_carniceria_id;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer pedido_id;

	/**
	 * id de la carniceria a la que se le adeuda el pedido
	 */
	private Integer pedido_carniceria_id;

	/**
	 * id del cleinte que adeuda el pedido
	 */
	private Integer pedido_cliente_id;

	/**
	 * id del pedido
	 */
	private Integer pedido_id_pedido;

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

	/**
	 * @return the pedido_id
	 */
	public Integer getPedido_id() {
		return pedido_id;
	}

	/**
	 * @param pedido_id the pedido_id to set
	 */
	public void setPedido_id(Integer pedido_id) {
		this.pedido_id = pedido_id;
	}

	/**
	 * @return the pedido_carniceria_id
	 */
	public Integer getPedido_carniceria_id() {
		return pedido_carniceria_id;
	}

	/**
	 * @param pedido_carniceria_id the pedido_carniceria_id to set
	 */
	public void setPedido_carniceria_id(Integer pedido_carniceria_id) {
		this.pedido_carniceria_id = pedido_carniceria_id;
	}

	/**
	 * @return the pedido_cliente_id
	 */
	public Integer getPedido_cliente_id() {
		return pedido_cliente_id;
	}

	/**
	 * @param pedido_cliente_id the pedido_cliente_id to set
	 */
	public void setPedido_cliente_id(Integer pedido_cliente_id) {
		this.pedido_cliente_id = pedido_cliente_id;
	}

	/**
	 * @return the pedido_id_pedido
	 */
	public Integer getPedido_id_pedido() {
		return pedido_id_pedido;
	}

	/**
	 * @param pedido_id_pedido the pedido_id_pedido to set
	 */
	public void setPedido_id_pedido(Integer pedido_id_pedido) {
		this.pedido_id_pedido = pedido_id_pedido;
	}

}
