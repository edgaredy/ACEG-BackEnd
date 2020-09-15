/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.login;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;

/**
 * - Descripcion: Interfaz ILoginDao de la aplicacion que realiza consultas a la
 * DB para el acceso de usuario mediante el login
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public interface ILoginDao {

	/**
	 * Obtiene el nombre de usuario 
	 * 
	 * @param username - nombre de usuario
	 * @return - nombre de usuario y contraseña
	 * @throws AcegDaoException - error de base de datos
	 */
	public UsuarioBean getByUsername(String username) throws AcegDaoException;

}
