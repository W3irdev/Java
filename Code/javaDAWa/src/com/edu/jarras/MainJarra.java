package com.edu.jarras;

import java.util.Scanner;

import com.edu.jarras.model.Jarra;

public class MainJarra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jarra jarraA = new Jarra(20);
		Jarra jarraB = new Jarra(30);
		String opcion;
		String jarra;
		
		
		do {
		System.out.println("""
				1. Llenar jarra
				2. Vaciar jarra
				3. Volcar jarra A en B . 
				4. Volcar jarra B en A.
				5. Ver estado de las jarras
				6. Salir
				""");	
			
			opcion = sc.nextLine();
			
			switch (opcion) {
			case "1" -> {
				do {
					System.out.println("¿Que jarra desea llenar, A o B?:");
					jarra = sc.nextLine().toUpperCase();
				}while("AB".indexOf(jarra)==-1);
				if (jarra.equals("A")) {
					jarraA.llenarJarra();
				}else {
					jarraB.llenarJarra();
				}
			}
			case "2" ->{
				
				do {
					System.out.println("¿Que jarra desea vaciar, A o B?:");
					jarra = sc.nextLine().toUpperCase();
				}while("AB".indexOf(jarra)==-1);
				if (jarra.equals("A")) {
					jarraA.vaciarJarra();
				}else {
					jarraB.vaciarJarra();
				}
			}case "3" -> jarraA.volcarJarra(jarraB);
			case "4" -> jarraB.volcarJarra(jarraA);
			case "5" -> System.out.println(jarraA+"\n"+jarraB);
			
			
			
			}
		}while(!opcion.equals("6"));
		System.out.println("El total de agua que se ha gastado llenando jarras es de "+Jarra.getConsumido());
	}

}
