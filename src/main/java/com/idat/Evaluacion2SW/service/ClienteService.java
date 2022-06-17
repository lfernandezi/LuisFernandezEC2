package com.idat.Evaluacion2SW.service;

import java.util.List;

import com.idat.Evaluacion2SW.dto.ClienteDTORequest;
import com.idat.Evaluacion2SW.dto.ClienteDTOResponse;


public interface ClienteService {

	public List<ClienteDTOResponse> listarcliente();
	
	public ClienteDTOResponse buscarcliente(Integer id);
	
	public void guardarcliente(ClienteDTORequest cliente);
	
	public void editarcliente(ClienteDTORequest cliente);
	
	public void eliminarcliente(Integer id);
}
