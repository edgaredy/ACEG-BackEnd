/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * - Descripcion: Clase Proveedor que contiene los atributos de la tabla
 * PROVEEDOR
 * 
 * - Nombre Tabla en DB: PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class Proveedor implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -5854057321189648142L;

	/**
	 * id del proveedor
	 */
	private Integer id;

	/**
	 * nombre de la empresa del proveedor
	 */
	private String nombre_empresa;

	/**
	 * nombre del proveedor
	 */
	private String nombre_proveedor;

	/**
	 * apellido del proveedor
	 */
	private String apellido;

	/**
	 * genero del proveedor
	 */
	private char genero;

	/**
	 * email del proveedor
	 */
	private String email;

	/**
	 * telefono del proveedor
	 */
	private String telefono;

	/**
	 * direccion del proveedor
	 */
	private String direccion;

	/**
	 * codigo postal del proveedor
	 */
	private String codigo_postal;

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
	 * @return the nombre_empresa
	 */
	public String getNombre_empresa() {
		return nombre_empresa;
	}

	/**
	 * @param nombre_empresa the nombre_empresa to set
	 */
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	/**
	 * @return the nombre_proveedor
	 */
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	/**
	 * @param nombre_proveedor the nombre_proveedor to set
	 */
	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
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
	public char getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(char genero) {
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

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the codigo_postal
	 */
	public String getCodigo_postal() {
		return codigo_postal;
	}

	/**
	 * @param codigo_postal the codigo_postal to setF
	 */
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

}
