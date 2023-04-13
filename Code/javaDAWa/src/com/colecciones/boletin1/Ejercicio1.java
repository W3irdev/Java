package com.colecciones.boletin1;

import java.util.Arrays;

public class Ejercicio1 {

	/*public static <T>T[]reverse(T[] arrayOriginal) {
		Object[] nuevaArray = new Object[arrayOriginal.length];
		
		for(int i=arrayOriginal.length-1, contador=0; i>=0 
				&& contador<arrayOriginal.length;i--,contador++) {
			nuevaArray[contador]=arrayOriginal[i];
		}
		
		
		return (T[]) nuevaArray;
	}*/
	
	public static <T>T[]reverse(T[] arrayOriginal) {
		T[] nuevaArray=arrayOriginal.clone();
		
		for(int i=arrayOriginal.length-1, contador=0; i>=0;i--,contador++) {
			nuevaArray[contador]=arrayOriginal[i];
		}
		return nuevaArray;
	}
	
	public static void main(String[] args) {
		/*1*/
		
		Integer[] arrayNumeros = {1,2,3,4,5,6};
		
		System.out.println(Arrays.toString(reverse(arrayNumeros)));
		
		
	}

}
