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
 * - Descripcion: Clase ProductoAdeudadoCliente que contiene los atributos de la
 * tabla PROD_ADE_CLIENTE
 * 
 * - Nombre Tabla en DB: PROD_ADE_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProductoAdeudadoCliente implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -2068127581253641997L;

	/**
	 * id del producto adeudado del cliente
	 */
	private Integer id;

	/**
	 * fecha de compra del producto adeudado
	 */
	private Date fecha_compra;

	/**
	 * peso del prodcuto del producto adeudado
	 */
	private Integer peso_producto;

	/**
	 * costo total del prodcuto adeudado
	 */
	private Integer total;

	/**
	 * descripcion del producto adeudado
	 */
	private String descripcion;

	/**
	 * id del cliente que adeuda el producto
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
	 * @return the fecha_compra
	 */
	public Date getFecha_compra() {
		return fecha_compra;
	}

	/**
	 * @param fecha_compra the fecha_compra to set
	 */
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	/**
	 * @return the peso_producto
	 */
	public Integer getPeso_producto() {
		return peso_producto;
	}

	/**
	 * @param peso_producto the peso_producto to set
	 */
	public void setPeso_producto(Integer peso_producto) {
		this.peso_producto = peso_producto;
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
