package com.idat.Evaluacion2SW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Evaluacion2SW.dto.ClienteDTORequest;
import com.idat.Evaluacion2SW.dto.ClienteDTOResponse;
import com.idat.Evaluacion2SW.service.ClienteServiceImpl;


@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl cliservice;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity <List<ClienteDTOResponse>> listar(){
		
		return new ResponseEntity<List<ClienteDTOResponse>>(cliservice.listarcliente(),HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> buscar(@PathVariable("id") Integer id){
		ClienteDTOResponse cli= cliservice.buscarcliente(id);
		
		if (cli!=null) {
			return new ResponseEntity<ClienteDTOResponse>(cli,HttpStatus.OK);
		}else {
			return new ResponseEntity<ClienteDTOResponse>(cli,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path= "/guardar",method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cli){
		cliservice.guardarcliente(cli);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/actualizar",method = RequestMethod.PATCH)
	public ResponseEntity<Void> actualizar(@RequestBody ClienteDTORequest cli){
		ClienteDTOResponse c= cliservice.buscarcliente(cli.getIdclienteDTO());
		if (c != null) {
			cliservice.editarcliente(cli);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable ("id") Integer id){
		ClienteDTOResponse c= cliservice.buscarcliente(id);
		if (c != null) {
			cliservice.eliminarcliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
		
	}

}
