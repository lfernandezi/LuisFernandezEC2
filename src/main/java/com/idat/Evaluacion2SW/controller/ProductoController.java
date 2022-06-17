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

import com.idat.Evaluacion2SW.dto.ProductoDTORequest;
import com.idat.Evaluacion2SW.dto.ProductoDTOResponse;
import com.idat.Evaluacion2SW.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {

	@Autowired
	private ProductoService proservice;
	
	@RequestMapping(path="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoDTOResponse>>  listar(){
		
		return  new ResponseEntity <List<ProductoDTOResponse>>(proservice.listarproducto(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<ProductoDTOResponse> listarPorId(@PathVariable ("id") Integer id){
		ProductoDTOResponse p= proservice.buscarproducto(id);
		
		if (p!=null) {
			return new ResponseEntity<ProductoDTOResponse>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<ProductoDTOResponse>(p,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest producto){
		proservice.guardarProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(path="/actualizar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody ProductoDTORequest producto){
		
		ProductoDTOResponse p= proservice.buscarproducto(producto.getIdproductoDTO());
		if (p!=null) {
			proservice.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id){
		ProductoDTOResponse p= proservice.buscarproducto(id);
		if (p!=null) {
			proservice.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	
}
