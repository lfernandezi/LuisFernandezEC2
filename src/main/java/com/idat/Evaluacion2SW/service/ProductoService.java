package com.idat.Evaluacion2SW.service;

import java.util.List;

import com.idat.Evaluacion2SW.dto.ProductoDTORequest;
import com.idat.Evaluacion2SW.dto.ProductoDTOResponse;

public interface ProductoService {
	
	public List<ProductoDTOResponse> listarproducto();
	
	public ProductoDTOResponse buscarproducto(Integer id);
	
	public void guardarProducto(ProductoDTORequest producto);
	
	public void editarProducto(ProductoDTORequest producto);
	
	public void eliminarProducto(Integer id);
	

}
