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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.aceg.springboot.backend.jwt.AuthEntryPointJwt;
import com.aceg.springboot.backend.jwt.AuthTokenFilter;
import com.aceg.springboot.backend.service.UserDetailsServiceImpl;

/**
 * - Descripcion: Clase ACEGSecurityConfig que permite por medio de sus
 * anotaciones inyectar las configuraciones personalizadas externalizadas por el
 * servicio de configuracion referenciado por el mismo 
 * - Numero de Metodos: 6
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
	 * Referencia hacia UserDetailsServiceImpl
	 */
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	/**
	 * Referencia hacia AuthEntryPointJwt
	 */
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	/**
	 * verifica la autenticacion de un usuario
	 * autentica al usuario por medio de su usario y contraseña
	 * valida el token
	 * obtiene el rol del usuario
	 * 
	 * @return 
	 */
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	/**
	 * verifica la autentidad/existencia de un usuario por medio del metodo loadUserByUsername
	 * obtiene el rol del usuario
	 */
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Autentica a un usuario
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Encripta la contraseña del usuario
	 * @return - contraseña encriptada
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Habilta CORS
	 * Deshabilita CSRF
	 * Muestra una excepcion al usuario en caso de que acceda a contenido no disponible para el
	 * Habilita el inicio del sesion por STATELESS (no se almacena informacion del usuario en memoria)
	 * Sobrecarga de la configuracion por Roles
	 * Verifica la autenticidad del usuario
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests()
					.antMatchers("/carnicero/**").hasRole("CARNICERO")
					.antMatchers("/cliente/**").hasRole("CLIENTE")
					.antMatchers("/proveedor/**").hasRole("PROVEEDOR")
					.antMatchers("/admin/**").hasRole("ADMINISTRADOR")
					.antMatchers("/login/**").permitAll()
					.antMatchers("/registro/**").permitAll()
					.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * Personalizacion de la configuracion CORS
	 * @return - custom Cors
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
