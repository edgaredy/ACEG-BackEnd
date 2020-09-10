/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * - Descripcion: Clase JwtTokenUtil de la aplicacion que extiende la clase
 * Serializable que contiene una serie de metodos para la extraccion de 
 * datos del token
 * - Numero de metodos: 11
 * 
 * JWT esta fromado por: Header, Payload y Signature 
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 10/09/2020
 */

@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = -2550185165626007488L;

	/**
	 * Fecha de expiracion del token
	 */
	private static final long TOKEN_EXPIRATION_DATE = 14000000L;

	/**
	 * Secret key del token
	 */
	private static final String SECRET = "ACEG_BACKEND.SECRET.KEY.ACCES.FK.4423357630";

	/**
	 * Obtiene el nombre de usuario del token
	 * 
	 * @param token - token
	 * @return - nombre de usuario del token
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Obtiene la fecha de creacion del token
	 * @param token - token
	 * @return - fecha de creacion del token
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	/**
	 * Obtiene la fecha de expiracion del token
	 * 
	 * @param token - token
	 * @return - fecha de expiracion del token
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Logica que obtiene uno de los claims del token
	 * - fecha de expiracion del token
	 * - fecha de creacion del token
	 * - nombre de usuario del token
	 * 
	 * @param <T>
	 * @param token - token
	 * @param claimsResolver - pyload(claims) del token
	 * @return - claims del token
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Obtiene los claims del token (payload)
	 * sub: Identifica el sujeto del token, por ejemplo un identificador de usuario.
	 * iat: Identifica la fecha de creación del token, válido para si queremos ponerle 
	 * 		una fecha de caducidad. En formato de tiempo UNIX
	 * exp: Identifica a la fecha de expiración del token.
	 * 
	 * @param token
	 * @return - claims del token
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}

	/**
	 * Obtiene la fecha de expiracion del token
	 * 
	 * @param token - token
	 * @return - fecha de expiracion del token
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * Ignora la fecha de expiracion del token
	 * 
	 * @param token
	 * @return - false
	 */
	private Boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}

	/**
	 * Genera un nuevo token
	 * 
	 * @param userDetails - nombre de usuario y contraseña del usuario
	 * @return - token
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	/**
	 * Logica de generacion del token
	 * 
	 * @param claims - claims del token
	 * @param subject - nombre de usuario
	 * @return - token cifrado 
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_DATE))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	/**
	 * Valida el token del usuario
	 * 
	 * @param token - token
	 * @param userDetails - nombre de usuario y contraseña del usuario
	 * @return - true en caso de que el token sea valido
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
