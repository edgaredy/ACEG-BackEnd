/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service.registro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceg.springboot.backend.dao.registro.IRegistroDao;
import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.util.ERole;

/**
 * - Descripcion: Clase RegistroService de la aplicacion que implementa la interfaz
 * IRegistroService que realiza consultas a la DB para el registro de nuevos usuarios
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@Service
public class RegistroService implements IRegistroService {

	/**
	 * Referencia hacia IRegistroDao
	 */
	@Autowired
	private IRegistroDao registroDao;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroService.class);

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
	@Override
	public UsuarioBean registrarUsuario(UsuarioBean usuario, ERole role) throws AcegServiceException {

		LOGGER.info("Entra registrarUsuario()");
		
		UsuarioBean usuarioBean = null;	

		try {
			usuarioBean = registroDao.registrarUsuario(usuario, role);
		} catch (AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegServiceException(ex.getError());
		}
		
		return usuarioBean;
	}

	@Override
	public boolean existsByUsername(String email) throws AcegServiceException {
		
		LOGGER.info("Entra existsByUsername()");
		
		boolean resultado;
		
		try {
			resultado = registroDao.existsByUsername(email);
		} catch (AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegServiceException(ex.getError());
		}
		
		return resultado;
		
	}

	@Override
	public boolean findByRole(ERole role) throws AcegServiceException {
		
		LOGGER.info("Entra findByRole()");
		
		boolean resultado;
		
		try {
			resultado = registroDao.findByRole(role);
		} catch (AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegServiceException(ex.getError());
		}
		
		return resultado;
	}

}
