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
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aceg.springboot.backend.service.UserDetailsServiceImpl;

/**
 * - Descripcion: Clase AuthTokenFilter que es un filtro para realizar la
 * autenticacion y verificacion del token del usuario
 * - Numero de Metodos: 2
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

public class AuthTokenFilter extends OncePerRequestFilter {

	/**
	 * Referencia hacia JwtUtils
	 */
	@Autowired
	private JwtUtils jwtUtils;

	/**
	 * Referencia hacia UserDetailsServiceImpl
	 */
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenFilter.class);

	/**
	 * Valida el token
	 * Obtiene el nombre de usuario del token
	 * Verifica existencia del nombre d eusuario en la DB
	 * Autentica el usuario
	 * 
	 * @param request - objeto con la informacion
	 * @param response - objeto con la informacion de respuesta
	 * @param filterChain - filterChain
	 * @throws ServletException - en caso de algun error
	 * @throws IOException - en caso de algun error
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		LOGGER.info("Ejecuatndo AuthTokenFilter - doFilterInternal()");
		
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			LOGGER.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * Obtiene el header del token
	 * Obtiene el token
	 * 
	 * @param request - token del usuario
	 * @return - token del usuario
	 */
	private String parseJwt(HttpServletRequest request) {
		
		LOGGER.info("Ejecuatndo AuthTokenFilter - parseJwt()");
		
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
