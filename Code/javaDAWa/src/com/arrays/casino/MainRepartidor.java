package com.arrays.casino;

import java.util.Arrays;
import java.util.Scanner;

import com.arrays.casino.models.Repartidor;

public class MainRepartidor {
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		
		int repartir= -1;
		try {
			System.out.println("¿Cuantas cartas va a repartir?");
			repartir=Integer.valueOf(sc.nextLine());
			while(repartir<0) {
				System.out.println("Debe ser un numero mayor 0");
				repartir=Integer.valueOf(sc.nextLine());
			}
			
			System.out.println("Mano jugador 1: " + Arrays.toString(new Repartidor().repartir(repartir)));
			System.out.println("Mano jugador 2: " + Arrays.toString(new Repartidor().repartir(repartir)));
			
		} catch (Exception e) {
			menu();
		}
	}

	public static void main(String[] args) {
		
		menu();
	
		
	}
	
}
