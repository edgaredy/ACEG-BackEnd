/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.carniceria;

import java.io.Serializable;

/**
 * - Descripcion: Clase CarniceriaBean que contiene algunos atributos de la
 * tabla de la DB, esta clase hereda los metodos y atributos de la clase
 * CarniceriaBeanFirstExt
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_CARNICERIA
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class CarniceriaBean extends CarniceriaBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = 325575575399439821L;

	/**
	 * id de la carniceria
	 */
	private Integer idCarniceria;

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
	private String cp;

	/**
	 * telefono de la carniceria
	 */
	private String telefono;

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
