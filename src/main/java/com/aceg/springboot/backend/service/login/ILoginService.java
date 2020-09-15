/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service.login;

import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;

/**
 * - Descripcion: Interfaz ILoginService de la aplicacion que realiza consultas a la
 * DB para el acceso de usuario mediante el login
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public interface ILoginService {

	/**
	 * Obtiene el nombre de usuario y contraseña del usuario
	 * 
	 * @param username - nombre de usuario
	 * @param password - contraseña
	 * @return - nombre de usuario y contraseña
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public UsuarioBean getByUsername(String username) throws AcegServiceException;

}
