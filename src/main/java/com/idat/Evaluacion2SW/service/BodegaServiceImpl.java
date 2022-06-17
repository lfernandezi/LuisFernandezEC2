package com.idat.Evaluacion2SW.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion2SW.dto.BodegaDTORequest;
import com.idat.Evaluacion2SW.dto.BodegaDTOResponse;
import com.idat.Evaluacion2SW.model.Bodega;
import com.idat.Evaluacion2SW.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository bodrepo;

	@Override
	public List<BodegaDTOResponse> listarbodega() {

		List<BodegaDTOResponse> lista = new ArrayList<BodegaDTOResponse>();

		for (Bodega b : bodrepo.findAll()) {
			BodegaDTOResponse bod = new BodegaDTOResponse();
			bod.setIdbodegaDTO(b.getIdbodega());
			bod.setNombreDTO(b.getNombre());
			bod.setDireccionDTO(b.getDireccion());
			

			lista.add(bod);
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public BodegaDTOResponse buscarbodega(Integer id) {
		Bodega b = bodrepo.findById(id).orElse(null);

		BodegaDTOResponse bod = new BodegaDTOResponse();
		bod.setIdbodegaDTO(b.getIdbodega());
		bod.setNombreDTO(b.getNombre());
		bod.setDireccionDTO(b.getDireccion());
		
		return bod;
	}

	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();

		b.setNombre(bodega.getNombreDTO());
		b.setDireccion(bodega.getDireccionDTO());
		

		bodrepo.save(b);
	}

	@Override
	public void editarBodega(BodegaDTORequest bodega) {
		// TODO Auto-generated method stub
		Bodega b = new Bodega();
		
		b.setIdbodega(bodega.getIdbodegaDTO());
		b.setNombre(bodega.getNombreDTO());
		b.setDireccion(bodega.getDireccionDTO());
		

		bodrepo.saveAndFlush(b);
	}

	@Override
	public void eliminarBodega(Integer id) {
		// TODO Auto-generated method stub
		bodrepo.deleteById(id);

	}

}
