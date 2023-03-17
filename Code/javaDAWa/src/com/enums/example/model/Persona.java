package com.enums.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona>{

	private Genero genero;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	
	
	public Persona(String nombre, String apellidos, Genero genero,LocalDate fechaNacimiento) {
		super();
		this.genero = genero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(genero);
	}





	@Override
	public int compareTo(Persona o) {
		
		
		return this.genero.compareTo(o.genero);
	}
	

	
	@Override
	public String toString() {
		return "Soy " + genero + " y me llamo " + nombre + " " + apellidos + " tengo "
				;
	}
	
	
	
}
