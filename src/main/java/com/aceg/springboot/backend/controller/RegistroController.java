/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.carnicero.CarniceroBean;
import com.aceg.springboot.backend.service.registro.IRegistroService;

/**
 * - Descripcion: Clase RegistroController para le gestion de registro de un
 * nuevo usuario asi como la validacion de la existencia del mismo
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@RestController
@RequestMapping("/aceg/api")
public class RegistroController {

	/**
	 * Referencia hacia IRegistroService
	 */
	@Autowired
	private IRegistroService registroService;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);

	/**
	 * Inserta a un nuevo carnicero en la DB
	 * 
	 * Nombre de tabla: ACEG_CARNICERO
	 * INFO: Diferencia del POST y PUT es que el POST se utiliza para crear algo
	 * nuevo y el PUT se utiliza para hacer un update
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 * @exception AcegServiceException - excepcion de capa de servicio
	 */
	@PostMapping("/insert/new/carnicero")
	public ResponseEntity<CarniceroBean> registrarCarnicero(@RequestBody CarniceroBean carnicero) throws AcegServiceException {

		LOGGER.info("-- Ejecutando CarniceroController - registrarCarnicero()");
		
		CarniceroBean carniceroBean = new CarniceroBean();
		carniceroBean =  registroService.registrarCarnicero(carnicero);
		
		return new ResponseEntity<>(carniceroBean, HttpStatus.OK);
	}

}
