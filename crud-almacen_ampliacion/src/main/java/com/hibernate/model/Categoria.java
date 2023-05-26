package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * Clase categoria : sirve para los definir los atributos (id, nombre), el contructor y los getter y los setters
 * de cada atributo
 * 
 *
 */
@Entity
@Table(name = "categoria")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idCategoria;

	@Column(name = "nombre")
	private String nombre;

	
	
	public Categoria() {

	}

	public Categoria(String nombre, Oferta oferta) {
		super();
		this.nombre = nombre;
		
	}


	

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}