/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceg.springboot.backend.dao.ICarniceroDAO;
import com.aceg.springboot.backend.models.CarniceroBean;

/**
 * - Descripcion: Interface CarniceroService que implementa los metodos de la
 * interfaz ICarniceroService la cual expone los servicios de CARNICEROS
 * 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 07/09/2020
 */
@Service
public class CarniceroService implements ICarniceroService {

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarniceroService.class);

	/**
	 * Referencia hacia carniceroDAO
	 */
	@Autowired
	private ICarniceroDAO carniceroDAO;

	/**
	 * Metodo que registra a un nuevo carnicero en la DB (INSERT)
	 * 
	 * Nombre de la tabla en DB: ACEG_CARNICERO
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 */
	@Override
	public CarniceroBean insertCarnicero(CarniceroBean carnicero) {

		LOGGER.debug("Entra insertCarnicero()");

		return carniceroDAO.insertCarnicero(carnicero);
	}

}
