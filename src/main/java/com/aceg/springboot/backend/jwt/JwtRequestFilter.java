/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aceg.springboot.backend.service.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * - Descripcion: Clase JwtRequestFilter de la aplicacion que extiende la clase
 * OncePerRequestFilter que verifica la validez del token y permite el acceso al
 * contenido del ella dada la validez del token - Numero de metodos: 1
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	/**
	 * Referencia hacia JwtUserDetailsService
	 */
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	/**
	 * Referencia hacia JwtTokenUtil
	 */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtRequestFilter.class);

	/**
	 * - Descripcion: Metodo que verifica que el token sea de la forma "Bearer
	 * token" y realiza la validacion para que el usuario puede pasar la
	 * configuracion de Spring Security
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		LOGGER.info("Ejecutando JwtRequestFilter - doFilterInternal()");

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		// El token tiene la forma "Bearer token". Eliminamos la palabra Bearer y
		// obtenemos solo el token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				LOGGER.error("No se pudo obtener el token");
			} catch (ExpiredJwtException e) {
				LOGGER.error("El token ha expirado");
			}
		} else {
			LOGGER.error("El token no comienza con la palabra Bearer");
		}

		// Validacion del token
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
			// Si el token es valido, configuramos Spring Security para ser autenticado manualmente
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// Despues de configurar la autenticacion en el contexto, especificamos que el
				// usuario actual esta autentcado, po lo tanto pasa la configuracion de Spring Security
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}

}
