package com.pooavanzado.barajaNueva;

import java.util.Scanner;

import com.pooavanzado.barajaNueva.model.Baraja;
import com.pooavanzado.barajaNueva.model.Carta;
import com.pooavanzado.barajaNueva.model.Palo;


public class MenuBaraja {

public static void main(String[] args) {
	
	String quiere="";
	Scanner sc = new Scanner(System.in);
	double jugador=0;
	double banca=0;
	Carta carta=null;

	try {
		Baraja espanoila;
		espanoila = new Baraja();
		espanoila.barajar();
		//JUGADA JUGADOR
		//ESTA VERSION NO TIENE PUNTUACION MINIMA DE MANO
		do {
			
			carta = espanoila.getSiguiente();
			System.out.println(carta);
			jugador+=carta.getValor();
			do {
				System.out.println("Jugador Quiere Carta S/N");
				quiere=sc.nextLine().toUpperCase();
			} while ("SN".indexOf(quiere)==-1);
			
		}while(quiere.equals("S")&&(jugador<=7.5));
		
		//JUGADA BANCA
		
		do {
			banca+=espanoila.getSiguiente().getValor();
			
		} while (banca<jugador);
		
		//QUIEN GANA
		
		if(banca==7.5||(banca<7.5&&banca>jugador)||jugador>7.5) {
			System.out.println("Gana banca con puntuacion de " + banca);
		}else {
			System.out.println("Gana Jugador");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
}
