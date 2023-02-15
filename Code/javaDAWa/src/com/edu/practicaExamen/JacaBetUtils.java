package com.edu.practicaExamen;

import java.util.Random;
import java.util.Scanner;

public class JacaBetUtils {
	
	public static int dameNumero() {
		
		Random numero = new Random();
		return Integer.valueOf( numero.nextInt(11));
	}

	public static void automatizarApuestas() {
		double saldo=0;
		double addSaldo=0;
		String menu="2";
		Scanner sc = new Scanner(System.in);
		int numeroApuesta;
		int aleatorio;
		double apuesta;
		
		while (!menu.equals("4")) {
			
			switch(menu) {
			case "1" -> {
				System.out.println("¿A que numero apuesta? ");
				
				do {
					
					numeroApuesta=Integer.valueOf(sc.nextLine());
				}while (numeroApuesta<2||numeroApuesta>12);
				
				System.out.println("¿Cuanto desea apostar? La cantidad a apostar no puede dejar saldo en negativo");
				
				do {
					apuesta=Double.valueOf(sc.nextLine());
					
				}while (apuesta<1||apuesta>saldo);
				
				
				aleatorio=dameNumero();
				System.out.println("La suma de los dados son "+aleatorio+ " Usted aposto a que salia "+numeroApuesta);
				
				
				if (aleatorio==numeroApuesta) {
					saldo+=(apuesta*2);
					System.out.println("Ha ganado "+ (apuesta*2));
				}else if (numeroApuesta<aleatorio) {
					saldo-=apuesta;
					System.out.println("Ha perdido "+apuesta);
				}else {
					saldo+=apuesta/2;
					System.out.println("Ha sacado mayor numero que la banca, ha ganado "+(apuesta/2));
				}
				
				
			}
			case "2" -> {
				System.out.println("Tienes "+ saldo+"€, ¿cuanto desea añadir?");
				do {
					addSaldo=Double.valueOf(sc.nextLine());
				}while (addSaldo<1);
				saldo+=addSaldo;
				System.out.println("\nSu nuevo saldo es "+saldo+"€.");
			}
			case "3" ->{
				System.out.println("\nSu saldo es "+ saldo + "€.\n");
			}
			}
			
			
			System.out.println("1. Apostar\n2.Añadir mas saldo\n"
					+ "3.Mostar saldo\n4.Retirarse\n\nIntroduzca opcion: \n");
			menu=sc.nextLine();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		automatizarApuestas();
		//System.out.println(dameNumero());
	
	}

}
