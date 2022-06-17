package com.idat.Evaluacion2SW.service;

import java.util.List;

import com.idat.Evaluacion2SW.dto.BodegaDTORequest;
import com.idat.Evaluacion2SW.dto.BodegaDTOResponse;

public interface BodegaService {

	public List<BodegaDTOResponse> listarbodega();
	
	public BodegaDTOResponse buscarbodega(Integer id);
	
	public void guardarBodega(BodegaDTORequest bodega);
	
	public void editarBodega(BodegaDTORequest bodega);
	
	public void eliminarBodega(Integer id);
}
