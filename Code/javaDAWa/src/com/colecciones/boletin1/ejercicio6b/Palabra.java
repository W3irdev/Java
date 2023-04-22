package com.colecciones.boletin1.ejercicio6b;

import java.util.Set;
import java.util.TreeSet;

public class Palabra {

	private String significante;
	private Set<String> significados;
	
	public Palabra(String significante, String descripcion) {
		significados=new TreeSet<>();
		this.significante=significante;
		significados.add(descripcion);
	}
	
	public void addSignificado(String descripcion) {
		significados.add(descripcion);
	}
	

	public String getSignificante() {
		return significante;
	}

	@Override
	public String toString() {
		return String.format("%s", significados.toString());
	}
	
	
	
}
