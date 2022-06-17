package com.idat.Evaluacion2SW.dto;

public class BodegaDTOResponse {
	
	private int idbodegaDTO;
	
	private String nombreDTO;
	
	private String direccionDTO;
	
	//private int idproductoDTO;

	public int getIdbodegaDTO() {
		return idbodegaDTO;
	}

	public void setIdbodegaDTO(int idbodegaDTO) {
		this.idbodegaDTO = idbodegaDTO;
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

	/*public int getIdproductoDTO() {
		return idproductoDTO;
	}

	public void setIdproductoDTO(int idproductoDTO) {
		this.idproductoDTO = idproductoDTO;
	}*/

	public BodegaDTOResponse(int idbodegaDTO, String nombreDTO, String direccionDTO) {
		super();
		this.idbodegaDTO = idbodegaDTO;
		this.nombreDTO = nombreDTO;
		this.direccionDTO = direccionDTO;
		//this.idproductoDTO = idproductoDTO;
	}

	public BodegaDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
}
