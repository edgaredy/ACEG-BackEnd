/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.registro;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.util.ERole;

/**
 * - Descripcion: Interfaz IRegistroDao de la aplicacion que realiza consultas a la
 * DB para el registro de nuevos usuarios
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

public interface IRegistroDao {

	/**
	 * Metodo que registra a un nuevo usuario en la DB (INSERT)
	 * Nombre de la tabla: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR
	 * dependiendo el tipo de usuario
	 * 
	 * @param usuario - Bean con los datos del usuario
	 * @param role - Role del usuario
	 * @return - Bean con los datos del usuario registrado
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public UsuarioBean registrarUsuario(UsuarioBean usuario, ERole role) throws AcegDaoException;
	
	public boolean existsByUsername(String email) throws AcegDaoException;
	
	public boolean findByRole(ERole role) throws AcegDaoException;

}
