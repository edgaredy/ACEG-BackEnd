package com.aceg.springboot.backend.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * - Descripcion: Clase AuthEntryPointJwt que muestra contenido no autorizado
 * a un usuario cuando se requiere
 * - Numero de Metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	/**
	 * Muestra mensaje de acceso no autorizado cuando un usuario no cuenta con token o
	 * no tiene permisos para acceder al contenido
	 * 
	 * @param request - objeto con la informacion
	 * @param response - objeto con la informacion de respuesta
	 * @param authException - objeto con las excepciones relacionadas a cualquier tipo de
	 * 						  invalidacion
	 * @throws IOException - en caso de algun error
	 * @throws ServletException - en caso de algun error
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		LOGGER.info("Ejecuatndo AuthEntryPointJwt - commence()");
		
		LOGGER.error("Unauthorized error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}

}
