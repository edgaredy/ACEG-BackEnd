/**
 * Package y Librerias de utilidad de la Clase
 */
package com.aceg.springboot.backend.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aceg.springboot.backend.models.RoleBean;
import com.aceg.springboot.backend.models.usuario.UsuarioBean;
import com.aceg.springboot.backend.util.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * - Descripcion: Clase UserDetailsImpl que contiene los atributos de la respuesta 
 * del metodo login de la clase LoginController
 * - Numero de Metodos: 11
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 13/09/2020
 */

public class UserDetailsImpl implements UserDetails {

	/**
	 * Serial UID de la clase
	 */
	private static final long serialVersionUID = 6303215869923354632L;

	/**
	 * id del usuario
	 */
	private Integer id;

	/**
	 * email del usuario
	 */
	private String username;

	/**
	 * contraseña del usuario
	 */
	@JsonIgnore
	private String password;

	/**
	 * roles del usuario
	 */
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * La Constante LOGGER para registro de logs
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsImpl.class);

	/**
	 * Constructor publico de la clase
	 * 
	 * @param id - id del usuario
	 * @param username - email del usuario
	 * @param password - contraseña del usuario
	 * @param authorities - rol del usuario
	 */
	public UserDetailsImpl(Integer id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	/**
	 * Obtiene los datos del usuario (id, email, contraseña, rol)
	 * 
	 * @param usuario - datos del usuario
	 * @return - datos del usuario
	 */
	public static UserDetailsImpl build(UsuarioBean usuario) {

		RoleBean roleUsuario = new RoleBean();
		String role = usuario.getRole();
		Set<RoleBean> roles = new HashSet<>();

		if (role.equals("CARNICERO")) {
			roleUsuario.setName(ERole.CARNICERO);
		} else if (role.equals("CLIENTE")) {
			roleUsuario.setName(ERole.CLIENTE);
		} else if (role.equals("PROVEEDOR")) {
			roleUsuario.setName(ERole.PROVEEDOR);
		} else if (role.equals("ADMINISTRADOR")) {
			roleUsuario.setName(ERole.ADMINISTRADOR);
		} else {
			LOGGER.error("Error, No se pudo obtener el rol del usuario");
		}

		roles.add(roleUsuario);
		usuario.setRoles(roles);

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getName().name())).collect(Collectors.toList());

		return new UserDetailsImpl(usuario.getIdUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
	}

	/**
	 * @return Returns the authorities granted to the user
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * 
	 * @return the id 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the password 
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username 
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Indicates whether the user's account has expired. An expired account cannot be
	 * authenticated.
	 * 
	 * @return true 
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is locked or unlocked. A locked user cannot be
	 * authenticated.
	 * 
	 * @return true 
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Indicates whether the user's credentials (password) has expired. Expired
	 * credentials prevent authentication.
	 * 
	 * @return true 
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is enabled or disabled. A disabled user cannot be
	 * authenticated.
	 * 
	 * @return true 
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * Compara 2 objetos
	 * @return true si los 2 objetos sin iguales, false si no son iguales
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
