/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.registro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegRegistroInexistenteException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.rowmapper.RolRowMapper;
import com.aceg.springboot.backend.rowmapper.UsuarioRowMapper;
import com.aceg.springboot.backend.util.AcegConstantes;
import com.aceg.springboot.backend.util.ERole;
import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.RegistroDbConstants;

/**
 * - Descripcion: Clase RegistroDao de la aplicacion que implementa la interfaz
 * IRegistroDao que realiza consultas a la DB para el registro de nuevos
 * usuarios 
 * - Numero de Metodos: 6
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
	 * - Registra a un nuevo usuario en la DB (INSERT) en la tabla correspondiente 
	 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO,
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

		// mientras el usuario no sea admisnitrador realizo el insert en su tabla correspondiente 
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
	 * - Registra a un nuevo usuario de tipo Cliente en la DB
	 * - Nombre de tabla: ACEG_CLIENTE
	 * 
	 * @param usuario - datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	private void registrarCliente(UsuarioBean usuario) throws AcegDaoException {
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_CLIENTE, usuario.getNombre(), usuario.getApellido(),
					usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
					usuario.getCp(), usuario.getIdEstado());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}
	}
	
	/**
	 * - Registra a un nuevo usuario de tipo Carnicero en la DB
	 * - Nombre de tabla: ACEG_CARNICERO
	 * 
	 * @param usuario - datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	private void registrarCarnicero(UsuarioBean usuario) throws AcegDaoException {
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_CARNICERO, usuario.getNombre(),
					usuario.getApellido(), usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(),
					usuario.getDireccion(), usuario.getCp(), usuario.getSueldoMensual(),
					usuario.getIdCarniceria(), usuario.getIdEstado());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}
	}
	
	/**
	 * - Registra a un nuevo usuario de tipo Proveedor en la DB
	 * - Nombre de tabla: ACEG_PROVEEDOR
	 * 
	 * @param usuario - datos del usuario
	 * @throws AcegDaoException - error de base de datos
	 */
	private void registrarProvedor(UsuarioBean usuario) throws AcegDaoException {
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_PROVEEDOR, usuario.getNombreEmpresa(),
					usuario.getNombre(), usuario.getApellido(), usuario.getGenero(), usuario.getEmail(),
					usuario.getTelefono(), usuario.getDireccion(), usuario.getCp());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error(AcegConstantes.ERROR_EX, ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}
	}

	/**
	 * - Verifica la existencia de un usuario en la DB 
	 * - Nombre de tabla: ACEG_USUARIO
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
			LOGGER.info("Email - El email del usuario no existe");
			return false;
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

}
