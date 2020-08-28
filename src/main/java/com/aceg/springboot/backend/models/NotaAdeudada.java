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
 * - Descripcion: Clase NotaAdeudada que contiene los atributos de la tabla
 * NOTA_ADEUDADA
 * 
 * - Nombre Tabla en DB: NOTA_ADEUDADA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class NotaAdeudada implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 6262847748350731615L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer id;

	/**
	 * id de la nota adeudada
	 */
	private Integer id_nota;

	/**
	 * fecha en que se realiza la compra
	 */
	private Date fecha_compra;

	/**
	 * peso del producto
	 */
	private String peso_producto;

	/**
	 * costo toatal del producto
	 */
	private Integer total;

	/**
	 * descripcion de la nota adeudada
	 */
	private String descripcion;

	/**
	 * id del carnicero que adeuda la nota
	 */
	private Integer carnicero_id;

	/**
	 * id de la carniceria donde trabaja el carnicero que adeuda la nota
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
