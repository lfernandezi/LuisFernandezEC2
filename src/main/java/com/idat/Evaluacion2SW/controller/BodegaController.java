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
import com.idat.Evaluacion2SW.dto.BodegaDTORequest;
import com.idat.Evaluacion2SW.dto.BodegaDTOResponse;
import com.idat.Evaluacion2SW.service.BodegaServiceImpl;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaController {
	
	@Autowired
	private BodegaServiceImpl bodservice;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity <List<BodegaDTOResponse>> listar(){
		
		return new ResponseEntity<List<BodegaDTOResponse>>(bodservice.listarbodega(),HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<BodegaDTOResponse> buscar(@PathVariable("id") Integer id){
		BodegaDTOResponse bod= bodservice.buscarbodega(id);
		
		if (bod!=null) {
			return new ResponseEntity<BodegaDTOResponse>(bod,HttpStatus.OK);
		}else {
			return new ResponseEntity<BodegaDTOResponse>(bod,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path= "/guardar",method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bod){
		bodservice.guardarBodega(bod);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/actualizar",method = RequestMethod.PATCH)
	public ResponseEntity<Void> actualizar(@RequestBody BodegaDTORequest bod){
		BodegaDTOResponse b= bodservice.buscarbodega(bod.getIdbodegaDTO());
		if (b != null) {
			bodservice.editarBodega(bod);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable ("id") Integer id){
		BodegaDTOResponse b= bodservice.buscarbodega(id);
		if (b != null) {
			bodservice.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
		
	}


}
