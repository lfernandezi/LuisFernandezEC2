package com.idat.Evaluacion2SW.dto;

public class ProductoDTORequest {

	private int idproductoDTO;
	
	private String productoDTO;
	
	private String descripcionDTO;
	
	private double precioDTO;
	
	private int stockDTO;

	

	public ProductoDTORequest(int idproductoDTO, String productoDTO, String descripcionDTO, double precioDTO,
			int stockDTO) {
		super();
		this.idproductoDTO = idproductoDTO;
		this.productoDTO = productoDTO;
		this.descripcionDTO = descripcionDTO;
		this.precioDTO = precioDTO;
		this.stockDTO = stockDTO;
	}

	public String getDescripcionDTO() {
		return descripcionDTO;
	}

	public void setDescripcionDTO(String descripcionDTO) {
		this.descripcionDTO = descripcionDTO;
	}

	public ProductoDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdproductoDTO() {
		return idproductoDTO;
	}

	public void setIdproductoDTO(int idproductoDTO) {
		this.idproductoDTO = idproductoDTO;
	}

	public String getProductoDTO() {
		return productoDTO;
	}

	public void setProductoDTO(String productoDTO) {
		this.productoDTO = productoDTO;
	}


	public double getPrecioDTO() {
		return precioDTO;
	}

	public void setPrecioDTO(double precioDTO) {
		this.precioDTO = precioDTO;
	}

	public int getStockDTO() {
		return stockDTO;
	}

	public void setStockDTO(int stockDTO) {
		this.stockDTO = stockDTO;
	}
	
	
	
}
