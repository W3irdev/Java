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
		boolean esta = false;
		Carta nueva;
		int contador=0;
		for(int i=0; i< this.numCartas;i++) {
			
			contador = 0;
			do {
				esta=false;
				nueva = new Carta(generaNumero(), generaPalo());
				for(int j=0; j<cartas.length&&!esta;j++) {
					if(cartas[j]!=null&&nueva.equals(cartas[j])) {
						esta=true;
					}
				}
				contador++;
				
				if(contador>=5) {
					contador=0;
					esta=false;
					for(int c=1; c<13&&esta;c++) {
						esta=false;
						nueva = new Carta(c, nueva.getPalo());
						for(int j=0; j<cartas.length&&!esta;j++) {
							if(cartas[j]!=null&&nueva.equals(cartas[j])) {
								esta=true;
							}
						}
					}
				}
			} while (esta);
			
			
			cartas[i] = nueva;
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
