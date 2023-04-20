package com.colecciones.mockExam.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Historial {

	private Map<LocalDate,Combinacion> sorteos;

	public Historial() {
		super();
		sorteos=new TreeMap<>();
		
	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion sorteo) throws HistorialException {
		boolean guardado = false;
		if(fecha!=null && sorteo!=null && !sorteos.containsKey(fecha)) {
			sorteos.put(fecha, sorteo);
			guardado = true;
		}else throw new HistorialException("Ese sorteo existe, o los datos no son correcto");
		return guardado;
	}
	
	public boolean addSorteo(int dia, int mes, int anno, Combinacion sorteo) throws HistorialException {
		LocalDate fecha = LocalDate.of(anno, mes, dia);
		return addSorteo(fecha, sorteo);
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion sorteo) {
		
		return false;
		
	}
	
	
	
}


