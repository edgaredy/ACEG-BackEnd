/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.util;

/**
 * - Descripcion: Esta clase permite la enumeracion de diferentes mensajes de operaciones correctas
 *   utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * 
 *   Es posible agregar nuevos mensajes personalizados para permitir que
 *   el servicio sea mas explicito, recordando siempre que es importante
 *   evitar arrojar informacion sensible
 * - Numero de Metodos: 7
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 11/09/2020
 */

public enum SucessEnum {

	EXC_OPER_EXITOSA("SUC.000", "Operacion Exitosa", "Operacion Exitosa", AcegConstantes.SUCCESS, "", true);

	private final String code;

	private final String message;

	private final String description;

	private final String level;

	private final String moreInfo;

	private final Boolean ok;

	SucessEnum(final String code, final String message, final String description, final String level,
			final String moreInfo, final Boolean ok) {
		this.code = code;
		this.message = message;
		this.description = description;
		this.level = level;
		this.moreInfo = moreInfo;
		this.ok = ok;
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
	 * Obtiene el valor de la variable level.
	 *
	 * @return el level
	 */
	public String getLevel() {
		return level;
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
	 * Obtiene el valor de la variable moreInfo.
	 *
	 * @return el moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * Obtiene el valor de la variable ok.
	 *
	 * @return el ok
	 */
	public Boolean getOk() {
		return ok;
	}

}
