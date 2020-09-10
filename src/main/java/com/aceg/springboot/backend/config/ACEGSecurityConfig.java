/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.aceg.springboot.backend.jwt.JwtAuthenticationEntryPoint;
import com.aceg.springboot.backend.jwt.JwtRequestFilter;

/**
 * - Descripcion: Clase ACEGSecurityConfig que permite por medio de sus
 * anotaciones inyectar las configuraciones personalizadas externalizadas por el
 * servicio de configuracion referenciado por el mismo
 * - Numero de Metodos: 5
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 09/09/2020
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ACEGSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Referencia hacia JwtAuthenticationEntryPoint
	 */
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	/**
	 * Referencia hacia UserDetailsService
	 */
	@Autowired
	private UserDetailsService jwtUserDetailsService;

	/**
	 * Referencia hacia JwtRequestFilter
	 */
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	/**
	 * Sobrecarga de la configuracion por roles
	 * 
	 * - Se habilita CORS
	 * - Se deshabilita CSRF
	 * - No se autentica la ruta http://localhost:8080/aceg/api/authenticate
	 * - Cualquier otra ruta necesita ser autenticada
	 * - Nos asegurarnos de que usamos sesiones sin estado, la sesion no se usara
	 * para almacenar el estado del usuario
	 * - Se agrega un filtro para validar el token para cada peticion
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// habilita cors
		http.cors().and()
				// deshabilita csrf
				.csrf().disable().
				// dont authenticate this particular request
				authorizeRequests().antMatchers("/aceg/api/authenticate").permitAll()
				// all other requests need to be authenticated
				.anyRequest().authenticated()
				// make sure we use stateless session; session won't be used to
				// store user's state.
				.and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * Se configura AuthenticationManager para que se sepa desde donde cargara el
	 * usuario para que coincida con las credenciales usando BCryptPasswordEncoder
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Encripta el password
	 * 
	 * @return password encriptado
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Es el encargado de realizar la comprobacion de la validez del nombre de 
	 * usuario/contraseña asociada y de devolver las autorizaciones permitidas a 
	 * dicho participante(roles asociados). 
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Personalizacion de la configuracion CORS
	 * 
	 * @return custom Cors
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

}
