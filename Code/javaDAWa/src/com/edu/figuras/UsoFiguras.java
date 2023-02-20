package com.edu.figuras;

import java.util.Scanner;

public class UsoFiguras {

	public static void main(String[] args) {
		Rectangulo rec1 = new Rectangulo();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca ancho de la figura");
		rec1.setAncho(Double.valueOf(sc.nextLine()));
		System.out.println("Introduzca longitud de la figura");
		rec1.setLongitud(Double.valueOf(sc.nextLine()));
		
		System.out.println("El area de la figura es "+rec1.area()+" y su perimetro es "+ rec1.perimetro());
	}

}
