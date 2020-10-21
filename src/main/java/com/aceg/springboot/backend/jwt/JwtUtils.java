package com.aceg.springboot.backend.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.aceg.springboot.backend.service.UserDetailsImpl;
import com.aceg.springboot.backend.util.ErrorEnum;

import io.jsonwebtoken.*;

/**
 * - Descripcion: Clase JwtUtils que contiene una seria de metodos
 * para generar y validar el token del usuario (JWT)
 * - Numero de Metodos: 3
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

@Component
public class JwtUtils {

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

	/**
	 * Constante con la clave secreta del JWT
	 */
	private static final String JWT_SECRET = "ACEG.EDGAR.SILVER.4423357630.@";

	/**
	 * constante con el tiempo de expiracion del JWT
	 */
	private static final Long JWT_EXPIRATION = 3600000L;

	/**
	 * Genera el json web token JWT
	 * 
	 * @param authentication
	 * @return
	 */
	public String generateJwtToken(Authentication authentication) {
		
		LOGGER.info("Ejecutando JwtUtils - generateJwtToken()");

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	/**
	 * Obtiene el nombre de usuario del JWT
	 * 
	 * @param token - token del usuario
	 * @return - nombre del usuario
	 */
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * Valida el JWT
	 * 
	 * @param authToken - token
	 * @return - true si el token es valido, false si no es valido
	 */
	public boolean validateJwtToken(String authToken) {
		
		LOGGER.info("Ejecutando JwtUtils - validateJwtToken()");
		
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			LOGGER.error("Invalid JWT signature: {}", e.getMessage());
			AuthEntryPointJwt.MENSAJE = ErrorEnum.EXC_ERROR_TOKEN.getMessage();
		} catch (MalformedJwtException e) {
			LOGGER.error("Invalid JWT token: {}", e.getMessage());
			AuthEntryPointJwt.MENSAJE = ErrorEnum.EXC_ERROR_TOKEN.getMessage();
		} catch (ExpiredJwtException e) {
			LOGGER.error("JWT token is expired: {}", e.getMessage());
			AuthEntryPointJwt.MENSAJE = ErrorEnum.EXC_ERROR_TOKEN_EXP.getMessage();
		} catch (UnsupportedJwtException e) {
			LOGGER.error("JWT token is unsupported: {}", e.getMessage());
			AuthEntryPointJwt.MENSAJE = ErrorEnum.EXC_ERROR_TOKEN.getMessage();
		} catch (IllegalArgumentException e) {
			LOGGER.error("JWT claims string is empty: {}", e.getMessage());
			AuthEntryPointJwt.MENSAJE = ErrorEnum.EXC_ERROR_TOKEN.getMessage();
		}

		return false;
	}
}
