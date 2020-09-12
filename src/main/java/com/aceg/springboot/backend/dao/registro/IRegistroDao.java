/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.registro;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.models.carnicero.CarniceroBean;

/**
 * - Descripcion: Interfaz IRegistroDao de la aplicacion que realiza consultas a la
 * DB para el registro de nuevos usuarios
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

public interface IRegistroDao {

	/**
	 * Metodo que registra a un nuevo carnicero en la DB (INSERT)
	 * Nombre de la tabla: ACEG_CARNICERO
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 * @throws AcegDaoException - error de base de datos
	 */
	public CarniceroBean registrarCarnicero(CarniceroBean carnicero) throws AcegDaoException;

}
