/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.municipio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.aceg.springboot.backend.controller.exception.DefaultError;

/**
 * - Descripcion: Clase MunicipioResponse que contiene la respuesta de tipo MunicipioResponse
 * - Numero de Metodos: 6
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/10/2020
 */

public class MunicipioResponse implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 4420806121567911389L;

	/**
	 * content lista
	 */
	private List<MunicipioBean> content;

	/**
	 * responseCode respuesta comun de todos los servicios
	 */
	private DefaultError responseCode;
	
	/**
	 * objeto de tipo MunicipioBean
	 */
	private MunicipioBean municipio = null;

	/**
	 * @return the municipio
	 */
	public MunicipioBean getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(MunicipioBean municipio) {
		this.municipio = municipio;
	}

	/**
	 * Lista de modulos
	 * 
	 * @return modulosTmp lista de modulos inicializada
	 */
	public List<MunicipioBean> getContent() {
		List<MunicipioBean> data = new ArrayList<>();
		if (this.content != null) {
			data.addAll(this.content);
		}
		return data;
	}

	/**
	 * Lista de modulos
	 * 
	 * @return content seteo de lista
	 */
	public void setContent(List<MunicipioBean> content) {
		List<MunicipioBean> data = new ArrayList<>();
		if (content != null) {
			data.addAll(content);
		}
		this.content = data;
	}

	/**
	 * respuesta comun de todos los servicios
	 * 
	 * @return responseCode respuesta comun de todos los servicios
	 */
	public DefaultError getResponseCode() {
		return responseCode;
	}

	/**
	 * respuesta comun de todos los servicios
	 * 
	 * @return responseCode seteo de respuesta comun de todos los servicios
	 */
	public void setResponseCode(DefaultError responseCode) {
		this.responseCode = responseCode;
	}

}
