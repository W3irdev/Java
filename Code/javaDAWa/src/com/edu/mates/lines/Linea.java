package com.edu.mates.lines;

import java.util.Objects;

public class Linea {

	private Punto puntoA;
	private Punto puntoB;
	
	public Linea() {
		super();
		this.puntoA = new Punto(0,0);
		this.puntoB = new Punto(0,0);
		
		
	}

	public Linea(Punto puntoA, Punto puntoB) {
		this();
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}

	public Linea moverDerecha(double posicion) {
		
		if (posicion>0) {
			this.puntoA.setX(this.puntoA.getX()+posicion);
			this.puntoB.setX(this.puntoB.getX()+posicion);
		}
		
		return new Linea(puntoA, puntoB);
	}
	
	public Linea moverIzquierda(double posicion) {
		
		if (posicion>0) {
			this.puntoA.setX(this.puntoA.getX()-posicion);
			this.puntoB.setX(this.puntoB.getX()-posicion);

		}
		
		return new Linea(puntoA, puntoB);
	}
	
	public Linea moverArriba(double posicion) {
		
		if (posicion>0) {
			this.puntoA.setY(this.puntoA.getY()+posicion);
			this.puntoB.setY(this.puntoB.getY()+posicion);

		}
		
		return new Linea(puntoA, puntoB);
	}
	
	public Linea moverAbajo(double posicion) {
		
		if (posicion>0) {
			this.puntoA.setY(this.puntoA.getY()-posicion);
			this.puntoB.setY(this.puntoB.getY()-posicion);

		}
		
		return new Linea(puntoA, puntoB);
	}
	
	public Punto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}

	@Override
	public int hashCode() {
		return Objects.hash(puntoA, puntoB);
	}

	@Override
	public boolean equals(Object obj) {
			Linea linea = (Linea) obj;
			boolean esIgual = false;
			
				if (obj!=null&&linea.getPuntoA().getX()==this.puntoA.getX()&&linea.getPuntoA().getY()==this.puntoA.getY()) {
					esIgual=true;
				}

		return esIgual;
	}

	@Override
	public String toString() {
		return "(" + puntoA + "),(" + puntoB+")";
	}
	
	
	
	
	
}
