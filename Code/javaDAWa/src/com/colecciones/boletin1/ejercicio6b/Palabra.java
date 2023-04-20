package com.colecciones.boletin1.ejercicio6b;

import java.util.Set;
import java.util.TreeSet;

public class Palabra {

	private String significante;
	private Set<String> significado;
	
	public Palabra(String significante, String descripcion) {
		significado=new TreeSet<>();
		this.significante=significante;
		significado.add(descripcion);
	}
	
	public void addSignificado(String descripcion) {
		significado.add(descripcion);
	}
	

	public String getSignificante() {
		return significante;
	}

	@Override
	public String toString() {
		return String.format("%s", significado.toString());
	}
	
	
	
}
