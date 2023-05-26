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
 * Clase pedidoventa: clase para definir los atributos de pedidoventa (idPedidoVenta) el constructor y los getters y los setters 
 * 
 *
 */
@Entity
@Table(name = "pedidoVenta")

public class PedidoVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpedidoVenta")
	private int idpedidoVenta;

	
	
	public PedidoVenta () {
		
	}




	public int getIdpedidoVenta() {
		return idpedidoVenta;
	}


	public void setIdpedidoVenta(int idpedidoVenta) {
		this.idpedidoVenta = idpedidoVenta;
	}





}
