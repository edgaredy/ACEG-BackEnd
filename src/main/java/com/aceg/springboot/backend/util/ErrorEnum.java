/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.util;

/**
 * - Descripcion: Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * 
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible
 * 
 * - Numero de Metodos: 7
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 11/09/2020
 */

public enum ErrorEnum {

	// codigo, mensaje, desripcion, nivel, mas informacion, ok = true 
	
	EXC_GENERICO("EXC.000", "Error generico", "Error generico de servidor", AcegConstantes.ERROR, "", false),

	EXC_ERROR_PARAMS("EXC.001", "Parametros invalidos", "Parametros invalidos de consumo", AcegConstantes.WARNING, "", false),
	
	EXC_DUPLICADO("EXC.100", "Registro duplicado", "Registro ya existe, no puede ser sobrescrita", AcegConstantes.WARNING, "", false),
	
	EXC_INEXISTENTE("EXC.101", "Registro inexistente", "Registro no existe, intente con otro valor", AcegConstantes.WARNING, "", false),
	
	EXC_OPER_NO_EXITOSA("EXC.102", "Operacion no exitosa", "Operacion no exitosa", AcegConstantes.ERROR, "", false),

	EXC_OPER_CON_ERRORES("EXC.103", "Operacion con errores", "Operacion con errores", AcegConstantes.ERROR, "", false),
	
	EXC_ERRO_AUT("EXC.103", "Error de autenticacion", "Usuario o contraseña invalidos", AcegConstantes.ERROR, "Verifica tus credeciales", false),
	
	EXC_ERROR_BBDD("BD.200", "Error de Base de datos", "Error de Base de datos", AcegConstantes.ERROR, "", false),
	
	EXC_INEXISTENTE_BD("BD.201", "Registro inexistente", "Registro no existe, intente con otro valor", AcegConstantes.WARNING, "", false),
	
	EXC_ERROR_REGISTRO("BD.201", "Error de registro de usuario", "Error al registrar el usuario, comprueba los campos", AcegConstantes.ERROR, "", false),

	EXC_ERROR_CACHE("BD.202", "Error de Cache", "Error de Cache", AcegConstantes.ERROR, "", false)
	
	;
	
	/**
	 * codigo 
	 */
	private final String code;

	/**
	 * mensaje
	 */
	private final String message;

	/**
	 * descripcion
	 */
	private final String description;

	/**
	 * nivel
	 */
	private final String level;

	/**
	 * mas informacion
	 */
	private final String moreInfo;

	/** 
	 *  La variable ok.
	 */
	private final Boolean ok;

	/**
	 * constructor de tipo enum
	 * 
	 * @param code - el codigo del error
	 * @param message - mensaje del error
	 * @param description - descripcion del error
	 * @param level - nivel del error
	 * @param moreInfo - mas informacion acerca del error
	 * @param ok - verifica si es valido (true), caso contrario false
	 */
	ErrorEnum(final String code, final String message, final String description, final String level,
			final String moreInfo, Boolean ok) {
		this.code = code;
		this.message = message;
		this.description = description;
		this.level = level;
		this.moreInfo = moreInfo;
		this.ok = ok;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @return the moreInfo
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * @return the ok
	 */
	public Boolean getOk() {
		return ok;
	}

}
