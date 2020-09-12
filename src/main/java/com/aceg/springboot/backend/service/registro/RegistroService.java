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
import com.aceg.springboot.backend.models.carnicero.CarniceroBean;

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
	 * Metodo que registra a un nuevo carnicero en la DB (INSERT)
	 * Nombre de la tabla: ACEG_CARNICERO
	 * 
	 * @param carnicero - Los datos del carnicero
	 * @return - El carnicero registrado
	 * @throws AcegServiceException - excepcion de servicio
	 */
	@Override
	public CarniceroBean registrarCarnicero(CarniceroBean carnicero) throws AcegServiceException {

		LOGGER.info("Entra registrarCarnicero()");

		try {
			return registroDao.registrarCarnicero(carnicero);
		} catch (AcegDaoException ex) {
			LOGGER.error("ERROR: ", ex);
			throw new AcegServiceException(ex.getError());
		}
	}

}
