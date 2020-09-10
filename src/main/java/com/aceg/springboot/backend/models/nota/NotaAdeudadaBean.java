/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.nota;

import java.io.Serializable;
import java.util.Date;

/**
 * - Descripcion: Clase NotaAdeudadaBean que contiene los atributos de la tabla
 * de la DB, esta clase hereda los metodos y atributos de la clase
 * NotaAdeudadaBeanFirstExt
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_NOTA_ADEUDADA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class NotaAdeudadaBean extends NotaAdeudadaBeanFirstExt implements Serializable {

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

}
