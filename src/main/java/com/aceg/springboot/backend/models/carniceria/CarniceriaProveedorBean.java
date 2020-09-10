/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carniceria;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarniceriaProveedorBean que contiene los atributos de la
 * tabla de la DB la cual es resultado de la ralacion n --> m de las tablas
 * ACEG_CARNICERIA - ACEG_PROVEEDOR
 * - Numero de Metodos: 4
 * - Nombre de la tabla: ACEG_PROVEEDOR_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

public class CarniceriaProveedorBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -6616559989301127686L;

	/**
	 * id del proveedor
	 */
	private Integer idProveedor;

	/**
	 * id de la carniceria
	 */
	private Integer idCarniceria;

	/**
	 * @return the idProveedor
	 */
	public Integer getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
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
