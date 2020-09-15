/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.usuario;

import java.io.Serializable;

/**
 * - Descripcion: Clase UsuarioBeanFirstExt que contiene los atributos de las 
 * tablas de la DB 
 * - Numero de Metodos: 10 
 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 14/09/2020
 */


public class UsuarioBeanFirstExt extends UsuarioBeanSecondExt implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = 5659945850784563631L;

	/**
	 * nombre del usuario
	 */
	public String nombre;
	
	/**
	 * apellidos del usuario
	 */
	public String apellido;
	
	/**
	 * genero del usuario
	 * M - mujer
	 * H - hombre
	 */
	public String genero;
	
	/**
	 * email del usuario
	 */
	public String email;
	
	/**
	 * telefono del usuario (10 digitos)
	 */
	public String telefono;

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

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
