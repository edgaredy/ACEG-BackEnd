/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.registro;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aceg.springboot.backend.controller.exception.DefaultError;
import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegRegistroInexistenteException;
import com.aceg.springboot.backend.models.estado.EstadoBean;
import com.aceg.springboot.backend.models.estado.EstadoResponse;
import com.aceg.springboot.backend.models.municipio.MunicipioBean;
import com.aceg.springboot.backend.models.municipio.MunicipioResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.models.usuario.UsuarioResponse;
import com.aceg.springboot.backend.rowmapper.EstadoRowMapper;
import com.aceg.springboot.backend.rowmapper.MunicipioRowMapper;
import com.aceg.springboot.backend.rowmapper.RegistroRowMapper;
import com.aceg.springboot.backend.rowmapper.RolRowMapper;
import com.aceg.springboot.backend.rowmapper.UsuarioRowMapper;
import com.aceg.springboot.backend.util.AcegConstantes;
import com.aceg.springboot.backend.util.ERole;
import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.RegistroDbConstants;
import com.aceg.springboot.backend.util.SucessEnum;

/**
 * - Descripcion: Clase RegistroDao de la aplicacion que implementa la interfaz
 * IRegistroDao que realiza consultas a la DB para el registro de nuevos
 * usuarios - Numero de Metodos: 9
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@Repository
public class RegistroDao implements IRegistroDao {

	/**
	 * Constante Parametro invalido
	 */
	private static final String INVALID_PARAM = "Parametro invalido";

	/**
	 * Referencia hacia JdbcTemplate
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroDao.class);

	/**
	 * - Registra a un nuevo usuario en la DB (INSERT) en la tabla correspondiente -
	 * Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO,
	 * ACEG_PROVEEDOR dependiendo del tipo de usuario
	 * 
	 * @param usuario - Bean con los datos del usuario
	 * @param role    - Role del usuario
	 * @return - Bean con los datos del usuario registrado
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public UsuarioBean registrarUsuario(UsuarioBean usuario, ERole role) throws AcegDaoException {

		LOGGER.info("Ejecutando RegistroDao- registrarUsuario()");

		// mientras el usuario no sea administrador realizo el insert en su tabla correspondiente
		if (!role.name().equals(ERole.ROLE_ADMINISTRADOR.name())) {
			if (role.name().equals(ERole.ROLE_CLIENTE.name())) {
				registrarCliente(usuario);
			} else if (role.name().equals(ERole.ROLE_CARNICERO.name())) {
				registrarCarnicero(usuario);
			} else if (role.name().equals(ERole.ROLE_PROVEEDOR.name())) {
				registrarProvedor(usuario);
			} else {
				// en caso de que no se encuentre el rol del usuario se lanza una excepcion
				LOGGER.error(INVALID_PARAM);
				throw new AcegDaoException(ErrorEnum.EXC_ERROR_PARAMS);
			}
		}

		// realizo el insert en la tabla ACEG_USUARIO para todos los roles
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_USUARIO, usuario.getEmail(), usuario.getPassword(),
					usuario.getRole());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}

		return usuario;
	}

	/**
	 * - Registra a un nuevo usuario de tipo Cliente en la DB - Nombre de tabla:
	 * ACEG_CLIENTE
	 * 
	 * @param usuario - datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	private void registrarCliente(UsuarioBean usuario) throws AcegDaoException {
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_CLIENTE, usuario.getNombre(), usuario.getApellido(),
					usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
					usuario.getCp(), usuario.getIdEstado(), usuario.getIdMunicipio());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}
	}

	/**
	 * - Registra a un nuevo usuario de tipo Carnicero en la DB - Nombre de tabla:
	 * ACEG_CARNICERO
	 * 
	 * @param usuario - datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	private void registrarCarnicero(UsuarioBean usuario) throws AcegDaoException {
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_CARNICERO, usuario.getNombre(), usuario.getApellido(),
					usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
					usuario.getCp(), usuario.getSueldoMensual(), usuario.getIdCarniceria(), usuario.getIdEstado(), 
					usuario.getIdMunicipio());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}
	}

	/**
	 * - Registra a un nuevo usuario de tipo Proveedor en la DB - Nombre de tabla:
	 * ACEG_PROVEEDOR
	 * 
	 * @param usuario - datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	private void registrarProvedor(UsuarioBean usuario) throws AcegDaoException {
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_PROVEEDOR, usuario.getNombreEmpresa(), usuario.getNombre(),
					usuario.getApellido(), usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getIdEstado(), usuario.getIdMunicipio());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}
	}

	/**
	 * - Verifica la existencia de un usuario en la DB - Nombre de tabla:
	 * ACEG_USUARIO
	 * 
	 * @param email - email del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public boolean existsByUsername(String email) throws AcegDaoException {

		LOGGER.info("Ejecutando RegistroDao - existsByUsername()");

		try {
			jdbcTemplate.queryForObject(RegistroDbConstants.GETBYEMAIL, new Object[] { email }, new UsuarioRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROREmpty: ", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE_BD);
		} catch (RuntimeException re) {
			LOGGER.error(AcegConstantes.ERROR_EX, re);
			throw new AcegDaoException(ErrorEnum.EXC_ERROR_BBDD);
		}

		return true;
	}

	/**
	 * - Verifica la existencia del rol del usaurio en la DB - Nombre de tabla:
	 * ACEG_ROLE
	 * 
	 * @param role - rol del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public boolean findByRole(ERole role) throws AcegDaoException {

		LOGGER.info("Ejecutando RegistroDao - findByRole()");

		try {
			jdbcTemplate.queryForObject(RegistroDbConstants.GETBYROL, new Object[] { role.name() }, new RolRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.info("Role - El role del usuario no existe");
			return false;
		}

		return true;
	}

	/**
	 * - Obtiene el nombre de las carnicerias
	 * - Nombre de tabla: ACEG_CARNICERIA
	 * 
	 * @param idEstado - id del estado
	 * @return - lista de nombres de carnicerias
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public UsuarioResponse getNombreCarniceriasByIdEstado(Long idEstado) throws AcegDaoException {

		LOGGER.info("Ejecutando RegistroDao - getNombreCarnicerias()");

		UsuarioResponse usuarioResponse = null;
		DefaultError defaultError = new DefaultError(ErrorEnum.EXC_GENERICO);
		List<UsuarioBean> carnicerias = new ArrayList<UsuarioBean>();

		try {
			usuarioResponse = new UsuarioResponse();
			carnicerias = jdbcTemplate.query(RegistroDbConstants.GETNAMECARNICERIAS, new Object[] { idEstado },
					new RegistroRowMapper());
			usuarioResponse.setContent(carnicerias);
			defaultError = new DefaultError(SucessEnum.EXC_OPER_EXITOSA);
			usuarioResponse.setResponseCode(defaultError);

		} catch (EmptyResultDataAccessException ex) {
			LOGGER.debug("ERROR: getNombreCarnicerias()", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE_BD);
		} catch (RuntimeException ex) {
			LOGGER.debug("ERROR: getNombreCarnicerias()", ex);
			throw new AcegDaoException(ErrorEnum.EXC_ERROR_BBDD);
		}

		return usuarioResponse;
	}

	/**
	 * - Obtiene la lista de estados
	 * - Nombre de tabla: ACEG_ESTADO
	 * 
	 * @return - lista de estados
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public EstadoResponse getEstados() throws AcegDaoException {

		LOGGER.info("Ejecutando RegistroDao - getEstados()");

		EstadoResponse estadoResponse = null;
		DefaultError defaultError = new DefaultError(ErrorEnum.EXC_GENERICO);
		List<EstadoBean> estados = new ArrayList<EstadoBean>();

		try {
			estadoResponse = new EstadoResponse();
			estados = jdbcTemplate.query(RegistroDbConstants.GETESTADOS, new Object[] {}, new EstadoRowMapper());
			estadoResponse.setContent(estados);
			defaultError = new DefaultError(SucessEnum.EXC_OPER_EXITOSA);
			estadoResponse.setResponseCode(defaultError);

		} catch (EmptyResultDataAccessException ex) {
			LOGGER.debug("ERROR: getEstados()", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE_BD);
		} catch (RuntimeException ex) {
			LOGGER.debug("ERROR: getEstados()", ex);
			throw new AcegDaoException(ErrorEnum.EXC_ERROR_BBDD);
		}

		return estadoResponse;
	}

	/**
	 * - Obtiene la lista de municipios por id de estado
	 * - Nombre de tabla: ACEG_MUNICIPIO
	 * 
	 * @param idEstado - id del estado
	 * @return - lista de municipios
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	public MunicipioResponse getMunicipiosById(Long idEstado) throws AcegDaoException {

		LOGGER.info("Ejecutando RegistroDao - getMunicipios()");

		MunicipioResponse municipiosResonse = null;
		DefaultError defaultError = new DefaultError(ErrorEnum.EXC_GENERICO);
		List<MunicipioBean> municipio = new ArrayList<MunicipioBean>();

		try {			
			municipiosResonse = new MunicipioResponse();
			municipio = jdbcTemplate.query(RegistroDbConstants.GETMUNICIPIOS, new Object[] { idEstado }, new MunicipioRowMapper());
			municipiosResonse.setContent(municipio);
			defaultError = new DefaultError(SucessEnum.EXC_OPER_EXITOSA);
			municipiosResonse.setResponseCode(defaultError);

		} catch (EmptyResultDataAccessException ex) {
			LOGGER.debug("ERROR: getMunicipios()", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE_BD);
		} catch (RuntimeException ex) {
			LOGGER.debug("ERROR: getMunicipios()", ex);
			throw new AcegDaoException(ErrorEnum.EXC_ERROR_BBDD);
		}

		return municipiosResonse;
	}

}
