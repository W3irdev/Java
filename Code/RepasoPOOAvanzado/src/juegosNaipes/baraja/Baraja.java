package juegosNaipes.baraja;

import java.util.Arrays;
import java.util.Random;

import juegosNaipes.exceptions.CartaValueException;

public class Baraja {

	protected int numCartas;
	protected int siguiente;
	private static final int DECK_SIZE=40;
	Carta[] baraja = new Carta[DECK_SIZE];
	
	
	
	public Baraja() throws CartaValueException {
		super();
		int contador =0;
		for(Palo p:Palo.values()) {
			for(int i=1; i<13;i++) {
				
				if(i<=7||i>=10) {
					baraja[contador++]=new Carta(i, p.toString()); 
				}
			}
			
		}

	}


	public void barajar() {
		int aleatorio;
		Carta temp;
		for(int i=0;i<baraja.length;i++) {
			aleatorio = new Random().nextInt(DECK_SIZE);
			temp=baraja[i];
			baraja[i]=baraja[aleatorio];
			baraja[aleatorio]=temp;
		}
	}
	
	public Carta getSiguiente() {
		return baraja[siguiente++];
	}
	
	private Palo generaPalo() {
		return Palo.values()[new Random().nextInt(3)];
	}

	private int generaNumero() {
		return new Random().nextInt(1,12);
	}
	
	@Override
	public String toString() {
		return String.format("%s", Arrays.toString(baraja));
	}
	
	
	
	
	
	
	
}
