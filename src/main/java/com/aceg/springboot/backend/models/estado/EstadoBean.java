/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.estado;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * - Descripcion: Clase EstadoBean que contiene los atributos de la tablas de
 * la DB 
 * - Numero de Metodos: 6
 * - Nombre de las tablas: ACEG_ESTADO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/10/2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstadoBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 2726160632722315906L;

	/**
	 * id del estado
	 */
	private Integer id;
	
	/**
	 * nombre del estado
	 */
	private String estado;
	
	/**
	 * abreviacion del estado - 3 digitos
	 */
	private String abreviacion;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the abreviacion
	 */
	public String getAbreviacion() {
		return abreviacion;
	}

	/**
	 * @param abreviacion the abreviacion to set
	 */
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

}
