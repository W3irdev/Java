package com.arrays.casino.models;

import java.util.Random;

public class Repartidor {

	Random aleatorio = new Random();
	/*Se desea realizar un programa que simule el reparto de cartas en un
juego. El juego tiene 48 cartas, separadas en 4 palos (oros, copas,
espadas y bastos) y numeradas del 1 al 12. Se desea realizar un
programa que solicite cuantas cartas se van a repartir y cree un vector
de cartas para el jugador 1 y otro para el jugador 2. Se deben cargar
aleatoriamente las cartas de cada jugador. Las cartas no se repiten.
¿Cuántas cartas reparto?: 5
Cartas del jugador 1:
7 de oros, 8 de espadas, 5 de copas, 4 de copas, 3 de bastos
Cartas del jugador 2:
5 de espadas, 7 de copas, 9 de copas, 10 de bastos, 3 de oros
*/
	
	
	public String[] repartir(int numero) {
		String[] mano = new String[numero];
		String[] repetidos = new String[numero];
		int contador=0;
		String palo="";
		String carta="";
		boolean esta=true;
		while (contador<numero) {
			
			palo = String.valueOf(aleatorio.nextInt(3));
			carta = String.valueOf(aleatorio.nextInt(13));
						
			while(esta) {
				for(int i=0; i<repetidos.length;i++) {
					if(palo+carta != null&&!carta.equals("0")&&!(palo+carta).equals(repetidos[i])) {
						esta=false;
					}else {
						esta=true;
						palo = String.valueOf(aleatorio.nextInt(3));
						carta = String.valueOf(aleatorio.nextInt(13));		
					}
				}	
			}
			
			repetidos[contador]=palo+carta;
			
			esta=true;
			
			switch (palo) {
			case "0" -> palo="Oros";
			
			case "1" -> palo="Copas";
		
			case "2" -> palo="Bastos";
			
			case "3" -> palo="Espadas";	
						
			default ->
			throw new IllegalArgumentException("Unexpected value: " + palo);
			}
			
			mano[contador]=carta + " de " + palo;
			contador++;
		}
		
		
		return mano;
	}
	
	
}
