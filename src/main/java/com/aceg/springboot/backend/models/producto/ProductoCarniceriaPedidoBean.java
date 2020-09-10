/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.producto;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProdcutoCarniceriaPedidoBean que contiene los atributos
 * de la tabla de la DB la cual es resultado de la ralacion n --> m de las
 * tablas ACEG_PROD_CARNICERIA - ACEG_PEDIDO
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_PROD_CAR_PED
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

public class ProductoCarniceriaPedidoBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -9070930472818906173L;

	/**
	 * id del prodcuto de la carniceria
	 */
	private Integer idProducto;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer idPedido;

	/**
	 * id de la carniceria a la que se le adeuda el pedido
	 */
	private Integer idCarniceria;

	/**
	 * id del cleinte que adeuda el pedido
	 */
	private Integer idCliente;

	/**
	 * id del pedido
	 */
	private Integer idNota;

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

}
