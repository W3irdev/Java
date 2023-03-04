package com.arrays;

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
	
	/*3. Realizar un programa que solicite por teclado números entre 1 y 1000
hasta que el usuario informe de que ya no desea introducir más
números. Después debe mostrar:
• La media de los números leídos.
• Cuántos números terminan en cada uno de los dígitos (0 .. 9).
• El dígito en el que más números terminan.
• En qué dígitos no ha terminado ningún número.
Pista: crear un vector de contadores de 10 elementos*/
	
	public static double mediaLista(double[] listaNumeros ) {
		double suma=0;
		
		for (int i=0; i<listaNumeros.length;i++) {
			
			suma+=listaNumeros[i];
		}
		
		return suma/listaNumeros.length;
	}
	
	public static int terminaCon(int[] numeros, char digitoFinal) {
		int contador=0;
		
		for (int i=0; i<numeros.length;i++) {
			
			if(String.valueOf(numeros[i]).equals(String.valueOf(digitoFinal))||String.valueOf(numeros[i]).endsWith(String.valueOf(digitoFinal))) {
				contador++;
			}
		}
		
		
		return contador;
	}


	
	
	public static void main(String[] args) {
		int[] numeros= {5,10,2,30,4,15,6,88,3,9};
		double[] listaNumeros = {1,2,3,4,5,6,7,8,9,10};
		
		/*for (int ni:ordenInverso(numeros)) {
			System.out.println(ni);
		}*/
		//desplazarVector(numeros);
		
		//System.out.println(mediaLista(listaNumeros));
		
		//System.out.println(terminaCon(numeros, '5'));
		

	}

}
