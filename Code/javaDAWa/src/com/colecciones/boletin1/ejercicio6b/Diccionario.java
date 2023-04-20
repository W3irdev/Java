package com.colecciones.boletin1.ejercicio6b;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Diccionario {

	private Set<Palabra> entradas;

	public Diccionario() {
		entradas=new HashSet<>();
	}
	
	public void addPalabra(String palabra, String desc) {
		boolean esta = false;
		Palabra pal=null;
		Iterator<Palabra> it = entradas.iterator();
		while(it.hasNext() && !esta) {
			pal=it.next();
			if(pal.getSignificante().equals(palabra)) {
				esta=true;		
			}
		}
		if(!esta) {
			entradas.add(new Palabra(palabra, desc));
		}else {
			pal.addSignificado(desc);
		}
		
	}
	
	public String searchPalabra(String palabra) {
		boolean esta = false;
		Palabra pal=null;
		Iterator<Palabra> it = entradas.iterator();
		while(it.hasNext() && !esta) {
			pal=it.next();
			if(pal.getSignificante().equals(palabra)) {
				esta=true;		

			}
		}
		return pal.toString();
	}
	
	public void borrarPalabra(String palabra) {
		boolean esta = false;
		Palabra pal=null;
		Iterator<Palabra> it = entradas.iterator();
		while(it.hasNext() && !esta) {
			pal=it.next();
			if(pal.getSignificante().equals(palabra)) {
				esta=true;	
				it.remove();
			}
		}
	}
	
	public String listarPalabras(String comienzo) {
		StringBuilder sb = new StringBuilder();
		Palabra pal;
		Iterator<Palabra> it = entradas.iterator();
		while(it.hasNext()) {
			pal=it.next();
			if(pal.getSignificante().startsWith(comienzo)) {
				sb.append(pal.getSignificante()+"\n");
			}
		}
		
		return sb.toString();
	}
	
}
