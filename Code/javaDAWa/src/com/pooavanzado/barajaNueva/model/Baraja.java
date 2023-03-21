package com.pooavanzado.barajaNueva.model;

import java.util.concurrent.ThreadLocalRandom;

import com.pooavanzado.barajaNueva.model.Carta;

public class Baraja {
	
	protected int numCartas;
	protected int siguiente;
	private Carta[] baraja;
	private final static int MAX_BARAJA=40;

	
	public Baraja() {
		this.siguiente=0;
		this.numCartas=40;
		int posicion=0;
		Carta[] baraja = new Carta[MAX_BARAJA];
		
		for(Palo p:Palo.values()) {
			for(int i=1;i<13;i++) {
				if(i!=8&&i!=9) {
					try {
						this.baraja[posicion++] = new Carta(i, p);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public Carta getSiguiente() {
		this.siguiente++;
		return baraja[siguiente];
	}
	
	public void barajar() {
		Carta temp;
		int aleatorio;
		for(int i=0; i<baraja.length;i++) {
			aleatorio = generarNumero();
			temp=baraja[i];
			baraja[i]=baraja[aleatorio];
			baraja[aleatorio]=temp;
		}
		
	}

	private int generarNumero() {
		return ThreadLocalRandom.current().nextInt(0, MAX_BARAJA);
	}
	
	
	private Palo generaPalo() {
		return Palo.values()[ThreadLocalRandom.current().nextInt(0, 3)];
	}
	
	
}
