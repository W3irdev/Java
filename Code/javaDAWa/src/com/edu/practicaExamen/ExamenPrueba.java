package com.edu.practicaExamen;

import java.util.Scanner;

public class ExamenPrueba {
	
	public static final double DO=523.25;
	public static final double RE=587.33;
	public static final double MI=659.26;
	public static final double FA=698.46;
	public static final double SOL=783.99;
	public static final double LA=880;
	public static final double SI=987.77;

	public static final double PRECIO_ENTRADA=8;
	public static final double PRECIO_PAREJA=11;
	public static final double PRECIO_DIA_ESPECTADOR=5;
	public static final String DIAS = "LMXJVSD";
	public static void buyTicket() {
		Scanner sc = new Scanner(System.in);
		int cantidad = 0;
		double precioActual=0;
		double total=0;
		String dia = "sabadin";
		char premium = 'o';
		int contador=0;
		
		do {
		if (contador==0) {
			System.out.println("Introduce numero de entradas a comprar: ");
			cantidad = Integer.parseInt(sc.nextLine());}
		
		contador++;
		
		while (dia==null||dia.equals("")||DIAS.indexOf(dia)==-1) {
			System.out.println("Introduce dia");
			dia = sc.nextLine().toUpperCase();
		}
		if (dia.equalsIgnoreCase("x")) {
			precioActual=PRECIO_DIA_ESPECTADOR;
			total=precioActual*cantidad;
		}else if (dia.equalsIgnoreCase("j")&&cantidad%2!=0) {
			total=PRECIO_PAREJA*(cantidad-1)+PRECIO_ENTRADA; 
			
		}else if (dia.equalsIgnoreCase("j")&&cantidad%2==0) {
			
			total=(PRECIO_ENTRADA-2.5)*cantidad;
			
		
		}else {
			total=PRECIO_ENTRADA*cantidad;
		}
		
		
		
		while (!(premium=='S'||premium=='N')){
			System.out.println("Tienes tarjeta premium? S/N");
			
			premium=sc.nextLine().toUpperCase().charAt(0);
			
		}
		
		if (premium=='S') {
			
			total= total-(total*0.10);
		}
		System.out.println(total);
		premium='o';
		dia="sabadin";
		System.out.println("Introduce numero de entradas a comprar: ");
		cantidad = Integer.parseInt(sc.nextLine());
	
		}while (cantidad > 0);
		sc.close();
	}
	
	public static double frecuenciaNota(String nota, boolean sostenido) {
		double frecuencia;
		
		
		switch (nota.toUpperCase()) {
		
		case "DO" -> frecuencia=DO;
		case "RE" -> frecuencia=RE;
		case "MI" -> frecuencia=MI;
		case "FA" -> frecuencia=FA;
		case "SOL" -> frecuencia=SOL;
		case "LA" -> frecuencia=LA;
		case "SI" -> frecuencia=SI;
		default -> frecuencia=-1;
		}
		frecuencia=sostenido?frecuencia*=1.03:frecuencia;
		
		return frecuencia;
		
	}
	
	public static double frecuenciaRecomendada(int actualYear, String birthdate) {
		int birthYear = Integer.valueOf(birthdate.substring(birthdate.length()-4));
		int actualAge = actualYear-birthYear;	
			
		return (220-actualAge)*0.85;
	}
	
	
	public static void main(String[] args) {
		buyTicket();
		//System.out.println(frecuenciaRecomendada(2023, "20/07/1992"));
		//System.out.println(frecuenciaNota("DO", true));

	}

}
