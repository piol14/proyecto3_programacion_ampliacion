package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidoVenta")

public class PedidoVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpedidoVenta")
	private int idpedidoVenta;

	@Column(name = "proveedor")
	private String proeedor;

	@ManyToOne
	@JoinColumn(name = "detalle_venta_idedetalle_venta")
	private DetalleVenta DetalleVenta;
	
	@ManyToOne
	@JoinColumn(name = "detalle_venta_producto_idproducto")
	private Producto producto;
	
	
	public PedidoVenta () {
		
	}


	public PedidoVenta( String proeedor, DetalleVenta detalleVenta,
			Producto producto) {
		super();
	
		this.proeedor = proeedor;
		DetalleVenta = detalleVenta;
		this.producto = producto;
	}


	public int getIdpedidoVenta() {
		return idpedidoVenta;
	}


	public void setIdpedidoVenta(int idpedidoVenta) {
		this.idpedidoVenta = idpedidoVenta;
	}


	public String getProeedor() {
		return proeedor;
	}


	public void setProeedor(String proeedor) {
		this.proeedor = proeedor;
	}


	public DetalleVenta getDetalleVenta() {
		return DetalleVenta;
	}


	public void setDetalleVenta(DetalleVenta detalleVenta) {
		DetalleVenta = detalleVenta;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


}
