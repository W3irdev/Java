package com.pooavanzado.barajaNueva.model;

import java.util.Objects;

public class Carta implements Comparable<Carta>{
	
	private int number;
	private Palo palo;
	private final static Exception MSG = new Exception("Yeeepaaaaa");
	
	public Carta(int number, Palo palo) throws Exception {
		super();
		
		
		if(number>12||number<1) {
			throw MSG;
		}
		this.number = number;
		this.palo = palo;
		
	}

	public double getValor() {
		double valor=this.number;
		if(this.number==10||this.number==11||this.number==12) {
			valor=0.5;
		}
		return valor;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public Palo getPalo() {
		return this.palo;
	}
	
	public String toString() {
		return String.format("%s de %s", this.number, this.palo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, palo);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual=false;

		Carta other = (Carta) obj;
		
		esIgual=(obj!=null&&this == obj&&(obj instanceof Carta))||(other!=null&&this.number == other.number && Objects.equals(palo, other.palo));
		
		return esIgual;
	}

	@Override
	public int compareTo(Carta o) {
		
		return this.number-o.number;
	}
	
	
	
}
