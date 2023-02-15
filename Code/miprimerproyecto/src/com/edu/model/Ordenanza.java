package com.edu.model;

public class Ordenanza extends Persona {

	
	public Ordenanza(String nombre, int edad, String dni, double altura, double peso, String genero,
			String funcionesAdicionales) {
		super(nombre, edad, dni, altura, peso, genero);
		this.funcionesAdicionales = funcionesAdicionales;
	}

	private String funcionesAdicionales = new String();

	public String getFuncionesAdicionales() {
		return funcionesAdicionales;
	}

	public void setFuncionesAdicionales(String funcionesAdicionales) {
		this.funcionesAdicionales = funcionesAdicionales;
	}
}
