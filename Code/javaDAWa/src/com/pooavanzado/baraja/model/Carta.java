package com.pooavanzado.baraja.model;

import java.util.Objects;

public class Carta {

	private int number;
	private String palo;
	
	
	public Carta(int number, String palo) {
		super();
		this.number = number;
		this.palo = palo;
	}
	
	public double getValor() {
		double valor;
		
		valor = this.number>9&&this.number<13?0.5:this.number;
		return valor;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getPalo() {
		return this.palo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, palo);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual=false;

		Carta other = (Carta) obj;
		
		esIgual=(obj!=null&&this == obj&&(obj instanceof Carta))||this.number == other.number && Objects.equals(palo, other.palo);
		
		return esIgual;
	}

	@Override
	public String toString() {
		return String.format("%s de %s", number, palo);
	}
	
	
	
}
