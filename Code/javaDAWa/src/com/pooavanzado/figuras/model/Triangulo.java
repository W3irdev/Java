package com.pooavanzado.figuras.model;

public class Triangulo extends Figura {

	
	private double altura;
	private double ladoA;
	private double ladoB;
	private double ladoC;
	
	
	


	public Triangulo(double ladoA, double ladoB, double ladoC) {
		super();
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	@Override
	public double calcularArea() {
		double s = (ladoA+ladoB+ladoC)/2;
		
		
		return Math.sqrt(((s-this.ladoA)*(s-this.ladoB)*(s-this.ladoC))*s);
	}

	@Override
	public double calcularPerimetro() {
		return ladoA+ladoB+ladoC;
	}

	
	
}
