package com.alquiler.model;

public class Coche extends Vehiculo {

	private Combustible combustible;
	
	public Coche(String matricula, Gama gama, Combustible combustible) throws Exception {
		super(matricula, gama);
		this.combustible=combustible;
		super.precioBase+=combustible.getIncremento();
		
	}

	public Combustible getCombustible() {
		return combustible;
	}

	@Override
	public String toString() {
		return String.format("%s \n"
				+ "Tipo de combustible: %s", super.toString(),combustible);
	}

	
	
	
}
