/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.producto;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProductoProvNotaPagBean que contiene los atributos de la
 * tabla de la DB la cual es resultado de la ralacion n --> m de las tablas
 * ACEG_PROD_PROVEEDOR - ACEG_NOTA_PAGADA
 * - Numero de Metodos: 6
 * - Nombre de la tabla: ACEG_PROD_PROV_NOTA_PAG
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

public class ProductoProvNotaPagBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 725799529967178240L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer idNotaProv;

	/**
	 * id de la nota pagada
	 */
	private Integer idNota;

	/**
	 * id del producto del provedor
	 */
	private Integer idProdProv;

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
	 * @return the idProdProv
	 */
	public Integer getIdProdProv() {
		return idProdProv;
	}

	/**
	 * @param idProdProv the idProdProv to set
	 */
	public void setIdProdProv(Integer idProdProv) {
		this.idProdProv = idProdProv;
	}

}
