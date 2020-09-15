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
import org.springframework.transaction.annotation.Transactional;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.exception.AcegRegistroInexistenteException;
import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.rowmapper.RolRowMapper;
import com.aceg.springboot.backend.rowmapper.UsuarioRowMapper;
import com.aceg.springboot.backend.util.ERole;
import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.RegistroDbConstants;

/**
 * - Descripcion: Clase RegistroDao de la aplicacion que implementa la interfaz
 * IRegistroDao que realiza consultas a la DB para el registro de nuevos
 * usuarios - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@Repository
public class RegistroDao implements IRegistroDao {

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
	 * Metodo que registra a un nuevo usuario en la DB (INSERT) Nombre de la tabla:
	 * ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR dependiendo el
	 * tipo de usuario
	 * 
	 * @param usuario - Bean con los datos del usuario
	 * @param role    - Role del usuario
	 * @return - Bean con los datos del usuario registrado
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	@Transactional
	public UsuarioBean registrarUsuario(UsuarioBean usuario, ERole role) throws AcegDaoException {

		LOGGER.info("Ejecutando registrarUsuario()");
		

		if (role.name().equals(ERole.CLIENTE.name())) {
			try {
				jdbcTemplate.update(RegistroDbConstants.INSERT_CLIENTE, usuario.getNombre(), usuario.getApellido(),
						usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
						usuario.getCp(), usuario.getIdEstado());
			} catch (EmptyResultDataAccessException ex) {
				LOGGER.error("ERROR: ", ex);
				throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
			}
		} else if (role.name().equals(ERole.CARNICERO.name())) {
			try {
				jdbcTemplate.update(RegistroDbConstants.INSERT_CARNICERO, usuario.getNombre(), usuario.getApellido(),
						usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
						usuario.getCp(), usuario.getSueldoMensual(), usuario.getIdCarniceria(), usuario.getIdEstado());
			} catch (EmptyResultDataAccessException ex) {
				LOGGER.error("ERROR: ", ex);
				throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
			}
		} else if (role.name().equals(ERole.PROVEEDOR.name())) {
			try {
				jdbcTemplate.update(RegistroDbConstants.INSERT_PROVEEDOR, usuario.getNombreEmpresa(),
						usuario.getNombre(), usuario.getApellido(), usuario.getGenero(), usuario.getEmail(),
						usuario.getTelefono(), usuario.getDireccion(), usuario.getCp());
			} catch (EmptyResultDataAccessException ex) {
				LOGGER.error("ERROR: ", ex);
				throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
			}
		} else if (role.name().equals(ERole.ADMINISTRADOR.name())) {
			try {
				jdbcTemplate.update(RegistroDbConstants.INSERT_CARNICERO, usuario.getNombre(), usuario.getApellido(),
						usuario.getGenero(), usuario.getEmail(), usuario.getTelefono(), usuario.getDireccion(),
						usuario.getCp(), usuario.getSueldoMensual(), usuario.getIdCarniceria(), usuario.getIdEstado());
			} catch (EmptyResultDataAccessException ex) {
				LOGGER.error("ERROR: ", ex);
				throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
			}
		} else {
			LOGGER.error("ERROR: Rol del usuario no encontrado");
			throw new AcegDaoException("Rol del usuario no encontrado");
		}
		
		try {
			jdbcTemplate.update(RegistroDbConstants.INSERT_USUARIO, usuario.getEmail(), usuario.getPassword(), usuario.getRoleDb());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_ERROR_REGISTRO);
		}

		return usuario;
	}

	@Override
	public boolean existsByUsername(String email) throws AcegDaoException {

		LOGGER.info("Ejecutando existsByUsername()");

		try {
			jdbcTemplate.queryForObject(RegistroDbConstants.GETBYEMAIL, new Object[] { email }, new UsuarioRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROR: ", ex);
			return false;
		}

		return true;
	}

	@Override
	public boolean findByRole(ERole role) throws AcegDaoException {

		LOGGER.info("Ejecutando findByRole()");

		try {
			jdbcTemplate.queryForObject(RegistroDbConstants.GETBYROL, new Object[] { role.name() }, new RolRowMapper());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROR: ", ex);
			return false;
		}

		return true;
	}

}
