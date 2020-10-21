/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.dao.registro;

import com.aceg.springboot.backend.exception.AcegDaoException;
import com.aceg.springboot.backend.models.estado.EstadoResponse;
import com.aceg.springboot.backend.models.municipio.MunicipioResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.models.usuario.UsuarioResponse;
import com.aceg.springboot.backend.util.ERole;

/**
 * - Descripcion: Interfaz IRegistroDao de la aplicacion que contiene los
 * metodos que seran implementados para realiza consultas a la DB para el
 * registro de nuevos usuarios asi como la validacion de estos
 * - Numero de Metodos: 6 
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

public interface IRegistroDao {

	/**
	 * - Registra a un nuevo usuario en la DB (INSERT) en la tabla correspondiente
	 * - Nombre de las tablas: ACEG_USUARIO, ACEG_CLIENTE, ACEG_CARNICERO, ACEG_PROVEEDOR 
	 * dependiendo del tipo de usuario
	 * 
	 * @param usuario - Bean con los datos del usuario
	 * @param role    - Role del usuario
	 * @return - Bean con los datos del usuario registrado
	 * @throws AcegDaoException - error de base de datos
	 */
	public UsuarioBean registrarUsuario(UsuarioBean usuario, ERole role) throws AcegDaoException;

	/**
	 * - Verifica la existencia de un usuario en la DB
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @param email - email del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegDaoException - error de base de datos
	 */
	public boolean existsByUsername(String email) throws AcegDaoException;

	/**
	 * - Verifica la existencia del rol del usaurio en la DB
	 * - Nombre de tabla: ACEG_ROLE
	 * 
	 * @param role - rol del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegDaoException - error de base de datos
	 */
	public boolean findByRole(ERole role) throws AcegDaoException;
	
	/**
	 * - Obtiene el nombre de las carnicerias
	 * - Nombre de tabla: ACEG_CARNICERIA
	 * 
	 * @param idEstado - id del estado
	 * @return - lista de nombres de carnicerias
	 * @throws AcegDaoException - error de base de datos
	 */
	public UsuarioResponse getNombreCarniceriasByIdEstado(Long idEstado) throws AcegDaoException;
	
	/**
	 * - Obtiene la lista de estados
	 * - Nombre de tabla: ACEG_ESTADO
	 * 
	 * @return - lista de estados
	 * @throws AcegDaoException - error de base de datos
	 */
	public EstadoResponse getEstados() throws AcegDaoException;
	
	/**
	 * - Obtiene la lista de municipios por id de estado
	 * - Nombre de tabla: ACEG_MUNICIPIO
	 * 
	 * @param idEstado - id del estado
	 * @return - lista de municipios
	 * @throws AcegDaoException - error de base de datos
	 */
	public MunicipioResponse getMunicipiosById(Long idEstado) throws AcegDaoException;

}
