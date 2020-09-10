/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.proveedor;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProvProdcutoProvBean que contiene los atributos de la
 * tabla de la DB la cual es resultado de la ralacion n --> m de las tablas
 * ACEG_PROVEEDOR - ACEG_PROD_PROVEEDOR
 * - Numero de Metodos: 4
 * - Nombre de la tablaB: ACEG_PROV_PROD_PROV
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

public class ProvProductoProvBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -2014527372068276047L;

	/**
	 * id del proveedor
	 */
	private Integer idProveedor;

	/**
	 * id del prodcuto del proveedor
	 */
	private Integer idProdProv;

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
