package com.edu.mates;

import java.util.Scanner;

import com.edu.mates.lines.Linea;
import com.edu.mates.lines.Punto;

public class MainLineas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double x1=0;
		double y1=0;
		double x2=0;
		double y2=0;
		Linea linea1;
		boolean continua;
		
		
		do {
			try {
				System.out.println("Vamos a crear una linea, para ello introduzca");
				System.out.println("Punto 1 X: ");
				x1=Double.valueOf(sc.nextLine());
				System.out.println("Punto 1 Y: ");
				y1=Double.valueOf(sc.nextLine());
				System.out.println("Punto 2 X: ");
				x2=Double.valueOf(sc.nextLine());
				System.out.println("Punto 2 Y: ");
				y2=Double.valueOf(sc.nextLine());
				continua = true;
			} catch (Exception e) {
				System.err.println("Debe introducir valores numericos");
				continua = false;
			}
			
			
		}while(!continua);

		Punto puntoA = new Punto(x1,y1);
		Punto puntoB = new Punto(x2,y2);
		linea1 = new Linea(puntoA, puntoB);
		
		String menu;
		String movimiento;
		double desplazamiento=-1;
		do {
			System.out.println("""
					1. Mover línea
					2. Mostrar línea
					3. Salir
					""");
			menu=sc.nextLine();
			
			switch (menu) {
			case "1" ->{
				System.out.println("Hacia donde desea mover A-arriba, B-ABajo, I-Izquierda, D-Derecha");
				do {
					movimiento = sc.nextLine().toUpperCase();
					
				}while("ABID".indexOf(movimiento)==-1||movimiento.equals("")||movimiento==null);
				System.out.println("Indique numero de desplazamiento mayor a 0");
				do {
					try {
						desplazamiento = Double.valueOf(sc.nextLine());	
					}catch (Exception e) {
						System.err.println("Debe introducir valores numericos");
						desplazamiento=-1;
					}
				}while(desplazamiento<0);
				if (movimiento.equals("A")) {
					linea1.moverArriba(desplazamiento);
				}else if (movimiento.equals("B")) {
					linea1.moverAbajo(desplazamiento);
				}else if (movimiento.equals("I")) {
					linea1.moverIzquierda(desplazamiento);
				}else {
					linea1.moverDerecha(desplazamiento);
				}
			}case "2" -> System.out.println(linea1);
		
			}
			
		}while (!menu.equals("3"));

	

	}

}
