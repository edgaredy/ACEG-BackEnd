/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.login;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;

/**
 * - Descripcion: Interfaz ILoginDao de la aplicacion contien los metodos que
 * seran implementados para realiza consultas a la DB para el acceso de un
 * usuario mediante el login 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

public interface ILoginDao {

	/**
	 * - Verifica la existencia de el nombre de usuario en la DB
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @param username - nombre de usuario
	 * @return - bean con datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	public UsuarioBean getByUsername(String username) throws AcegDaoException;

}
