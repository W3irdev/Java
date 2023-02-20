package com.edu.machine;

import java.util.Scanner;

public class Main {

	public static double validarDinero(double dinero) {
		Scanner sc1 = new Scanner(System.in);
		while(dinero<0) {
			dinero=Double.valueOf(sc1.nextLine());
		}
		
		return dinero;
	}
	
	public static void main(String[] args) {
		Cafetera bebida = new Cafetera();
		double dinero=0;
		Scanner sc = new Scanner(System.in);
		String opcion="0";
		String menu = """
				
				1. Servir café solo (1 euro)
				2. Servir leche (0,8 euros)
				3. Servir café con leche (1,5 euros)
				4. Consultar estado máquina. Aparecen los datos de los depósitos y del
				monedero
				5. Apagar máquina y salir
				
				""";
		System.out.println("Introduzca monedas");
		dinero=validarDinero(Double.valueOf(sc.nextLine()));
		
		do {
			System.out.println(menu);
			System.out.println("Introduzca opcion");
			opcion = sc.nextLine();
				
			
			
			switch (opcion) {
			
			case "1" -> bebida.servirBebida("SOLO", dinero);
			case "2" -> bebida.servirBebida("LECHE", dinero);
			case "3" -> bebida.servirBebida("CAFELATTE", dinero);
			case "4" -> bebida.getEstado();
			case "5" -> System.out.println("Gracias por su compra");
			default -> System.out.println("Selecciona una opcion valida\n");
			}
			
		}while (!opcion.equals("5"));
		sc.close();
	}

}
