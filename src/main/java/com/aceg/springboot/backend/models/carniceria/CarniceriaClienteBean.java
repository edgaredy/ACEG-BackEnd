/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carniceria;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarniceriaClienteBean que contiene los atributos de la
 * tabla de la DB la cual es resultado de la ralacion n --> m de las tablas
 * ACEG_CARNICERIA - ACEG_CLIENTE
 * - Numero de Metodos: 4
 * - Nombre Tabla en DB: ACEG_CARNICERIA_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class CarniceriaClienteBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 6557500973532353610L;

	/**
	 * id del cliente
	 */
	private Integer idCliente;

	/**
	 * id de la carniceria
	 */
	private Integer idCarniceria;

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
