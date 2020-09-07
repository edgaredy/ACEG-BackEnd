/**
 * 
 */
package com.aceg.springboot.backend.util;

/**
 * - Descripcion: Clase CarniceroDbConstantes que contiene las consultas de los
 * CARNICEROS
 * 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 07/09/2020
 */
public final class CarniceroDbConstantes {

	/**
	 * Constructor privado de la clase
	 */
	private CarniceroDbConstantes() {
	}

	public static final String SELECT = "SELECT";
	public static final String INSERT = "INSERT";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String IN_TO = "INTO";
	public static final String VALUES = "VALUES";
	public static final String FROM = "FROM";
	public static final String WHERE = "WHERE";
	public static final String ORDER_BY = "ORDER BY";
	public static final String INSERT_CARNICERO = queryInsertCarnicero();

	/**
	 * - Metodo que contiene la consulta para insertar un nuevo carnicero en la DB
	 * 
	 * - Nombre de Tabla en DB: ACEG_CARNICERO
	 * 
	 * @return - El query en formato String
	 */
	public static String queryInsertCarnicero() {

		StringBuilder query = new StringBuilder();

		query.append(INSERT);
		query.append(IN_TO);
		query.append("	ACEG_CARNICERO	");
		query.append("	(NOMBRE,	");
		query.append("	APELLIDO,	");
		query.append("	GENERO,	");
		query.append("	EMAIL,	");
		query.append("	TELEFONO,	");
		query.append("	DIRECCION,	");
		query.append("	CP,	");
		query.append("	SUELDO_MENSUAL,	");
		query.append("	ID_CARNICERIA_FK,	");
		query.append("	ID_ESTADO_FK,	");
		query.append("	PASSWORD),	");
		query.append(VALUES);
		query.append("	(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);	");

		return query.toString();
	}

}
