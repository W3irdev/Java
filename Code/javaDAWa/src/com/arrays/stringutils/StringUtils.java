package com.arrays.stringutils;

public class StringUtils {

	/*6. Realizar un programa que solicite una frase e informe de cuantas veces
	aparecen cada una de las letras del abecedario en la frase (sólo se
	mostrarán las letras que aparezcan al menos una vez).
	Pista: Crear un array de contadores (entero) con tantos elementos como
	letras del abecedario y un String con las letras del abecedario.*/
		
	private final String ABECEDARIO="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
	private String frase="";
	
	
	
	
	public StringUtils(String frase) {
		super();
		this.frase = frase;
	}




	public String contarLetras() {
		StringBuilder aparece = new StringBuilder();
		int[] contadores = new int[ABECEDARIO.length()];
		for(int i=0; i<this.frase.length();i++) {
			contadores[ABECEDARIO.indexOf(frase.toUpperCase().charAt(i))]+=1;
			
		}
		for(int i=0;i<contadores.length-1;i++) {
			if(contadores[i]>0) {
				aparece.append("La letra "+ABECEDARIO.charAt(i)+ " aparece "+ contadores[i]+ " veces.\n");
			}
		}
		
		return aparece.toString();
	}
	
}
