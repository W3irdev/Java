package com.alquiler.model;

public enum Combustible {

	GASOLINA(3.5),
	DIESEL(2);
	
	private double incremento;
	Combustible(double incremento) {
		this.incremento=incremento;
	}
	public double getIncremento() {
		return incremento;
	}

	
	

	
	
}
