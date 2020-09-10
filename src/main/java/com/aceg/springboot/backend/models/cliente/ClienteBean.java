/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.cliente;

import java.io.Serializable;

/**
 * - Descripcion: Clase ClienteBean que contiene los atributos de la tabla
 * CLIENTE, esta clase hereda los metodos y atributos de la clase
 * ClienteBeanFirstExt
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_CLIENTE
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */

public class ClienteBean extends ClienteBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 4732817288827736772L;

	/**
	 * id del carnicero
	 */
	private Integer idCliente;

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
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
