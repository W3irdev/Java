package com.edu.figuras;

public class Rectangulo {

	private double longitud;
	private double ancho;
	
	
	public Rectangulo() {
		super();
		this.longitud = 1;
		this.ancho = 1;

	}
	
	public Rectangulo(double longitud, double ancho) {
		super();
		this.longitud = longitud;
		this.ancho = ancho;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		
		if (longitud>0&&longitud<20) {
		this.longitud = longitud;
		}else {
			System.err.println("Introduzca un valor valido en la longitud");
			this.longitud = 0;
		}
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		if (ancho>0&&ancho<20) {
			this.ancho = ancho;
			
		}else {
			System.err.println("Introduzca un valor valido en el ancho");
			this.ancho = 0;
		}
	}
	
	public double perimetro() {
		
		return Math.pow(ancho, 2)+Math.pow(longitud, 2);
	}
	
	public double area() {
		return ancho*longitud;
	}
}
