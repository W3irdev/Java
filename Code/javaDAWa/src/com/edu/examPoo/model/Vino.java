package com.edu.examPoo.model;

import java.util.Objects;

public class Vino {

	private String nombre;
	private double graduacion;
	private static final Exception valueError = new Exception("La graduacion debe ser mayor 0");
	
	
	public Vino(String descripcion) {
		super();
		this.nombre = descripcion;
	}
	
	public Vino(String descripcion, double graduacion) throws Exception {
		super();
		this.nombre = descripcion;
		
		if(graduacion>0) {
			this.graduacion=graduacion;
		}else {
			throw valueError;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getGraduacion() {
		return graduacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = this == obj;
	
		if (obj==null||!(obj instanceof Vino)) {
			iguales = false;
		}
		Vino other = (Vino) obj;
		iguales = Objects.equals(nombre, other.nombre);
		
		return iguales;
		
		
	}

	@Override
	public String toString() {
		return String.format("Vino %s, con una graduacion de %s", nombre, graduacion);
	}
	
	
	
	
}
