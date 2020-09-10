/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.producto;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProductoCarniceriaBean que contiene los atributos de la
 * tabla de la DB
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_PROD_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class ProductoCarniceriaBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -8007287275534200420L;

	/**
	 * id del producto de la carniceria
	 */
	private Integer idProducto;

	/**
	 * nombre del producto
	 */
	private String producto;

	/**
	 * precio del prodcuto por kilo
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
	 * @return the idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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
