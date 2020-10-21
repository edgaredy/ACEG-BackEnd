/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.aceg.springboot.backend.controller.exception.DefaultError;

/**
 * - Descripcion: Clase UsuarioResponse que contiene la respuesta de tipo UsuarioBean
 * - Numero de Metodos: 4
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 03/10/2020
 */

public class UsuarioResponse implements Serializable{

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = 4273429358702012901L;

	/**
	 * content lista 
	 */
	private List<UsuarioBean> content;
	
	/**
	 * responseCode respuesta comun de todos los servicios
	 */
	private DefaultError responseCode;
	
	/**
	 * Lista de modulos
	 * @return modulosTmp lista de modulos inicializada
	 */
	public List<UsuarioBean> getContent() {
		List<UsuarioBean> data = new ArrayList<>();
		if (this.content != null) {
			data.addAll(this.content);
		}
		return data;
	}

	/**
	 * Lista de modulos
	 * @return content seteo de lista
	 */
	public void setContent(List<UsuarioBean> content) {
		List<UsuarioBean> data = new ArrayList<>();
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
