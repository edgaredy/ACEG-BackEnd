/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller.exception;

import java.io.Serializable;

import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.SucessEnum;

/**
 * - Descripcion: Clase DefaultError usada para indicar los errores que sucedieron
 *   durante la ejecucion.
 * - Numero de Metodos: 9
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/10/2020
 */
public class DefaultError implements Serializable {

	/** Variable para serializar la clase. */
	private static final long serialVersionUID = 1L;

	/** La variable code. */
	private String code;

	/** La variable message. */
	private String message;

	/** La variable level. */
	private String level;

	/** La variable description. */
	private String description;

	/** La variable more info. */
	private String moreInfo;

	/** La variable ok. */
	private Boolean ok;

	/**
	 * 
	 * Constructor que recibe el objeto del enumerador de mensajes
	 * 
	 * @param errorEnum Objeto del enumerador de mensajes
	 */
	public DefaultError(ErrorEnum errorEnum) {
		this.code = errorEnum.getCode();
		this.message = errorEnum.getMessage();
		this.level = errorEnum.getLevel();
		this.description = errorEnum.getDescription();
		this.moreInfo = errorEnum.getMoreInfo();
		this.ok = errorEnum.getOk();
	}

	/**
	 * 
	 * Constructor que recibe el objeto del enumerador de mensajes
	 * 
	 * @param sucessEnum Objeto del enumerador de mensajes
	 */
	public DefaultError(SucessEnum sucessEnum) {
		this.code = sucessEnum.getCode();
		this.message = sucessEnum.getMessage();
		this.level = sucessEnum.getLevel();
		this.description = sucessEnum.getDescription();
		this.moreInfo = sucessEnum.getMoreInfo();
		this.ok = sucessEnum.getOk();
	}

	/**
	 * Constructor que recibe el objeto del enumerador de mensajes, con la opcion de
	 * agregar mas detalle usando el campo moreInfo
	 * 
	 * @param errorEnum Objeto del enumerador de mensajes
	 * @param moreInfo  Un link a la documentacion del codigo de error.
	 */
	public DefaultError(ErrorEnum errorEnum, String moreInfo) {
		this.code = errorEnum.getCode();
		this.message = errorEnum.getMessage();
		this.level = errorEnum.getLevel();
		this.description = errorEnum.getDescription();
		this.moreInfo = moreInfo;
		this.ok = errorEnum.getOk();
	}

	/**
	 * Obtiene el valor de la variable code.
	 *
	 * @return el code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Obtiene el valor de la variable message.
	 *
	 * @return el message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Obtiene el valor de la variable nivel.
	 *
	 * @return el level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Obtiene el valor de la variable description.
	 *
	 * @return el description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Obtiene el valor de la variable more info.
	 *
	 * @return el more info
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * Obtiene el valor de la variable ok
	 *
	 * @return ok
	 */
	public Boolean getOk() {
		return ok;
	}

}
