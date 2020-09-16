/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.util;

/**
 * - Descripcion: Clase RegistroDbConstants que contiene las contantes 
 * con las consultas para el registro de un nuevo usuario 
 * - Numero de Metodos: 5
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */


public final class RegistroDbConstants {

	/**
	 * Constante que contiene el query para insertar un carnicero
	 */
	public static final String INSERT_CARNICERO = queryInsertCarnicero();
	
	/**
	 * Constante que contiene el query para insertar un cliente
	 */
	public static final String INSERT_CLIENTE = queryInsertCliente();
	
	/**
	 * Constante que contiene el query para insertar un proveedor
	 */
	public static final String INSERT_PROVEEDOR = queryInsertProveedor();
	
	/**
	 * Constante que contiene el query para insertar un usuario
	 */
	public static final String INSERT_USUARIO = queryInsertUsuario();
	
	/**
	 * Constante que contiene el query para verificar la existencia del email de un usuario
	 */
	public static final String GETBYEMAIL = "SELECT * FROM ACEG_USUARIO WHERE EMAIL = ?";
	
	/**
	 * Constante que contiene el query para verificar la existencia del role de un usuario
	 */
	public static final String GETBYROL = "SELECT * FROM ACEG_ROLE WHERE ROLE_PK = ?";

	/**
	 * - Metodo que contiene la consulta para insertar un nuevo carnicero en la DB 
	 * - Nombre de tabla: ACEG_CARNICERO
	 * 
	 * @return - InsertCarnicero query en formato string
	 */
	public static String queryInsertCarnicero() {

		StringBuilder query = new StringBuilder();

		query.append(DbConstants.INSERT);
		query.append(DbConstants.IN_TO);
		query.append("ACEG_CARNICERO ");
		query.append("(NOMBRE, ");
		query.append(DbConstants.APELLIDO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.GENERO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.EMAIL);
		query.append(DbConstants.COMA);
		query.append(DbConstants.TELEFONO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.DIRECCION);
		query.append(DbConstants.COMA);
		query.append("CP, ");
		query.append("SUELDO_MENSUAL, ");
		query.append("ID_CARNICERIA_FK, ");
		query.append("ID_ESTADO_FK) ");
		query.append(DbConstants.VALUES);
		query.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		return query.toString();
	}

	/**
	 * - Metodo que contiene la consulta para insertar un nuevo cliente en la DB 
	 * - Nombre de tabla: ACEG_CLIENTE
	 * 
	 * @return - InsertCliente query en formato string
	 */
	public static String queryInsertCliente() {

		StringBuilder query = new StringBuilder();

		query.append(DbConstants.INSERT);
		query.append(DbConstants.IN_TO);
		query.append("ACEG_CLIENTE ");
		query.append("(NOMBRE, ");
		query.append(DbConstants.APELLIDO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.GENERO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.EMAIL);
		query.append(DbConstants.COMA);
		query.append(DbConstants.TELEFONO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.DIRECCION);
		query.append(DbConstants.COMA);
		query.append("CP, ");
		query.append("ID_ESTADO_FK) ");
		query.append(DbConstants.VALUES);
		query.append("(?, ?, ?, ?, ?, ?, ?, ?)");

		return query.toString();
	}

	/**
	 * - Metodo que contiene la consulta para insertar un nuevo proveedor en la DB 
	 * - Nombre de tabla: ACEG_PROVEEDOR
	 * 
	 * @return - InsertProveedor query en formato string
	 */
	public static String queryInsertProveedor() {

		StringBuilder query = new StringBuilder();

		query.append(DbConstants.INSERT);
		query.append(DbConstants.IN_TO);
		query.append("ACEG_PROVEEDOR ");
		query.append("(NOMBRE_EMPRESA, ");
		query.append("NOMBRE_PROVEEDOR, ");
		query.append(DbConstants.APELLIDO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.GENERO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.EMAIL);
		query.append(DbConstants.COMA);
		query.append(DbConstants.TELEFONO);
		query.append(DbConstants.COMA);
		query.append(DbConstants.DIRECCION);
		query.append(DbConstants.COMA);
		query.append("CP) ");
		query.append(DbConstants.VALUES);
		query.append("(?, ?, ?, ?, ?, ?, ?, ?)");

		return query.toString();
	}

	/**
	 * - Metodo que contiene la consulta para insertar un nuevo proveedor en la DB 
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @return - InsertUsuario query en formato string
	 */
	public static String queryInsertUsuario() {

		StringBuilder query = new StringBuilder();

		query.append(DbConstants.INSERT);
		query.append(DbConstants.IN_TO);
		query.append("ACEG_USUARIO (");
		query.append(DbConstants.EMAIL);
		query.append(DbConstants.COMA);
		query.append("PASSWORD, ");
		query.append("ROLE_FK) ");
		query.append(DbConstants.VALUES);
		query.append("(?, ?, ?)");

		return query.toString();
	}

	/**
	 * Constructor privado de la clase
	 */
	private RegistroDbConstants() {
	}

}
