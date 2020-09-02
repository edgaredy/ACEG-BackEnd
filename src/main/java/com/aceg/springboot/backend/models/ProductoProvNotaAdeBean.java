/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * - Descripcion: Clase ProductoProvNotaAdeBean que contiene los atributos de la
 * tabla de la DB la cual es resultado de la ralacion n --> m de las tablas
 * ACEG_PROD_PROVEEDOR - ACEG_NOTA_ADEUDADA
 * 
 * - Numero de Metodos: 6
 * 
 * - Nombre Tabla en DB: ACEG_PROD_PROV_NOTA_ADE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProductoProvNotaAdeBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -6585957035556366887L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer idNota;

	/**
	 * id de la nota adeudada
	 */
	private Integer idNotaProv;

	/**
	 * id de l prodcuto del proveedor adeudado
	 */
	private Integer idProdProv;

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
