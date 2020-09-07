/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao;

import com.aceg.springboot.backend.models.CarniceroBean;

/**
 * - Descripcion: Interface ICarniceroService de la aplicacion que realiza
 * consultas a la DB pertenecientes a un CARNICERO
 * 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 07/09/2020
 */
public interface ICarniceroDAO {

	/**
	 * Metodo que registra a un nuevo carnicero en la DB (INSERT)
	 * 
	 * Nombre de la tabla en DB: ACEG_CARNICERO
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 */
	public CarniceroBean insertCarnicero(CarniceroBean carnicero);

}
