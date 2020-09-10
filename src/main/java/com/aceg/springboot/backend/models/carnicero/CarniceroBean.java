/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carnicero;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarniceroBean que contiene los atributos de la tabla de
 * la DB, esta clase hereda los metodos y atributos de la clase
 * CarniceroBeanFirstExt
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_CARNICERO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class CarniceroBean extends CarniceroBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -507416161310181546L;

	/**
	 * id del carnicero
	 */
	private Integer idCarnicero;

	/**
	 * nombre del carnicero
	 */
	private String nombre;

	/**
	 * apellido del carnicero
	 */
	private String apellido;

	/**
	 * genero del carnicero
	 */
	private String genero;

	/**
	 * email del carnicero
	 */
	private String email;

	/**
	 * @return the idCarnicero
	 */
	public Integer getIdCarnicero() {
		return idCarnicero;
	}

	/**
	 * @param idCarnicero the idCarnicero to set
	 */
	public void setIdCarnicero(Integer idCarnicero) {
		this.idCarnicero = idCarnicero;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
