package com.edu.model;

public class Profesor extends Persona {

	public Profesor(String nombre, int edad, String dni, double altura, double peso, String genero) {
		super(nombre, edad, dni, altura, peso, genero);
		// TODO Auto-generated constructor stub
	}

	private String departamento = "DAW";

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
