/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.models.CarniceroBean;
import com.aceg.springboot.backend.service.ICarniceroService;

/**
 * - Descripcion: Clase CarniceroController para las operaciones de Carniceros
 * 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 07/09/2020
 */
@CrossOrigin(origins = { "http://localhost:4200" }) // Permite las peticiones entre angular y java
@RestController // Indica que se utilizara Spring REST Service
@RequestMapping("/aceg/api") // Indica la primera parte de la direccion web http://localhost:8080/aceg/api
public class CarniceroController {

	/**
	 * Referencia hacia carniceroService
	 */
	@Autowired
	private ICarniceroService carniceroService;

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarniceroController.class);

	/**
	 * Inserta a un nuevo carnicero en la DB
	 * 
	 * - Nombre de Tabla en DB: ACEG_CARNICERO
	 * 
	 * - Tipo de Metodo: POST
	 * 
	 * - INFO: Diferencia del POST y PUT es que el POST se utiliza para crear algo
	 * nuevo y el PUT se utiliza para hacer un update
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 */
	@PostMapping("/insert/new/carnicero")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CarniceroBean createCarnicero(@RequestBody CarniceroBean carnicero) {

		LOGGER.info("-- Ejecutando CarniceroController - createCarnicero()");

		return carniceroService.insertCarnicero(carnicero);
	}

}
