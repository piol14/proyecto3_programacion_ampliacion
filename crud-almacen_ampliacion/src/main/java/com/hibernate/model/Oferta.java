package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Clase oferta: clase para definir los atributos de la oferta (idoferta,nombre),
 *  el constructor y los getters y los setters 
 * 
 *
 */
@Entity
@Table(name = "oferta")

public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idoferta")
	private int idoferta;

	@Column(name = "oferta")
	private double oferta;
	

	public Oferta () {
		
	}
	
	public Oferta( double oferta) {
		super();
		this.oferta = oferta;
	}


	public int getIdOferta() {
		return idoferta;
	}


	public void setIdOferta(int idCategoria) {
		this.idoferta = idCategoria;
	}


	public double getOferta() {
		return oferta;
	}


	public void setOferta(double oferta) {
		this.oferta = oferta;
	}
	
	
	

}