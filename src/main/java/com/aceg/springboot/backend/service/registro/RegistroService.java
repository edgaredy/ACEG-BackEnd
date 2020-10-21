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
import com.aceg.springboot.backend.models.estado.EstadoResponse;
import com.aceg.springboot.backend.models.municipio.MunicipioResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.models.usuario.UsuarioResponse;
import com.aceg.springboot.backend.util.AcegConstantes;
import com.aceg.springboot.backend.util.ERole;

/**
 * - Descripcion: Clase RegistroService que contiene los metodos relacionados
 * al registro de un usuario
 * - Numero de Metodos: 6
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

		LOGGER.info("Entra RegistroService - registrarUsuario()");
		
		UsuarioBean usuarioBean = null;	

		try {
			usuarioBean = registroDao.registrarUsuario(usuario, role);
		} catch (AcegDaoException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegServiceException(ex.getError());
		}
		
		LOGGER.info("Sale RegistroService - registrarUsuario()");
		
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
		
		LOGGER.info("Entra RegistroService - existsByUsername()");
		
		boolean emailExiste = false;
		
		try {
			emailExiste = registroDao.existsByUsername(email);
		} catch (AcegDaoException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			// throw new AcegServiceException(ex.getError());
			return emailExiste;
		}
		
		LOGGER.info("Sale RegistroService - existsByUsername()");
		
		return emailExiste;
		
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
		
		LOGGER.info("Entra RegistroService - findByRole()");
		
		boolean resultado;
		
		try {
			resultado = registroDao.findByRole(role);
		} catch (AcegDaoException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegServiceException(ex.getError());
		}
		
		LOGGER.info("Sale RegistroService - findByRole()");
		
		return resultado;
	}

	/**
	 * - Obtiene el nombre de las carnicerias
	 * - Nombre de tabla: ACEG_CARNICERIA
	 * 
	 * @param idEstado - id del estado
	 * @return - lista de nombres de carnicerias
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	public UsuarioResponse getNombreCarniceriasByIdEstado(Long idEstado) throws AcegServiceException {
		
		LOGGER.info("Entra RegistroService - getNombreCarnicerias()");
		
		UsuarioResponse usuarioResponse = null;
		
		try {
			usuarioResponse = registroDao.getNombreCarniceriasByIdEstado(idEstado);
		} catch (AcegDaoException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegServiceException(ex.getError());
		}
		
		LOGGER.info("Sale RegistroService - getNombreCarnicerias()");
		
		return usuarioResponse;
	}

	/**
	 * - Obtiene el nombre de los estados
	 * - Nombre de tabla: ACEG_ESTADO
	 * 
	 * @return - lista de esatdos
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	public EstadoResponse getEstados() throws AcegServiceException {
		
	LOGGER.info("Entra RegistroService - getEstados()");
		
		EstadoResponse estadoResponse = null;
		
		try {
			estadoResponse = registroDao.getEstados();
		} catch (AcegDaoException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegServiceException(ex.getError());
		}
		
		LOGGER.info("Sale RegistroService - getEstados()");
		
		return estadoResponse;
	}

	/**
	 * - Obtiene el nombre de los municipios por id del estado
	 * - Nombre de tabla: ACEG_MUNICIPIO
	 * 
	 * @param idEstado - id del estado
	 * @return lista de municipios
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	public MunicipioResponse getMunicipiosById(Long idEstado) throws AcegServiceException {
		
		LOGGER.info("Entra RegistroService - getMunicipios()");
		
		MunicipioResponse municipioResponse = null;
		
		try {
			municipioResponse = registroDao.getMunicipiosById(idEstado);
		} catch (AcegDaoException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegServiceException(ex.getError());
		}
		
		LOGGER.info("Sale RegistroService - getMunicipios()");
		
		return municipioResponse;
	}

}
