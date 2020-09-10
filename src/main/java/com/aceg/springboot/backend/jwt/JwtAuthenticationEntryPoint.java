/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.jwt;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * - Descripcion: Clase JwtAuthenticationEntryPoint de la aplicacion que
 * implementa la interfaz AuthenticationEntryPoint y Serializable que envia la
 * rspuesta de acceso no autorizado al contenido en caso de que el usuario o
 * contraseña no correspondan o que no tenga token de acceso 
 * - Numero de metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -7858869558953243875L;
	
	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		LOGGER.debug("Ejecutando JwtAuthenticationEntryPoint - commence()");

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
