/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

/**
 * - Descripcion: Clase MunicipioBean que contiene los atributos de la tabla de
 * la DB
 * - Numero de Metodos: 6
 * - Nombre de la tabla: ACEG_MUNICIPIO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class MunicipioBean implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -1309289148963681982L;

	/**
	 * id del municipio
	 */
	private Integer idMunicipio;

	/**
	 * nombre del municipio
	 */
	private String municipio;

	/**
	 * id del estado al que pertenece el municipio
	 */
	private Integer idEstado;

	/**
	 * @return the idMunicipio
	 */
	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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
