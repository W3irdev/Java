package com.edu.Arrays;

import java.util.Arrays;

public class BoletinArrays {

	/*1. Realizar un programa que solicite diez números enteros y cuando se
termine de introducir el último los muestre en el orden inverso al que se
introdujeron.
*/
	
	public static int[] ordenInverso(int[] numeros) {
	
		int[] numerosInverso = new int[numeros.length];
		
		for(int i=numeros.length-1;i>=0;i--) {
			numerosInverso[i]=numeros[i];
		}
		
		
		
		return numerosInverso;
	}
	
	/*2. Realiza un programa que cargue un vector con de 10 números enteros.
El programa debe imprimir los elementos del vector y después
desplazarlos una posición, de tal forma que el último pase a la primera
posición, el primero a la segunda, el segundo a la tercera, y así
sucesivamente.
Introduce el número en la posición (1/10): 5
Introduce el número en la posición (2/10): 10
...
Introduce el número en la posición (10/10): 9
Vector original: 5 10 2 30 4 15 6 88 3 9
Vector después de desplazar: 9 5 10 2 30 4 15 6 88 3
NOTA: Sólo debe usarse un vector, no crear vectores auxiliares.*/
	
	
	public static void desplazarVector(int[] numeros) {
		System.out.println("Numeros antes de desplazar");
		for(int num:numeros) {
			System.out.print(num+" ");
		}
		
	    int temp = numeros[numeros.length - 1];
	    for (int i = numeros.length - 1; i > 0; i--) {
	        numeros[i] = numeros[i - 1];
	    }
	    numeros[0] = temp;

	    System.out.println("\nNumeros despues de desplazar:");
	    for (int i = 0; i < numeros.length; i++) {
	        System.out.print(numeros[i] + " ");
	    }
	}
	
	public static void main(String[] args) {
		int[] numeros= {5,10,2,30,4,15,6,88,3,9};
		
		
		/*for (int ni:ordenInverso(numeros)) {
			System.out.println(ni);
		}*/
		desplazarVector(numeros);
		

	}

}
