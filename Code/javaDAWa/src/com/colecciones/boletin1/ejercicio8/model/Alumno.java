package com.colecciones.boletin1.ejercicio8.model;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private String dni;
	private int edad;
	private char sexo;
	private String ciudad;
	
	
	
	public Alumno(String nombre, String dni, String ciudad, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad=edad;
		this.sexo=sexo;
		this.ciudad=ciudad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public String toString() {
		return String.format("%n%s con DNI %s y %s años", nombre, dni, edad);
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
