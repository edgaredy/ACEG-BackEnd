/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.proveedor;

import java.io.Serializable;

/**
 * - Descripcion: Clase ProveedorBean que contiene los atributos de la tabla de
 * la DB, esta clase hereda los metodos y atributos de la clase
 * ProveedorBeanFirstExt
 * - Numero de Metodos: 10
 * - Nombre de la tabla: ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */

public class ProveedorBean extends ProveedorBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -5854057321189648142L;

	/**
	 * id del proveedor
	 */
	private Integer idProveedor;

	/**
	 * nombre de la empresa del proveedor
	 */
	private String nombreEmpresa;

	/**
	 * nombre del proveedor
	 */
	private String nombreProveedor;

	/**
	 * apellido del proveedor
	 */
	private String apellido;

	/**
	 * genero del proveedor
	 */
	private String genero;

	/**
	 * @return the idProveedor
	 */
	public Integer getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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

}
