package com.idat.Evaluacion2SW.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion2SW.dto.ProductoDTORequest;
import com.idat.Evaluacion2SW.dto.ProductoDTOResponse;
import com.idat.Evaluacion2SW.model.Productos;
import com.idat.Evaluacion2SW.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository prorepo;

	@Override
	public List<ProductoDTOResponse> listarproducto() {
		List<ProductoDTOResponse> lista= new ArrayList<ProductoDTOResponse>();
		
		for(Productos p : prorepo.findAll()) {
			ProductoDTOResponse prod = new ProductoDTOResponse();
			prod.setIdproductoDTO(p.getIdproducto());
			prod.setProductoDTO(p.getProducto());
			prod.setDescripcionDTO(p.getDescripcion());
			prod.setPrecioDTO(p.getPrecio());
			prod.setStockDTO(p.getStock());
			
			lista.add(prod);
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public ProductoDTOResponse buscarproducto(Integer id) {

		Productos p = prorepo.findById(id).orElse(null);
		ProductoDTOResponse prod = new ProductoDTOResponse();
		prod.setIdproductoDTO(p.getIdproducto());
		prod.setProductoDTO(p.getProducto());
		prod.setDescripcionDTO(p.getDescripcion());
		prod.setPrecioDTO(p.getPrecio());
		prod.setStockDTO(p.getStock());
			
	
		// TODO Auto-generated method stub
		return prod;
	}

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		
		Productos p = new Productos();
		
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
			
		prorepo.save(p);
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Productos p = new Productos();
		p.setIdproducto(producto.getIdproductoDTO());
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
			
		prorepo.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		prorepo.deleteById(id);
		
	}

}
