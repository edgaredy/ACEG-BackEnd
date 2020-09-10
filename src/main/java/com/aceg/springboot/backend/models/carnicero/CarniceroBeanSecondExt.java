/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carnicero;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarniceroBeanSecondExt que contiene algunos atributos de
 * la tabla de la DB
 * - Numero de Metodos: 2
 * - Nombre de la tabla: ACEG_CARNICERO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class CarniceroBeanSecondExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -7998199669521475041L;

	/**
	 * id del estado en el que vive el carnicero
	 */
	private Integer idEstado;

	/**
	 * contraseña de acceso del carnicero
	 */
	private String password;

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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}