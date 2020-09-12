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
import com.aceg.springboot.backend.models.carnicero.CarniceroBean;
import com.aceg.springboot.backend.util.ErrorEnum;
import com.aceg.springboot.backend.util.LoginDbConstantes;

/**
 * - Descripcion: Clase RegistroDao de la aplicacion que implementa la interfaz
 * IRegistroDao que realiza consultas a la DB para el registro de nuevos usuarios
 * - Numero de Metodos: 1
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
	 * Registra a un nuevo carnicero en la DB (INSERT)
	 * Nombre de la tabla: ACEG_CARNICERO
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 * @throws AcegDaoException - error de base de datos
	 */
	@Override
	@Transactional
	public CarniceroBean registrarCarnicero(CarniceroBean carnicero) throws AcegDaoException {

		LOGGER.info("Ejecutando registrarCarnicero()");

		try {
			jdbcTemplate.update(LoginDbConstantes.INSERT_CARNICERO, carnicero.getNombre(), carnicero.getApellido(),
					carnicero.getGenero(), carnicero.getEmail(), carnicero.getTelefono(), carnicero.getDireccion(),
					carnicero.getCp(), carnicero.getSueldoMensual(), carnicero.getIdCarniceria(),
					carnicero.getIdEstado());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE_BD);
		} 

		return carnicero;
	}

}
