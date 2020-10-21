/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * - Descripcion: Clase AdminController
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/10/2020
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	/**
	 * Metodo de prueba para el funcionamiero del rol admin
	 * @return - String Solo Administradores
	 */
	@GetMapping("/home")
	public String adminAccess() {
		return "Solo Administradores.";
	}

}
