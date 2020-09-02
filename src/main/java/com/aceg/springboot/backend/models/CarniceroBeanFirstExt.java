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
 * - Descripcion: Clase CarniceroBeanFirstExt que contiene algunos atributos de
 * la tabla de la DB, esta clase hereda los metodos y atributos de la clase
 * CarniceroBeanSecondExt
 * 
 * - Numero de Metodos: 10
 * 
 * - Nombre Tabla en DB: ACEG_CARNICERO
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 01/09/2020
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // los atributos del json siempre seran en minusculas y
															// separados por guion bajo, ejemplo_nombre_json
@JsonInclude(Include.NON_EMPTY) // el json no retorna valores vacios
public class CarniceroBeanFirstExt extends CarniceroBeanSecondExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 2220173052884536609L;

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
	private String cp;

	/**
	 * sueldo mensual del carnicero
	 */
	private Integer sueldoMensul;

	/**
	 * id de la carniceria donde trabaja
	 */
	private Integer idCarniceria;

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
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the sueldoMensul
	 */
	public Integer getSueldoMensul() {
		return sueldoMensul;
	}

	/**
	 * @param sueldoMensul the sueldoMensul to set
	 */
	public void setSueldoMensul(Integer sueldoMensul) {
		this.sueldoMensul = sueldoMensul;
	}

	/**
	 * @return the idCarniceria
	 */
	public Integer getIdCarniceria() {
		return idCarniceria;
	}

	/**
	 * @param idCarniceria the idCarniceria to set
	 */
	public void setIdCarniceria(Integer idCarniceria) {
		this.idCarniceria = idCarniceria;
	}

}
