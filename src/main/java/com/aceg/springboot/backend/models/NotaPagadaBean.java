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
 * - Descripcion: Clase NotaPagadaBean que contiene los atributos de la tabla de
 * la DB, esta clase hereda los metodos y atributos de la clase
 * NotaPagadaBeanFirstExt
 * 
 * - Numero de Metodos: 10
 * 
 * - Nombre Tabla en DB: ACEG_NOTA_PAGADA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class NotaPagadaBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -4727206115988294410L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer idNota;

	/**
	 * id de la nota pagada
	 */
	private Integer idNotaProv;

	/**
	 * fecha en la que se realizo la compra del producto
	 */
	private Date fechaCompraProd;

	/**
	 * fecha en que se realizo el pago del prodcuto
	 */
	private Date fechaPagoProd;

	/**
	 * peso del prodcuto en kg
	 */
	private String pesoProducto;

	/**
	 * @return the idNota
	 */
	public Integer getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	/**
	 * @return the idNotaProv
	 */
	public Integer getIdNotaProv() {
		return idNotaProv;
	}

	/**
	 * @param idNotaProv the idNotaProv to set
	 */
	public void setIdNotaProv(Integer idNotaProv) {
		this.idNotaProv = idNotaProv;
	}

	/**
	 * @return the fechaCompraProd
	 */
	public Date getFechaCompraProd() {
		return fechaCompraProd;
	}

	/**
	 * @param fechaCompraProd the fechaCompraProd to set
	 */
	public void setFechaCompraProd(Date fechaCompraProd) {
		this.fechaCompraProd = fechaCompraProd;
	}

	/**
	 * @return the fechaPagoProd
	 */
	public Date getFechaPagoProd() {
		return fechaPagoProd;
	}

	/**
	 * @param fechaPagoProd the fechaPagoProd to set
	 */
	public void setFechaPagoProd(Date fechaPagoProd) {
		this.fechaPagoProd = fechaPagoProd;
	}

	/**
	 * @return the pesoProducto
	 */
	public String getPesoProducto() {
		return pesoProducto;
	}

	/**
	 * @param pesoProducto the pesoProducto to set
	 */
	public void setPesoProducto(String pesoProducto) {
		this.pesoProducto = pesoProducto;
	}

}
