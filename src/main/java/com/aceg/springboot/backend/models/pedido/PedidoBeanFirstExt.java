/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.pedido;

import java.io.Serializable;

/**
 * - Descripcion: Clase PedidoBeanFirstExt que contiene los atributos de la
 * tabla de la DB
 * - Numero de Metodos: 6
 * - Nombre de la tabla: ACEG_PEDIDO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class PedidoBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -8604884290893435366L;

	/**
	 * descricpion del pedido
	 */
	private String descripcion;

	/**
	 * id de la carniceria que tiene el pedido
	 */
	private Integer idCarniceria;

	/**
	 * id del cliente que realizo el pedidoF
	 */
	private Integer idCliente;

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

	/**
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
