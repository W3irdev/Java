package com.edu.model;

public class Directivo extends Profesor {

	public Directivo(String nombre, int edad, String dni, double altura, double peso, String genero) {
		super(nombre, edad, dni, altura, peso, genero);
		// TODO Auto-generated constructor stub
	}

	private String categoria = new String();

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
