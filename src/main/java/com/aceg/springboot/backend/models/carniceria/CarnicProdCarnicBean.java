/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carniceria;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarnicProdCarnicBean que contiene los atributos de la
 * tabla de la DB la cual es resultado de la ralacion n --> m de las tablas
 * ACEG_CARNICERIA - ACEG_PROD_CARNICERIA
 * - Numero de Metodos: 4
 * - Nombre de la tabla: ACEG_CARN_PROD_CARN
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class CarnicProdCarnicBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 2206774566367473749L;

	/**
	 * id de la carniceria
	 */
	private Integer idCarniceria;

	/**
	 * id del producto de la carniceria
	 */
	private Integer idProducto;

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
