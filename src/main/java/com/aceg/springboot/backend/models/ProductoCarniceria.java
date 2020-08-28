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
 * - Descripcion: Clase ProductoCarniceria que contiene los atributos de la
 * tabla PROD_CARNICERIA
 * 
 * - Nombre Tabla en DB: PROD_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProductoCarniceria implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -8007287275534200420L;

	/**
	 * id del producto de la carniceria
	 */
	private Integer id;

	/**
	 * nombre del producto
	 */
	private String producto;

	/**
	 * precio del prodcuto por kilo
	 */
	private Integer precio_kg;

	/**
	 * tipo de carne del producto (res/cerdo)
	 */
	private String tipo_carne;

	/**
	 * descripcion del producto
	 */
	private String descripcion;

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
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the precio_kg
	 */
	public Integer getPrecio_kg() {
		return precio_kg;
	}

	/**
	 * @param precio_kg the precio_kg to set
	 */
	public void setPrecio_kg(Integer precio_kg) {
		this.precio_kg = precio_kg;
	}

	/**
	 * @return the tipo_carne
	 */
	public String getTipo_carne() {
		return tipo_carne;
	}

	/**
	 * @param tipo_carne the tipo_carne to set
	 */
	public void setTipo_carne(String tipo_carne) {
		this.tipo_carne = tipo_carne;
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

}
