/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * - Descripcion: Clase CarniceroController
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/10/2020
 */

@RestController
@RequestMapping("/carnicero")
public class CarniceroController {
	
	/**
	 * Metodo de prueba para el funcionamiento del rol carnicero
	 * @return - String Solo Carniceros
	 */
	@GetMapping("/home")
	public String carniceroAccess() {
		return "Solo Carniceros.";
	}

}
