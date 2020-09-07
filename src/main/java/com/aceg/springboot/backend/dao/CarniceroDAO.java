/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceg.springboot.backend.models.CarniceroBean;
import com.aceg.springboot.backend.util.CarniceroDbConstantes;

/**
 * - Descripcion: Clase CarniceroDAO de la aplicacion que implementa los metodos
 * de la interfaz ICarniceroDAO la cual realiza consultas a la DB pertenecientes
 * a un CARNICERO
 * 
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 07/09/2020
 */
@Repository // traduce los errores de BD a excepciones de tipo DataAccessException
public class CarniceroDAO implements ICarniceroDAO {

	/**
	 * Referencia hacia JDBCTemplate
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * La Constante LOGGER que obtiene el Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarniceroDAO.class);

	/**
	 * Metodo que registra a un nuevo carnicero en la DB (INSERT)
	 * 
	 * Nombre de la tabla en DB: ACEG_CARNICERO
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 */
	@Override
	@Transactional
	public CarniceroBean insertCarnicero(CarniceroBean carnicero) {

		LOGGER.info("Ejecutando insertCarnicero()");

		try {
			jdbcTemplate.update(CarniceroDbConstantes.INSERT_CARNICERO, carnicero.getNombre(), carnicero.getApellido(),
					carnicero.getGenero(), carnicero.getEmail(), carnicero.getTelefono(), carnicero.getDireccion(),
					carnicero.getCp(), carnicero.getSueldoMensul(), carnicero.getIdCarniceria(),
					carnicero.getIdCarnicero(), carnicero.getPassword());
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.error("ERROR insertCarnicero(): EmptyResultDataAccessException", ex);
		} catch (RuntimeException re) {
			LOGGER.error("ERROR insertCarnicero(): RuntimeException", re);
		}

		return carnicero;
	}

}
