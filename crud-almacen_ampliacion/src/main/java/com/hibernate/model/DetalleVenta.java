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
 * Clase detalle_venta: clase para definir los atributos del detalle_venta (idetalle_venta,precio,cantidad, nombreproveedor y 2 foreign key con la tabla producto 
 * y la tabla pedidoventa ),
 * el constructor y los getters y los setters 
 * 
 *
 */
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
	//Relacion muchos a uno con la tabla producto
	@ManyToOne
	@JoinColumn(name = "producto_idproducto")
	private Producto producto;
	
	//Relacion muchos a uno con la tabla pedido venta 
	@ManyToOne
	@JoinColumn(name = "pedidoVenta_idpedidoVenta")
	private PedidoVenta PedidoVenta;
	

	@Column(name = "nombreProveedor")
	private String proveedor;

	


	public DetalleVenta() {

	}



	public DetalleVenta( PedidoVenta pedidoVenta, String proveedor, Producto producto, int cantidad,  double precio ) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.producto = producto;
		this.PedidoVenta = pedidoVenta;
		this.proveedor = proveedor;
	}



	public String getProveedor() {
		return proveedor;
	}



	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}



	public PedidoVenta getPedidoVenta() {
		return PedidoVenta;
	}



	public void setDetalleVenta(PedidoVenta pedidoVenta) {
		this.PedidoVenta = pedidoVenta;
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
