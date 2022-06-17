package com.idat.Evaluacion2SW.model ;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idproducto;
	
	private String producto;
	
	private String descripcion;
	
	private double precio;
	
	private int stock;
	
	@ManyToMany(mappedBy = "producto",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Cliente> cliente= new ArrayList<Cliente>();
	
	@OneToMany(mappedBy = "producto")
	private List<Bodega> bodega=new ArrayList<>();

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
	public Productos(int idproducto, String producto, String descripcion, double precio, int stock,
			List<Cliente> cliente, List<Bodega> bodega) {
		super();
		this.idproducto = idproducto;
		this.producto = producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.cliente = cliente;
		this.bodega = bodega;
	}

	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
