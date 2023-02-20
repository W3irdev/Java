package com.edu.aerolines;

import java.util.Scanner;

import com.edu.aerolines.models.Avion;

public class UsoAvion {

	static Avion a1 = new Avion();
	
	public static void main(String[] args) {

		
		String menu1;
		Scanner sc = new Scanner(System.in);
		
		String identificador="";
		int capacidad=0;
		String compania="";
		
		do {
			/*
			 * Primer menu para crear nuevas instancias de Avion*/
			System.out.println("""
				1. Crear avion solo con el identificador.
				2. Crear avion con el identificador y la compañia
				3. Salir""");
			menu1=sc.nextLine();
			switch (menu1) {
			
			case "1" -> {
				System.out.println("Introduzca identificador");
				identificador = sc.nextLine();
				System.out.println("Introduzca capacidad de nuevo avion");
				capacidad = Integer.parseInt( sc.nextLine());
			}
			
			case "2" -> {
				
				System.out.println("Introduzca identificador");
				identificador = sc.nextLine();
				System.out.println("Introduzca compañia a la que pertenece");
				compania = sc.nextLine();
				System.out.println("Introduzca capacidad de nuevo avion");
				capacidad = Integer.parseInt( sc.nextLine());
				
			}
			
			}
			
			
			
		}while (!menu1.equals("3"));
		Avion a1 = new Avion(identificador,compania,capacidad);
		
		System.out.println("_____________________________________");

		String menu2;
		
		do {
			System.out.println("""
				
				a) Asignar Vuelo
				
				b) Obtener el numero de vuelos
				
				c) Obtener el numero de kilometros
				
				d) Obtener la media de kilometros por vuelo
				
				e) Cambio de compañia
				
				f) Mostrar informacion del avion
				
				g) Salir""");
			
			menu2=sc.nextLine().toLowerCase();
			
			switch (menu2) {
			
			case "a" ->{
				System.out.println("¿Cuantos asientos estaran ocupados?");
				int asientos = Integer.parseInt(sc.nextLine());
				System.out.println("Distancia del viaje");
				Double distancia = Double.parseDouble(sc.nextLine());
				a1.asignarVuelo(asientos, distancia);
				}
				
			case "b" -> System.out.println("El avion ha realizado "+ a1.getNumVuelos()+ " vuelos.");
				
			case "c" -> System.out.println("El avion ha recorrido "+ a1.getKmVolados()+"Kms");
			case "d" -> System.out.println("La media recorrida del avion es "+ a1.getMediaKm()+"Kms");
			case "e" -> {
				System.out.println("Introduce nueva compañia del avion");
				compania = sc.nextLine();
				a1.setCompannia(compania);
			}
			case "f" -> System.out.println(a1.toString());
			
			}
			
		}while (!menu2.equals("g"));
			
		
		
		
		
	}

}
