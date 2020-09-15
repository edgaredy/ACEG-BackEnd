package com.aceg.springboot.backend.models;

import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private String password;
	private List<String> roles;

	public JwtResponse(String accessToken, Integer id, String username, String password, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getpassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
