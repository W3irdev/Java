package com.edu;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("Hola World");
		
		boolean abierto = true;
		
		if (abierto) {
			System.out.println("Puede pasar");
			
		}else {
			System.out.println("¡NOOO PUEDESSS PASAAAAARRRR!");
		}
		
		int dia = 0;*/
		
		Scanner scanner = new Scanner(System.in);
		
		/*System.out.println("Introduce numero dia: ");
		dia = Integer.parseInt(scanner.nextLine());*/
		/*if (dia == 1) {
			System.out.println("Lunes");
		}else if (dia==2) {
			System.out.println("Martes");
		}else if (dia==3) {
			System.out.println("Miercoles");
		}else if (dia==4) {
			System.out.println("Jueves");
		}else if (dia==5) {
			System.out.println("Viernes");
		}else if (dia==6) {
			System.out.println("Sabado");
		}else if (dia==7){
			System.out.println("Domingo");
		}else {
			System.out.println("El dia introducido no es valido");
		}*/
		
		/*
		 * 	Diseña un programa que pregunte por la edad de una persona e imprima
		 * si es mayor de edad.	
		 */

		/*System.out.println("¿Que edad tienes?");
		int edad = Integer.parseInt(scanner.nextLine());
		String pertenece;
		if (edad>=18&&edad<65) {
			pertenece = "Es mayor edad";
		}else if (edad<18) {
			pertenece = "Es niño";
		}else {
			pertenece = "Es anciano";
		}
		System.out.println(pertenece);*/
		
		/*Realiza un programa (días del mes) que pregunte por un mes y año y
		  devuelva el número de días que tiene ese mes para el año especificado.*/
		
		
		int diasMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int diasTotales;
		System.out.println("Introduzca numero de mes");
		int mes = Integer.parseInt(scanner.nextLine());
		System.out.println("Introduzca año");
		int year = Integer.parseInt(scanner.nextLine());
		
		/*if ((year%4==0)&&((year%100!=0)||(year% 00== 0)&&(mes==2))) {
			diasTotales=29;
		}else {
			diasTotales=diasMes[mes];
		}
		System.out.println(diasTotales);*/
		
		//System.out.println("Introduce dia del mes");
		//int mes;
		//mes = scanner.nextLine();
		
		switch (mes) {
		case 1,3,5,7,8,10,12 -> {
			System.out.println(31);
			break;
		}case 2 -> {
			if (year%4==0 && (year%100!=0 || year%400==0)) {
				System.out.println(29);
			}else {
				System.out.println(28);
			}
			break;
		}case 4,6,9,11 -> {
			System.out.println(30);
			break;
			
		}
		default ->{
			System.out.println("El dia introducido no es valido");
		}
		
		
	}

}
}
