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
 * - Descripcion: Clase Carniceria que contiene los atributos de la tabla
 * CARNICERIA
 * 
 * - Nombre Tabla en DB: CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class Carniceria implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 325575575399439821L;

	/**
	 * id de la carniceria
	 */
	private Integer id;

	/**
	 * nombre de la carniceria
	 */
	private String nombre;

	/**
	 * direccion de la carniceria
	 */
	private String direccion;

	/**
	 * codigo postal donde esta ubicada la carniceria
	 */
	private String codigoPostal;

	/**
	 * telefono de la carniceria
	 */
	private String telefono;

	/**
	 * descripcion de la carniceria
	 */
	private String descripcion;

	/**
	 * id del estado al que pertenece la carniceria
	 */
	private String estadoId;

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
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estadoId
	 */
	public String getEstadoId() {
		return estadoId;
	}

	/**
	 * @param estadoId the estadoId to set
	 */
	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

}
