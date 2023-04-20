package com.colecciones.mockExam.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Combinacion {
	
	protected static final int VALOR_MINIMO=1;
	protected static final int VALOR_MAXIMO_NUMEROS=50;
	protected static final int VALOR_MAXIMO_ESTRELLAS=12;
	protected static final int TOTAL_NUMEROS=5;
	protected static final int TOTAL_ESTRELLAS=2;
	private Set<Integer> numeros;
	private Set<Integer> estrellas;
	
	
	
	public Combinacion(int num1, int num2, int num3, int num4,
			int num5, int estrella1, int estrella2) {
		super();
		numeros=new HashSet<>();
		estrellas=new HashSet<>();
		Integer[] numeros = {num1, num2, num3, num4, num5};
		Integer[] estrellas = {estrella1, estrella2};
		arrayToSet(numeros);
		arrayToSet(estrellas);
		
	}
	
	


	public Combinacion(int[] numeros, int[] estrellas) {
		this(numeros[0],numeros[1],numeros[2],numeros[3],numeros[4],estrellas[0],estrellas[1]);
	}





	public void arrayToSet(Integer[] arrayNumeros) {
		if(arrayNumeros.length>2) {
			for(Integer n:arrayNumeros) {
				if(n!=null && n.intValue()>0) this.numeros.add(n);
			}
			
		}else if(arrayNumeros.length==2) {
			for(Integer e:arrayNumeros) {
				if(e!=null && e.intValue()>0) this.estrellas.add(e);
			
			}
		}
	}
	
	
	
	public Set<Integer> getNumeros(){
		return numeros;
	}


	public Set<Integer> getEstrellas() {
		return estrellas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}


	@Override
	public boolean equals(Object obj) {
		boolean iguales = this == obj;
		
		if (obj!=null && !iguales && (obj instanceof Combinacion comb)) {
			iguales = Objects.equals(estrellas, comb.estrellas) && Objects.equals(numeros, comb.numeros);
		}
	
		return iguales;
	}


	@Override
	public String toString() {
		return String.format("Combinacion %s, %s", numeros, estrellas);
	}
	
	
	
	
}
