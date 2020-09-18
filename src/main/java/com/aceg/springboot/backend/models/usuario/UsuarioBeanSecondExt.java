/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.usuario;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * - Descripcion: Clase UsuarioBeanSecondExt que contiene los atributos de las 
 * tablas de la DB 
 * - Numero de Metodos: 10 
 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 14/09/2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioBeanSecondExt implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -1053219015220192177L;

	/**
	 * direccion del usuario
	 */
	private String direccion;

	/**
	 * codigo postal del usuario
	 */
	private String cp;

	/**
	 * id del estado de la direccion del usuario
	 */
	private Integer idEstado;

	/**
	 * sueldo mensual del usuario - carnicero
	 */
	private Integer sueldoMensual;

	/**
	 * id de la carniceria donde trabaja el carnicero
	 */
	private Integer idCarniceria;

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
	 * @return the sueldo_mensual
	 */
	public Integer getSueldoMensual() {
		return sueldoMensual;
	}

	/**
	 * @param sueldo_mensual the sueldo_mensual to set
	 */
	public void setSueldoMensual(Integer sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
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
