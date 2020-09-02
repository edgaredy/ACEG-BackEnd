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
 * - Descripcion: Clase PedidoBean que contiene los atributos de la tabla de la
 * DB, esta clase hereda los metodos y atributos de la clase PedidoBeanFirstExt
 * 
 * - Numero de Metodos: 10
 * 
 * - Nombre Tabla en DB: ACEG_PEDIDO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class PedidoBean extends PedidoBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -1794868730719425455L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer idPedido;

	/**
	 * id del pedido
	 */
	private Integer idNota;

	/**
	 * peso del producto en kg
	 */
	private Integer pesoTotal;

	/**
	 * fecha de entrega del pedido
	 */
	private Date fechaEntrega;

	/**
	 * costo total del pedido
	 */
	private Integer total;

	/**
	 * @return the idPedido
	 */
	public Integer getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

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
	 * @return the pesoTotal
	 */
	public Integer getPesoTotal() {
		return pesoTotal;
	}

	/**
	 * @param pesoTotal the pesoTotal to set
	 */
	public void setPesoTotal(Integer pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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
