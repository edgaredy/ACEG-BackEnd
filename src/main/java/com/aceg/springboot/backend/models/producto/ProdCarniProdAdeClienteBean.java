/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.producto;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProdCarniProdAdeClienteBean que contiene los atributos
 * de la tabla de la DB la cual es resultado de la ralacion n --> m de las
 * tablas ACEG_PROD_CARNICERIA - ACEG_PRO_ADE_CLIENTE
 * - Numero de Metodos: 6
 * - Nombre de la tabla: ACEG_PROD_CAR_PRO_ADE_CLI
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

public class ProdCarniProdAdeClienteBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 521099817535614128L;

	/**
	 * id del producto adeudado del cliente
	 */
	private Integer idProduAdeu;

	/**
	 * id del cliente que adeuda el producto
	 */
	private Integer idCliente;

	/**
	 * id de la carniceria a la que el cliente la adeuda el producto
	 */
	private Integer idProducto;

	/**
	 * @return the idProduAdeu
	 */
	public Integer getIdProduAdeu() {
		return idProduAdeu;
	}

	/**
	 * @param idProduAdeu the idProduAdeu to set
	 */
	public void setIdProduAdeu(Integer idProduAdeu) {
		this.idProduAdeu = idProduAdeu;
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

}
