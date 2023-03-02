package com.edu.tienda.model;

import java.util.Objects;

public class Producto {

	
	private final double IVA=1.20;
	private String descripcion;
	private double precio;
	
	public Producto() {
		super();
		this.descripcion="Añadir descripcion";
		this.precio=0;
	}
	
	public Producto(String descripcion, double precio) {
		this();
		setDescripcion(descripcion);
		setPrecio(precio);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, precio);
	}


	public double precioConIVA() {
		return getPrecio()*getIVA();
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		if (descripcion!=null){
			this.descripcion = descripcion;
			
		}
		
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		if (precio>0) {
			this.precio = precio;
			
		}
	}
	public double getIVA() {
		return IVA;
	}

	@Override
	public String toString() {
		return "Producto descripcion: " + descripcion + ", precio: " + precio + "€, precio con iva " + precioConIVA()+"€.";
	}
	
	
	
	
	
}
