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
 * - Descripcion: Clase Carnicero que contiene los atributos de la tabla
 * CARNICERO
 * 
 * - Nombre Tabla en DB: CARNICERO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class Carnicero implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -507416161310181546L;

	/**
	 * id del carnicero
	 */
	private Integer id;

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
	private char genero;

	/**
	 * email del carnicero
	 */
	private String email;

	/**
	 * telefono del carnicero
	 */
	private String telefono;

	/**
	 * direccion del carnicero
	 */
	private String direccion;

	/**
	 * codigo postal de la vivienda del carnicero
	 */
	private String codigo_postal;

	/**
	 * sueldo mensual del carnicero
	 */
	private Integer sueldo_mensual;

	/**
	 * id de la carniceria donde trabaja
	 */
	private Integer carniceria_id;

	/**
	 * id del estado en el que vive el carnicero
	 */
	private Integer estado_id;

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
	 * @param codigo_postal the codigo_postal to set
	 */
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	/**
	 * @return the sueldo_mensual
	 */
	public Integer getSueldo_mensual() {
		return sueldo_mensual;
	}

	/**
	 * @param sueldo_mensual the sueldo_mensual to set
	 */
	public void setSueldo_mensual(Integer sueldo_mensual) {
		this.sueldo_mensual = sueldo_mensual;
	}

	/**
	 * @return the carniceria_id
	 */
	public Integer getCarniceria_id() {
		return carniceria_id;
	}

	/**
	 * @param carniceria_id the carniceria_id to set
	 */
	public void setCarniceria_id(Integer carniceria_id) {
		this.carniceria_id = carniceria_id;
	}

	/**
	 * @return the estado_id
	 */
	public Integer getEstado_id() {
		return estado_id;
	}

	/**
	 * @param estado_id the estado_id to set
	 */
	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}

}
