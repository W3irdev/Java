package com.colecciones.boletin1.ejercicio3.model;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private String dni;
	
	
	
	public Alumno(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	
	
	@Override
	public String toString() {
		return String.format("%n%s %s", nombre, dni);
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		boolean igual = this == obj;
		
		if (obj!=null && !igual && (obj instanceof Alumno alu)) {
			
			igual = Objects.equals(dni, alu.dni);
		}
		
		return igual;
	}
	
	
	

}
