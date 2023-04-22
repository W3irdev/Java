package com.colecciones.mockExam.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		return sorteos.replace(fecha, sorteo)!=null;
	}
	
	public boolean actualizarSorteo(int dia, int mes, int anno, Combinacion sorteo) {
		LocalDate fecha = LocalDate.of(anno, mes, dia);
		return actualizarSorteo(fecha, sorteo);
	}
	
	public boolean borrarSorteo(LocalDate fecha) {
		
		return sorteos.remove(fecha)!=null;
	}
	
	public List<String> listarSorteosDesdeFecha(LocalDate fecha){
		List<String> listado = new ArrayList<>();
		
		for (LocalDate d : sorteos.keySet()) {
			if(d.isAfter(fecha)) {
				listado.add(sorteos.get(d).toString());
			}
		}
		return listado;
		}
	
	public List<String> mostrarHistorico(){
		List<String> listado = new ArrayList<>();
		for(LocalDate d : sorteos.keySet()) {
			listado.add(sorteos.get(d).toString());
		}
		
		return listado;
		
	}
	
	public Map<String,Integer> comprobarAciertos(LocalDate fecha, Combinacion numeros) throws HistorialException{
		Map<String,Integer> aciertos = new HashMap<>();
		
		if(fecha!=null && numeros!=null && sorteos.containsKey(fecha)) {
			aciertos.put(fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), sorteos.get(fecha).comprobarCombinacion(numeros));
			
		}else throw new HistorialException("El sorteo no se ha celebrado");
		return aciertos;
	}
	
}


