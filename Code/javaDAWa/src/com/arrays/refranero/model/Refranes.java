package com.arrays.refranero.model;

import java.util.Arrays;

public class Refranes {

	private Refran[] refranes;
	public int index;
	
	
	
	public Refranes() {
		super();
		refranes = new Refran[50];
		for(int i=0; i<refranes.length;i++) {
			refranes[i]=new Refran("");
		}
		index=0;
		
	}
	public void addRefran(Refran refran) {
		boolean contiene = false;
		for(Refran r:refranes) {
			if(r.equals(refran)) {
				contiene=true;
			}
		}
		if(!contiene) {
			refranes[index]=refran;
			index++;
		}else {
			System.err.println("El refran ya existe en la lista");
		}
		
		
		}
	public Refran buscarRefran(String palabra) {
		Refran encontrado = new Refran("No se ha encontrado");
		for(Refran r:refranes) {
			if(r.contains(palabra)) {
				encontrado=r;
				
			}
		}
		return encontrado;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<refranes.length;i++) {
			sb.append(refranes[i]+"\n");
		}
		return sb.toString();
	}
	
	
}
