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
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iddetalle_venta")
	private int idDealleVenta;

	@Column(name = "precio")
	private double precio;

	@Column(name = "cantidad")
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "producto_idproducto")
	private Producto producto;

	public DetalleVenta() {

	}

	public DetalleVenta(double precio, int cantidad, Producto producto) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public int getIdDealleVenta() {
		return idDealleVenta;
	}

	public void setIdDealleVenta(int idDealleVenta) {
		this.idDealleVenta = idDealleVenta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
