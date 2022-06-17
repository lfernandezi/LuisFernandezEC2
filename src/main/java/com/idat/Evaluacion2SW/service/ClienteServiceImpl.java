package com.idat.Evaluacion2SW.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion2SW.dto.ClienteDTORequest;
import com.idat.Evaluacion2SW.dto.ClienteDTOResponse;
import com.idat.Evaluacion2SW.model.Cliente;
import com.idat.Evaluacion2SW.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clirepo;

	@Override
	public List<ClienteDTOResponse> listarcliente() {
		List<ClienteDTOResponse> lista= new ArrayList<ClienteDTOResponse>();
		
		for(Cliente c : clirepo.findAll()) {
			ClienteDTOResponse cli = new ClienteDTOResponse();
			cli.setIdclienteDTO(c.getIdcliente());
			cli.setNombreDTO(c.getNombre());
			cli.setDireccionDTO(c.getDireccion());
			cli.setDniDTO(c.getDni());
			lista.add(cli);
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public ClienteDTOResponse buscarcliente(Integer id) {
		Cliente c = clirepo.findById(id).orElse(null);
		ClienteDTOResponse cli = new ClienteDTOResponse();
		cli.setIdclienteDTO(c.getIdcliente());
		cli.setNombreDTO(c.getNombre());
		cli.setDireccionDTO(c.getDireccion());
		cli.setDniDTO(c.getDni());
		
		return cli;
	}

	@Override
	public void guardarcliente(ClienteDTORequest cliente) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		
		c.setNombre(cliente.getNombreDTO());
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		
		 clirepo.save(c);
		
	}

	@Override
	public void editarcliente(ClienteDTORequest cliente) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setIdcliente(cliente.getIdclienteDTO());
		c.setNombre(cliente.getNombreDTO());
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		
		 clirepo.saveAndFlush(c);
		
	}

	@Override
	public void eliminarcliente(Integer id) {
		clirepo.deleteById(id);
	}

}
