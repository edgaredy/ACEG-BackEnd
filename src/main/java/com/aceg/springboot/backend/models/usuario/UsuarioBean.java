/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.models.usuario;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * - Descripcion: Clase UsuarioBean que contiene los atributos de las tablas de
 * la DB 
 * - Numero de Metodos: 10 
 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioBean extends UsuarioBeanFirstExt implements Serializable {

	/**
	 * SerialUID de la clase
	 */
	private static final long serialVersionUID = -710542227816292086L;

	/**
	 * id del usuario
	 */
	private Integer idUsuario;

	/**
	 * username del usuario
	 */
	private String email;

	/**
	 * password del usuario
	 */
	private String password;

	/**
	 * contructor vacion de la clase
	 */
	public UsuarioBean() {
	}

	/**
	 * Constructor de la clase para registro de un CARNICERO
	 * 
	 * @param email    - email del usuario
	 * @param password - contraseña del usuario
	 */
	public UsuarioBean(String nombre, String apellido, String genero, String email, String password, String telefono,
			String direccion, String cp, Integer sueldoMensual, Integer idCarniceria, Integer idEstado, String roleDb) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cp = cp;
		this.sueldoMensual = sueldoMensual;
		this.idCarniceria = idCarniceria;
		this.idEstado = idEstado;
		this.role = roleDb;
	}

	/**
	 * Constructor de la clase para registro de un CLIENTE
	 * 
	 * @param email    - email del usuario
	 * @param password - contraseña del usuario
	 */
	public UsuarioBean(String nombre, String apellido, String genero, String email, String password, String telefono,
			String direccion, String cp, Integer idEstado, String roleDb) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cp = cp;
		this.idEstado = idEstado;
		this.role = roleDb;
	}

	/**
	 * Constructor de la clase para registro de un PROVEEDOR
	 * 
	 * @param email    - email del usuario
	 * @param password - contraseña del usuario
	 */
	public UsuarioBean(String nombreEmpresa, String nombre, String apellido, String genero, String email,
			String password, String telefono, String direccion, String cp, String roleDb) {
		this.nombreEmpresa = nombreEmpresa;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cp = cp;
		this.role = roleDb;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
