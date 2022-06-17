package com.idat.Evaluacion2SW.dto;

public class UsuarioResponseDTO {

	private String token;

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public UsuarioResponseDTO(String token) {
		super();
		this.token = token;
	}

	public UsuarioResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
