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
public class NotaAdeudadaBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 6262847748350731615L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer idNota;

	/**
	 * id de la nota adeudada
	 */
	private Integer idNotaProv;

	/**
	 * fecha en que se realiza la compra
	 */
	private Date fechaCompra;

	/**
	 * peso del producto
	 */
	private String pesoProducto;

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
	private Integer idCarnicero;

	/**
	 * id de la carniceria donde trabaja el carnicero que adeuda la nota
	 */
	private Integer idCarniceria;

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
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
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
	 * @return the idCarnicero
	 */
	public Integer getIdCarnicero() {
		return idCarnicero;
	}

	/**
	 * @param idCarnicero the idCarnicero to set
	 */
	public void setIdCarnicero(Integer idCarnicero) {
		this.idCarnicero = idCarnicero;
	}

	/**
	 * @return the idCarniceria
	 */
	public Integer getIdCarniceria() {
		return idCarniceria;
	}

	/**
	 * @param idCarniceria the idCarniceria to set
	 */
	public void setIdCarniceria(Integer idCarniceria) {
		this.idCarniceria = idCarniceria;
	}

}