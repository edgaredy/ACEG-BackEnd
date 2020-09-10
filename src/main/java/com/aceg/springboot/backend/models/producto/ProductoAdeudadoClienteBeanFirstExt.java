/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.producto;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProductoAdeudadoClienteBeanFirstExt que contiene los
 * atributos de la tabla de la DB
 * - Numero de Metodos: 2
 * - Nombre de la tabla: ACEG_PROD_ADE_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class ProductoAdeudadoClienteBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -6114605960634315649L;
	/**
	 * id del cliente que adeuda el producto
	 */
	private Integer idCliente;

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
