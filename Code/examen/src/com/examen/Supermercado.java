package com.examen;

import java.util.Scanner;

public class Supermercado {

	
	
	public static void main(String[] args) {
		
		double puntos=0;
		String observaciones=" ";
		StringBuilder almacen = new StringBuilder();
		String seccion="s";
		StringBuilder secciones = new StringBuilder();
		StringBuilder puntuaciones = new StringBuilder();
		StringBuilder observacionesHogar = new StringBuilder(); //Guardamos por separado las observaciones
		StringBuilder observacionesElectronica = new StringBuilder(); //Guardamos por separado las observaciones
		StringBuilder observacionesAlimentacion = new StringBuilder(); //Guardamos por separado las observaciones
		int total=0;
		int contador=0;
		int contadorHogar=1;
		int contadorElectronica=1;
		int contadorAlimentacion=1;
		double puntuacionHogar=0;
		double puntuacionElectronica=0;
		double puntuacionAlimentacion=0;
		
		Scanner sc = new Scanner(System.in);
		
		while (!(seccion==null||seccion.equals(" ")||seccion.equals(""))) {
			while (!(seccion.equalsIgnoreCase("hogar")||seccion.equalsIgnoreCase("electronica")
					||seccion.equalsIgnoreCase("alimentacion"))) {
				
			System.out.println("¿Que seccion quiere valorar?");
			seccion=sc.nextLine().toLowerCase();
			
			
		}
			contadorHogar=seccion.equals("hogar")?contadorHogar++:contadorHogar+0;
			contadorElectronica=seccion.equals("electronica")?contadorElectronica++:contadorElectronica+0;
			contadorAlimentacion=seccion.equals("alimentacion")?contadorAlimentacion++:contadorAlimentacion+0;
		
			do {
				System.out.println("¿Como calificaria la antencion recibida?");
				puntos=Integer.valueOf(sc.nextLine());
				
				
			}while (puntos<1||puntos>5);
			total+=puntos;
			puntuacionHogar=seccion.equalsIgnoreCase("hogar")?puntuacionHogar+=puntos:puntuacionHogar;
			puntuacionElectronica=seccion.equalsIgnoreCase("electronica")?puntuacionElectronica+=puntos:puntuacionElectronica;
			puntuacionAlimentacion=seccion.equalsIgnoreCase("alimentacion")?puntuacionAlimentacion+=puntos:puntuacionAlimentacion;
			
			System.out.println("Añada alguna observacion");
			
			switch (seccion) {
			case "hogar" -> observacionesHogar.append(sc.nextLine()+" - ");
			case "electronica" -> observacionesElectronica.append(sc.nextLine()+" - ");
			case "alimentacion" -> observacionesAlimentacion.append(sc.nextLine()+" - ");
			
			
			}
			
			System.out.println("¿Que seccion quiere valorar?");
			seccion=sc.nextLine();
			contador++;
	}
		System.out.println("Gracias por su aportacion\n");
		System.out.println(secciones.toString()+"\n"+puntuaciones.toString()+"\n"+almacen.toString());
		System.out.println("La puntuacion media del supermercado es "+ total/contador
				+" y han dado su opinion " + contador + " clientes");
		System.out.println("La puntuacion media de la seccion Hogar es " + (puntuacionHogar/contadorHogar)+ " y las observaciones recogidas:" + observacionesHogar.toString());
		System.out.println("La puntuacion media de la seccion Electronica es " + (puntuacionElectronica/contadorElectronica)+ " y las observaciones recogidas:" + observacionesElectronica.toString());
		System.out.println("La puntuacion media de la seccion Alimentacion es " + (puntuacionAlimentacion/contadorAlimentacion)+ " y las observaciones recogidas:" + observacionesAlimentacion.toString());
	}
}
