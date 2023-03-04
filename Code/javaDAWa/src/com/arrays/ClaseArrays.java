package com.arrays;

public class ClaseArrays {

	public static void main(String[] args) {
		int[] numeros = new int[7];
		String nombres [] = {"Ana", "Moises", "Jose", "Dario"};
		
		for (int i=0; i<nombres.length; i++) {
			System.out.println(nombres[i]);
		}
		
		for (String n:nombres) {
			System.out.println(n);
		}
		
	}
	
	
}
