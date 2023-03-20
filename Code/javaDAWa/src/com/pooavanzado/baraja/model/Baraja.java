package com.pooavanzado.baraja.model;

import java.util.Random;

public class Baraja {

	protected int numCartas;
	protected int siguiente;
	private static Carta[] cartas;
	private Random aleatorio = new Random();
	
	public Baraja() {
		this.siguiente=-1;
		this.numCartas=40;
		cartas = new Carta[numCartas];
	}
	
	public void barajar() {
		this.siguiente=-1;
		for(int i=0; i< this.numCartas;i++) {
			
			cartas[i] = new Carta(generaNumero(), generaPalo());
		}
	}
	
	public Carta getSiguiente() {
		this.siguiente++;
		return cartas[this.siguiente];
	}
	
	private String generaPalo() {
		final String[] PALOS = {"Oros","Bastos","Espadas","Copas"};
		
		
		return PALOS[aleatorio.nextInt(3)];
		
	}
	
	private int generaNumero() {
		return aleatorio.nextInt(1,13);
	}

	@Override
	public String toString() {
		return String.format("La baraja española, contiene %s cartas", numCartas);
	}
	
	
	
	
	
	
}
