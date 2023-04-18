package com.colecciones.boletin1.ejercicio6;

import java.util.Set;
import java.util.TreeSet;

public class Descripcion {

	private Set<String> significado;
	
	public Descripcion(String descripcion) {
		significado=new TreeSet<>();
		significado.add(descripcion);
	}
	
	public void addSignificado(String descripcion) {
		significado.add(descripcion);
	}

	@Override
	public String toString() {
		return String.format("%s", significado.toString());
	}
	
	
	
}
