package com.idat.Evaluacion2SW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Evaluacion2SW.dto.UsuarioRequestDTO;
import com.idat.Evaluacion2SW.dto.UsuarioResponseDTO;
import com.idat.Evaluacion2SW.seguridad.JwtTokenUtil;
import com.idat.Evaluacion2SW.seguridad.UsuarioDetalleServicio;

@RestController
public class UsuarioController {
	
	@Autowired
	private JwtTokenUtil util;
	
	@Autowired
	private UsuarioDetalleServicio service;
	
	@RequestMapping(path = "/crearToken",method=RequestMethod.POST)
	private ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO dto){
		
		UserDetails details = service.loadUserByUsername(dto.getUsuario());
		
		return ResponseEntity.ok(new UsuarioResponseDTO(util.generateToken(details.getUsername())));
	}
	
}
