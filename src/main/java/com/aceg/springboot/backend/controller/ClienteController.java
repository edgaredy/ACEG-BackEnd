/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * - Descripcion: Clase ClienteController
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/10/2020
 */

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	/**
	 * Metodo de prueba para el funcionamiero del rol cliente
	 * @return - String Solo Clientes
	 */
	@GetMapping("/home")
	public String clienteAccess() {
		return "Solo Clientes.";
	}

}
