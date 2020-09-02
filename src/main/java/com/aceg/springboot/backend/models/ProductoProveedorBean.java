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
 * - Descripcion: Clase ProductoProveedorBean que contiene los atributos de la
 * tabla de la DB
 * 
 * - Numero de Metodos: 10
 * 
 * - Nombre Tabla en DB: ACEG_PROD_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProductoProveedorBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -7054398586553668072L;

	/**
	 * id del producto
	 */
	private Integer idProduProv;

	/**
	 * nombre del producto
	 */
	private String producto;

	/**
	 * precio del producto en kg
	 */
	private Integer precio;

	/**
	 * tipo de carne del producto (res/cerdo)
	 */
	private String tipoCarne;

	/**
	 * descripcion del producto
	 */
	private String descripcion;

	/**
	 * @return the idProduProv
	 */
	public Integer getIdProduProv() {
		return idProduProv;
	}

	/**
	 * @param idProduProv the idProduProv to set
	 */
	public void setIdProduProv(Integer idProduProv) {
		this.idProduProv = idProduProv;
	}

	/**
	 * @return the prodcuto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param prodcuto the prodcuto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the precio
	 */
	public Integer getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	/**
	 * @return the tipoCarne
	 */
	public String getTipoCarne() {
		return tipoCarne;
	}

	/**
	 * @param tipoCarne the tipoCarne to set
	 */
	public void setTipoCarne(String tipoCarne) {
		this.tipoCarne = tipoCarne;
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
