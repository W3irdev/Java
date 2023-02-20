package com.edu.mates;

import java.util.Scanner;

import com.edu.mates.complex.Complejo;

public class MainMates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Complejo com1;
		Complejo com2;
		
		
		String opcion;
		String menu = """
					1. Sumar complejos.
					2. Restar complejos.
					3. Salir
					
				""";
		do {
			System.out.println(menu);
			opcion = sc.nextLine();
			double parteReal;
			double parteImaginaria;
			
			switch (opcion){
			case "1" -> {
				System.out.println("Introduzca numero completo 1 - parte real");
				parteReal = Double.valueOf(sc.nextLine());
				System.out.println("Introduzca numero completo 1 - parte imaginaria");
				parteImaginaria = Double.valueOf(sc.nextLine());
				
				com1 = new Complejo(parteReal, parteImaginaria);
				
				System.out.println("Introduzca numero completo 2 - parte real");
				parteReal = Double.valueOf(sc.nextLine());
				System.out.println("Introduzca numero completo 2 - parte imaginaria");
				parteImaginaria = Double.valueOf(sc.nextLine());
				
				com2 = new Complejo(parteReal, parteImaginaria);
				
				System.out.println("El resultado de la suma es: " + com1.suma(com2));
				
			}
			case "2" ->{
				System.out.println("Introduzca numero completo 1 - parte real");
				parteReal = Double.valueOf(sc.nextLine());
				System.out.println("Introduzca numero completo 1 - parte imaginaria");
				parteImaginaria = Double.valueOf(sc.nextLine());
				
				com1 = new Complejo(parteReal, parteImaginaria);
				
				System.out.println("Introduzca numero completo 2 - parte real");
				parteReal = Double.valueOf(sc.nextLine());
				System.out.println("Introduzca numero completo 2 - parte imaginaria");
				parteImaginaria = Double.valueOf(sc.nextLine());
				
				com2 = new Complejo(parteReal, parteImaginaria);
				
				System.out.println("El resultado de la resta es: " + com1.resta(com2));
			}
			
			}
			
		}while(!opcion.equals("3"));
		
	}

}
