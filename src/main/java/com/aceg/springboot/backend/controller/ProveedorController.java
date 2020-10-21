/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * - Descripcion: Clase ProveedorController
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/10/2020
 */

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	/**
	 * Metodo de prueba para el funcionamiero del rol proveedor
	 * @return - String Solo Proveedores
	 */
	@GetMapping("/home")
	public String proveedorAccess() {
		return "Solo Proveedores.";
	}

}
