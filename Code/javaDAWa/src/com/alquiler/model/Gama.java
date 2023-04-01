package com.alquiler.model;

public enum Gama {

	ALTA(30),
	MEDIA(40),
	BAJA(50);

	private double valor;
	Gama(int valor) {
		this.valor=valor;
	}
	public double getValor() {
		return valor;
	}

	

}
