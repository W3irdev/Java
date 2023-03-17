package com.pooavanzado.figuras.model;

public abstract class Figura {

	private int lados;
	
	
	public abstract double calcularArea();
	
	public abstract double calcularPerimetro();
	
	public String toString() {
		return String.format("Figura con tipo %s, área %s y perimetro %s"
				, getClass().getSimpleName(), calcularArea(), calcularPerimetro());
	}
	
}
