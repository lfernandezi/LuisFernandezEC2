package com.idat.Evaluacion2SW.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bodega")
public class Bodega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idbodega;
	
	private String nombre;
	
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="idproducto", 
				nullable = false, 
				unique = true,
				foreignKey =@ForeignKey(foreignKeyDefinition = "foreign key (idproducto) references productos (idproducto)"))
	private Productos producto;



	

	public Bodega(int idbodega, String nombre, String direccion) {
		super();
		this.idbodega = idbodega;
		this.nombre = nombre;
		this.direccion = direccion;
		
	}

	public Bodega() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdbodega() {
		return idbodega;
	}

	public void setIdbodega(int idbodega) {
		this.idbodega = idbodega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
	
	
}
