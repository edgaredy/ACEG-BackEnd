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
 * - Descripcion: Clase ProductoProvNotaPag que contiene los atributos de la
 * tabla PROD_PROV_NOTA_PAG la cual es resultado de la ralacion n --> m de las
 * tablas PROD_PROVEEDOR - NOTA_PAGADA
 * 
 * - Nombre Tabla en DB: PROD_PROV_NOTA_PAG
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 26/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class ProductoProvNotaPag implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 725799529967178240L;

	/**
	 * id autoincrement in 1 start by 1
	 */
	private Integer nota_pagada_id_nota;

	/**
	 * id de la nota pagada
	 */
	private Integer nota_pagada_id;

	/**
	 * id del producto del provedor
	 */
	private Integer prod_proveedor_id;

	/**
	 * @return the nota_pagada_id_nota
	 */
	public Integer getNota_pagada_id_nota() {
		return nota_pagada_id_nota;
	}

	/**
	 * @param nota_pagada_id_nota the nota_pagada_id_nota to set
	 */
	public void setNota_pagada_id_nota(Integer nota_pagada_id_nota) {
		this.nota_pagada_id_nota = nota_pagada_id_nota;
	}

	/**
	 * @return the nota_pagada_id
	 */
	public Integer getNota_pagada_id() {
		return nota_pagada_id;
	}

	/**
	 * @param nota_pagada_id the nota_pagada_id to set
	 */
	public void setNota_pagada_id(Integer nota_pagada_id) {
		this.nota_pagada_id = nota_pagada_id;
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
