package com.arrays.refranero;

import java.util.Scanner;

import com.arrays.refranero.model.Refran;
import com.arrays.refranero.model.Refranes;

public class MainRefran {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu ="";
		Refranes refranero = new Refranes();
		Refran r1;
		
		do {
			System.out.println("""
					1. Guardar un refrán
					2. Buscar un refrán que contenga una palabra
					3. Listar refranes
					4. Salir.
					""");
			menu=sc.nextLine();
			
			switch (menu) {
			
			case "1" -> {
				System.out.println("Introduzca refran");
				r1=new Refran(sc.nextLine());
				refranero.addRefran(r1);
			}
			case "2" -> {
				System.out.println("Introduzca palabra a buscar en el refranero");
				String palabra = sc.nextLine();
				System.out.println(refranero.buscarRefran(palabra));
				
			}
			case "3" -> {
				System.out.println(refranero);
			}
			case "4" -> {
				System.out.println("Saliendo...");
				break;
			}
			
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + menu);
			}
			
		}while(!menu.equals("4"));
		
	}

}
