/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * - Descripcion: Clase Pedido que contiene los atributos de la tabla PEDIDO
 * 
 * - Nombre Tabla en DB: PEDIDO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class Pedido implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -1794868730719425455L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer id;

	/**
	 * id del pedido
	 */
	private Integer id_pedido;

	/**
	 * peso del producto en kg
	 */
	private Integer peso_total_kg;

	/**
	 * fecha de entrega del pedido
	 */
	private Date fecha_entrega;

	/**
	 * costo total del pedido
	 */
	private Integer total;

	/**
	 * descricpion del pedido
	 */
	private String descripcion;

	/**
	 * id de la carniceria que tiene el pedido
	 */
	private Integer carniceria_id;

	/**
	 * id del cliente que realizo el pedidoF
	 */
	private Integer cliente_id;

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
	 * @return the id_pedido
	 */
	public Integer getId_pedido() {
		return id_pedido;
	}

	/**
	 * @param id_pedido the id_pedido to set
	 */
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	/**
	 * @return the peso_total_kg
	 */
	public Integer getPeso_total_kg() {
		return peso_total_kg;
	}

	/**
	 * @param peso_total_kg the peso_total_kg to set
	 */
	public void setPeso_total_kg(Integer peso_total_kg) {
		this.peso_total_kg = peso_total_kg;
	}

	/**
	 * @return the fecha_entrega
	 */
	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	/**
	 * @param fecha_entrega the fecha_entrega to set
	 */
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

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

}
