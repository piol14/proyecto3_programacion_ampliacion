
package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name = "usuario")
	public class Usuario {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idUsuario")
	    private  int id;

	    @Column(name = "nombre")
	    private String nombre;

	    @Column(name = "correo")
	    private String correoElectronico;

	    @Column(name = "telefono")
	    private String telefono;

	    @Column(name = "localizacion")
	    private String localizacion;

	    @Column(name = "fecha_nacimiento")
	    private String fechaNacimiento;

	    @Column(name = "fecha_inicio")
	    private String fechaInicio;

	  
	    public Usuario() {
	    }

	    
	    public Usuario(String nombre, String correoElectronico, String telefono, String localizacion, String fechaNacimiento, String fechaInicio) {
	        this.nombre = nombre;
	        this.correoElectronico = correoElectronico;
	        this.telefono = telefono;
	        this.localizacion = localizacion;
	        this.fechaNacimiento = fechaNacimiento;
	        this.fechaInicio = fechaInicio;
	    }

	    // Getters y Setters

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
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
	        return localizacion;
	    }

	    public void setLocalizacion(String localizacion) {
	        this.localizacion = localizacion;
	    }

	    public String getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(String fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public String getFechaInicio() {
	        return fechaInicio;
	    }

	    public void setFechaInicio(String fechaInicio) {
	        this.fechaInicio = fechaInicio;
	    }
	}

