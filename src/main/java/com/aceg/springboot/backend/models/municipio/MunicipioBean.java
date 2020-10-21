/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.municipio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * - Descripcion: Clase MunicipioBean que contiene los atributos de la tablas de
 * la DB 
 * - Numero de Metodos: 6
 * - Nombre de las tablas: ACEG_MUNICIPIO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/10/2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MunicipioBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 2610815361178480213L;
	
	/**
	 * id del municipio
	 */
	private Integer id;
	
	/**
	 * nombre del municipio
	 */
	private String Municipio;
	
	/**
	 * id del estado
	 */
	private Integer idEstado;

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
	 * @return the municipio
	 */
	public String getMunicipio() {
		return Municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}

	/**
	 * @return the idEstado
	 */
	public Integer getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

}
