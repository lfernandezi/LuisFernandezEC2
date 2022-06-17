package com.idat.Evaluacion2SW.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcliente;
	
	private String nombre;
	
	private String direccion;
	
	private String dni;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name= "cliente_producto",
	joinColumns =
	@JoinColumn(name="idproducto", 
				nullable =false,
				unique = true,
				foreignKey =@ForeignKey(foreignKeyDefinition = "foreign key (idproducto) references productos (idproducto)")),
	inverseJoinColumns =
	@JoinColumn(name="idcliente",
				nullable =false,
				unique = true,
				foreignKey =@ForeignKey(foreignKeyDefinition = "foreign key (idcliente) references cliente (idcliente)")))
	private List<Productos> producto = new ArrayList<Productos>();

	public Cliente(int idcliente, String nombre, String direccion, String dni) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
