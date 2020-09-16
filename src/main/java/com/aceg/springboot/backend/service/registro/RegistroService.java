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
 * - Descripcion: Clase RegistroService que contiene los metodos relacionados
 * al registro de un usuario
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
	 * - Registra a un nuevo usuario en la DB (INSERT) en la tabla correspondiente
	 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR 
	 * dependiendo del tipo de usuario
	 * 
	 * @param usuario - Bean con los datos del usuario
	 * @param role    - Role del usuario
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

	/**
	 * - Verifica la existencia de un usuario en la DB
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @param email - email del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	public boolean existsByUsername(String email) throws AcegServiceException {
		
		LOGGER.info("Entra existsByUsername()");
		
		boolean exmailExiste;
		
		try {
			exmailExiste = registroDao.existsByUsername(email);
		} catch (AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegServiceException(ex.getError());
		}
		
		return exmailExiste;
		
	}

	/**
	 * - Verifica la existencia del rol del usaurio en la DB
	 * - Nombre de tabla: ACEG_ROLE
	 * 
	 * @param role - rol del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegServiceException - excepcion de servicio
	 */
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
