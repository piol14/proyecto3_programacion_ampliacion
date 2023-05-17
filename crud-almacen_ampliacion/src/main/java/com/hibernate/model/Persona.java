package com.hibernate.model;

public class Persona {
	
	private String nombre;
	private String correoElectronico;
	private String telefono;
	private String Localizacion;
	private String fechaNacimiento;
	private String fechaIncorporacion;
	private String contraseña;
	
	public Persona () {
		
	}
	
	public Persona(String nombre, String correoElectronico, String telefono, String localizacion,
			String fechaNacimiento, String fechaIncorporacion, String contraseña) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.Localizacion = localizacion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIncorporacion = fechaIncorporacion;
		this.contraseña = contraseña;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLocalizacion() {
		return Localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.Localizacion = localizacion;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setFechaIncorporacion(String fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	
	

}
