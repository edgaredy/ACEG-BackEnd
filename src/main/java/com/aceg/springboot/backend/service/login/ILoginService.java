/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service.login;

import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;

/**
 * - Descripcion: Interfaz ILoginService que contiene los metodos relacionados
 * al logeo de un usuario al aplicativo ACEG
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public interface ILoginService {

	/**
	 * - Verifica la existencia de el nombre de usuario en la DB
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @param username - nombre de usuario
	 * @return - bean con datos del usuario
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public UsuarioBean getByUsername(String username) throws AcegServiceException;

}
