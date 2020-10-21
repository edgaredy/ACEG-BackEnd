package com.aceg.springboot.backend.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.aceg.springboot.backend.models.usuario.UsuarioBean;

public class RegistroRowMapper implements RowMapper<UsuarioBean> {
	
	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroRowMapper.class);

	/**
	 * Metodo que realiza el mapeo de la tabla ACEG_LOGIN de la DB
	 * 
	 * @param rs     		   -  El nombre de la columna (pre-inicializado por la fila actual)
	 * @param rowNum 		   -  El numero actual de la fila
	 * @exception SQLException -  Si una SQLException es encontrada al momento de
	 *                         	  obtener el valor (no es necesario realiza un catch a
	 *                         	  SQLException)
	 * @return loginBean 	   -  El valor resultante (puede ser null)
	 */
	@Override
	public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LOGGER.info("-- Ejecutando ROW MAPPER - RegistroRowMapper");

		UsuarioBean usuario = new UsuarioBean();
		
		usuario.setIdCarniceria(rs.getInt("ID_CARNICERIA_PK"));
		usuario.setNombre(rs.getString("NOMBRE"));
		usuario.setDireccion(rs.getString("DIRECCION"));
		usuario.setCp(rs.getString("CP"));
		usuario.setTelefono(rs.getString("TELEFONO"));
		usuario.setDescripcion(rs.getString("DESCRIPCION"));
		usuario.setIdEstado(rs.getInt("ID_ESTADO_FK"));
		usuario.setMunicipio(rs.getString("MUNICIPIO"));
		
		return usuario;
	}

}
