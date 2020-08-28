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
 * - Descripcion: Clase NotaPagada que contiene los atributos de la tabla
 * NOTA_PAGADA
 * 
 * - Nombre Tabla en DB: NOTA_PAGADA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class NotaPagada implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -4727206115988294410L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer id;

	/**
	 * id de la nota pagada
	 */
	private Integer id_nota;

	/**
	 * fecha en la que se realizo la compra del producto
	 */
	private Date fecha_compra_producto;

	/**
	 * fecha en que se realizo el pago del prodcuto
	 */
	private Date fecha_pago_producto;

	/**
	 * peso del prodcuto
	 */
	private String peso_producto;

	/**
	 * costo total del producto
	 */
	private Integer total;

	/**
	 * descripcion de la nota pagada
	 */
	private String descripcion;

	/**
	 * id del carnicero que realizo la compra
	 */
	private Integer carnicero_id;

	/**
	 * id de la carniceria del carnicero que realizo la compra
	 */
	private Integer carnicero_carniceria_id;

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
	 * @return the id_nota
	 */
	public Integer getId_nota() {
		return id_nota;
	}

	/**
	 * @param id_nota the id_nota to set
	 */
	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}

	/**
	 * @return the fecha_compra_producto
	 */
	public Date getFecha_compra_producto() {
		return fecha_compra_producto;
	}

	/**
	 * @param fecha_compra_producto the fecha_compra_producto to set
	 */
	public void setFecha_compra_producto(Date fecha_compra_producto) {
		this.fecha_compra_producto = fecha_compra_producto;
	}

	/**
	 * @return the fecha_pago_producto
	 */
	public Date getFecha_pago_producto() {
		return fecha_pago_producto;
	}

	/**
	 * @param fecha_pago_producto the fecha_pago_producto to set
	 */
	public void setFecha_pago_producto(Date fecha_pago_producto) {
		this.fecha_pago_producto = fecha_pago_producto;
	}

	/**
	 * @return the peso_producto
	 */
	public String getPeso_producto() {
		return peso_producto;
	}

	/**
	 * @param peso_producto the peso_producto to set
	 */
	public void setPeso_producto(String peso_producto) {
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
	 * @return the carnicero_id
	 */
	public Integer getCarnicero_id() {
		return carnicero_id;
	}

	/**
	 * @param carnicero_id the carnicero_id to set
	 */
	public void setCarnicero_id(Integer carnicero_id) {
		this.carnicero_id = carnicero_id;
	}

	/**
	 * @return the carnicero_carniceria_id
	 */
	public Integer getCarnicero_carniceria_id() {
		return carnicero_carniceria_id;
	}

	/**
	 * @param carnicero_carniceria_id the carnicero_carniceria_id to set
	 */
	public void setCarnicero_carniceria_id(Integer carnicero_carniceria_id) {
		this.carnicero_carniceria_id = carnicero_carniceria_id;
	}

}
