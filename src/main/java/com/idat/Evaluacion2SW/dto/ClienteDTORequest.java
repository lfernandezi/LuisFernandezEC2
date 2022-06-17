package com.idat.Evaluacion2SW.dto;

public class ClienteDTORequest {

	private int idclienteDTO;
	
	private String nombreDTO;
	
	private String direccionDTO;
	
	private String dniDTO;

	public ClienteDTORequest(int idclienteDTO, String nombreDTO, String direccionDTO, String dniDTO) {
		super();
		this.idclienteDTO = idclienteDTO;
		this.nombreDTO = nombreDTO;
		this.direccionDTO = direccionDTO;
		this.dniDTO = dniDTO;
	}

	public int getIdclienteDTO() {
		return idclienteDTO;
	}

	public void setIdclienteDTO(int idclienteDTO) {
		this.idclienteDTO = idclienteDTO;
	}

	public String getNombreDTO() {
		return nombreDTO;
	}

	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}

	public String getDireccionDTO() {
		return direccionDTO;
	}

	public void setDireccionDTO(String direccionDTO) {
		this.direccionDTO = direccionDTO;
	}

	public String getDniDTO() {
		return dniDTO;
	}

	public void setDniDTO(String dniDTO) {
		this.dniDTO = dniDTO;
	}

	public ClienteDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
