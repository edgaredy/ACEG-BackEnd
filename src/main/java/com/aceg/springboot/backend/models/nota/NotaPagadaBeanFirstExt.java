/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.nota;

import java.io.Serializable;

/**
 * - Descripcion: Clase NotaPagadaBeanFirstExt que contiene los atributos de la
 * tabla de la DB
 * - Numero de Metodos: 8
 * - Nombre Tabla en DB: ACEG_NOTA_PAGADA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class NotaPagadaBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -3214249859103486313L;

	/**
	 * costo total del producto
	 */
	private Integer total;

	/**
	 * descripcion de la nota pagada
	 */
	private String descripcion;

	/**
	 * id del carnicero que realizo la compra
	 */
	private Integer idCarnicero;

	/**
	 * id de la carniceria del carnicero que realizo la compra
	 */
	private Integer idCarniceria;

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

	/**
	 * @return the idCarnicero
	 */
	public Integer getIdCarnicero() {
		return idCarnicero;
	}

	/**
	 * @param idCarnicero the idCarnicero to set
	 */
	public void setIdCarnicero(Integer idCarnicero) {
		this.idCarnicero = idCarnicero;
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
