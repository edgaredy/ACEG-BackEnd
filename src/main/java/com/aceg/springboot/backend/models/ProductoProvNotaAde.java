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
 * - Descripcion: Clase ProductoProvNotaAde que contiene los atributos de la
 * tabla PROD_PROV_NOTA_ADE la cual es resultado de la ralacion n --> m de las
 * tablas PROD_PROVEEDOR - NOTA_ADEUDADA
 * 
 * - Nombre Tabla en DB: PROD_PROV_NOTA_ADE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProductoProvNotaAde implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -6585957035556366887L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer nota_adeudada_id;

	/**
	 * id de la nota adeudada
	 */
	private Integer nota_adeudada_id_nota;

	/**
	 * id de l prodcuto del proveedor adeudado
	 */
	private Integer prod_proveedor_id;

	/**
	 * @return the nota_adeudada_id
	 */
	public Integer getNota_adeudada_id() {
		return nota_adeudada_id;
	}

	/**
	 * @param nota_adeudada_id the nota_adeudada_id to set
	 */
	public void setNota_adeudada_id(Integer nota_adeudada_id) {
		this.nota_adeudada_id = nota_adeudada_id;
	}

	/**
	 * @return the nota_adeudada_id_nota
	 */
	public Integer getNota_adeudada_id_nota() {
		return nota_adeudada_id_nota;
	}

	/**
	 * @param nota_adeudada_id_nota the nota_adeudada_id_nota to set
	 */
	public void setNota_adeudada_id_nota(Integer nota_adeudada_id_nota) {
		this.nota_adeudada_id_nota = nota_adeudada_id_nota;
	}

	/**
	 * @return the prod_proveedor_id
	 */
	public Integer getProd_proveedor_id() {
		return prod_proveedor_id;
	}

	/**
	 * @param prod_proveedor_id the prod_proveedor_id to set
	 */
	public void setProd_proveedor_id(Integer prod_proveedor_id) {
		this.prod_proveedor_id = prod_proveedor_id;
	}

}
