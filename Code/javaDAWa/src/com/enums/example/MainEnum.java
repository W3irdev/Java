package com.enums.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import com.enums.example.model.Genero;
import com.enums.example.model.Persona;

public class MainEnum {
	
	
	public static void main(String[] args) {
		Genero generoIntroducido = null;
		Scanner sc = new Scanner(System.in);
		LocalDate fechaNacimiento = null;
		
		/*do {
			try {
				System.out.println("Introduzca genero: ");
				String generoComoString= sc.nextLine();
				generoIntroducido = Genero.valueOf(generoComoString.toUpperCase());
				
				
				
			} catch (Exception e) {
				System.out.println("Introduzca HOMBRE/MUJER");
			}
			
		}while(generoIntroducido==null);
		int dia;
		int mes;
		int year;

			
			
		System.out.println("introduzca dia");
		dia = Integer.valueOf(sc.nextLine());
		System.out.println("introduzca mes");
		mes = Integer.valueOf(sc.nextLine());
		System.out.println("introduzca año");
		year = Integer.valueOf(sc.nextLine());
		fechaNacimiento = LocalDate.of(year, mes, dia);

*/
		
		Persona pepe = new Persona("Pepe", "Revilla", Genero.HOMBRE, fechaNacimiento);
		
		System.out.println(pepe);
		
		Persona juana = new Persona("Juana", "Revilla", Genero.MUJER, fechaNacimiento);
		Persona ana = new Persona("Ana", "Revilla", Genero.MUJER, fechaNacimiento);
		Persona otro = new Persona("Otro", "Revilla", Genero.HOMBRE, fechaNacimiento);
		Persona helicopter = new Persona("heli", "Revilla", Genero.HELICOPTER, fechaNacimiento);
		Persona otrohel = new Persona("Hela", "Revilla", Genero.HELICOPTER, fechaNacimiento);
		Persona casa = new Persona("casa", "Revilla", Genero.HOMBRE, fechaNacimiento);
		
		Persona[] personas = new Persona[7];
		personas[0]=pepe;
		personas[1]=juana;
		personas[2]=ana;
		personas[3]=otro;
		personas[4]=helicopter;
		personas[5]=otrohel;
		personas[6]=casa;

		
		for (Persona p:personas) {
			if (p!=null) {
				System.out.println(p);
				
			}
		}
		
		Arrays.sort(personas);
		System.out.println("_____________________");
		for (Persona p:personas) {
			if(p!=null) {
				System.out.println(p);
				
			}
		}
		
	}

}
