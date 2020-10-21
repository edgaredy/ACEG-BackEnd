/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.usuario;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * - Descripcion: Clase UsuarioBeanThirdExt que contiene los atributos de las 
 * tablas de la DB 
 * - Numero de Metodos: 8
 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 11/10/2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioBeanThirdExt implements Serializable{
	
	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -5875172800712494013L;
	
	/**
	 * descripcion de la carniceria
	 */
	private String descripcion;
	
	/**
	 * id del municipio
	 */
	private Integer idMunicipio;
	
	/**
	 * id del usuario
	 */
	private Integer id;
	
	/**
	 * nombre del municipio
	 */
	private String municipio;
	
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
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
}
