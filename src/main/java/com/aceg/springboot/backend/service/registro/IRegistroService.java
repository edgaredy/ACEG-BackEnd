/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service.registro;

import com.aceg.springboot.backend.exception.AcegServiceException;
import com.aceg.springboot.backend.models.estado.EstadoResponse;
import com.aceg.springboot.backend.models.municipio.MunicipioResponse;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.models.usuario.UsuarioResponse;
import com.aceg.springboot.backend.util.ERole;

/**
 * - Descripcion: Interfaz IRegistroService que contiene los metodos relacionados
 * al registro de un usuario
 * - Numero de Metodos: 6
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

public interface IRegistroService {

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
	public UsuarioBean registrarUsuario(UsuarioBean usuario, ERole role) throws AcegServiceException;
	
	/**
	 * - Verifica la existencia de un usuario en la DB
	 * - Nombre de tabla: ACEG_USUARIO
	 * 
	 * @param email - email del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public boolean existsByUsername(String email) throws AcegServiceException;
	
	/**
	 * - Verifica la existencia del rol del usaurio en la DB
	 * - Nombre de tabla: ACEG_ROLE
	 * 
	 * @param role - rol del usuario
	 * @return - boolean, true si existe, false si no existe
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public boolean findByRole(ERole role) throws AcegServiceException;
	
	/**
	 * - Obtiene el nombre de las carnicerias
	 * - Nombre de tabla: ACEG_CARNICERIA
	 * 
	 * @param idEstado - id del estado
	 * @return - lista de nombres de carnicerias
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public UsuarioResponse getNombreCarniceriasByIdEstado(Long idEstado) throws AcegServiceException;
	
	/**
	 * - Obtiene el nombre de los estados
	 * - Nombre de tabla: ACEG_ESTADO
	 * 
	 * @return - lista de estados
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public EstadoResponse getEstados() throws AcegServiceException;
	
	/**
	 * - Obtiene el nombre de los municipios por id del estado
	 * - Nombre de tabla: ACEG_MUNICIPIO
	 * 
	 * @param idEstado - id del estado
	 * @return lista de municipios
	 * @throws AcegServiceException - excepcion de servicio
	 */
	public MunicipioResponse getMunicipiosById(Long idEstado) throws AcegServiceException;

}
