/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.producto;

import java.io.Serializable;
import java.util.Date;

/**
 * - Descripcion: Clase ProductoAdeudadoClienteBean que contiene los atributos
 * de la tabla de la DB, esta clase hereda los metodos y atributos de la clase
 * ProductoAdeudadoClienteBeanFirstExt
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_PROD_ADE_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class ProductoAdeudadoClienteBean extends ProductoAdeudadoClienteBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -2068127581253641997L;

	/**
	 * id del producto adeudado del cliente
	 */
	private Integer idProdAde;

	/**
	 * fecha de compra del producto adeudado
	 */
	private Date fechaCompra;

	/**
	 * peso del prodcuto del producto adeudado
	 */
	private Integer pesoProducto;

	/**
	 * costo total del prodcuto adeudado
	 */
	private Integer total;

	/**
	 * descripcion del producto adeudado
	 */
	private String descripcion;

	/**
	 * @return the idProdAde
	 */
	public Integer getIdProdAde() {
		return idProdAde;
	}

	/**
	 * @param idProdAde the idProdAde to set
	 */
	public void setIdProdAde(Integer idProdAde) {
		this.idProdAde = idProdAde;
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
	public Integer getPesoProducto() {
		return pesoProducto;
	}

	/**
	 * @param pesoProducto the pesoProducto to set
	 */
	public void setPesoProducto(Integer pesoProducto) {
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

}
