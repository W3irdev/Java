package com.colecciones.boletin1.ejercicio4.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Historial {

	List<PaginaWeb> datos;

	public Historial() {
		this.datos = new ArrayList<>();
	}

	public void addPagina(PaginaWeb web) throws Exception {
		if(web!=null && datos.isEmpty()) {
			datos.add(web);
		
		}else if (web!=null && web.getVisita().isAfter(this.datos.get(datos.size()-1).getVisita())) {
			datos.add(web);
		}
		
	}
	
	public String consultarHistorial() {
		StringBuilder sb = new StringBuilder();
		
		for (PaginaWeb paginaWeb : datos) {
			if(paginaWeb!=null) sb.append(paginaWeb + "\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Consulta el historial de un dia.
	 * @param dia
	 * @return sb.toString
	 * @author Josemi
	 */

	public String consultarHistorial(LocalDate dia) {

		StringBuilder sb = new StringBuilder();
		
		for (PaginaWeb paginaWeb : datos) {
			if(paginaWeb!=null && paginaWeb.getVisita().toLocalDate().isEqual(dia)) {
				sb.append(paginaWeb + "\n");
			}
		}
		
		return sb.toString();
	}
	
	/*public Historial consultarHistorial() throws Exception {
		Historial consulta = new Historial();
		
		for (PaginaWeb paginaWeb : datos) {
			if(paginaWeb!=null) {
				consulta.addPagina(paginaWeb);
			}
		}
		
		return consulta;
	}*/
	
	/*public Historial consultarHistorialDia(LocalDate dia) throws Exception {
		Historial consulta = new Historial();
		
		for (PaginaWeb paginaWeb : datos) {
			if(paginaWeb!=null && paginaWeb.getVisita().getDayOfYear()==dia.getDayOfYear()) {
				consulta.addPagina(paginaWeb);
			}
		}
		
		return consulta;
	}*/
	
	public void borrarHistorial() {
		datos.clear();
	}
	
	public void borrarHistorial(PaginaWeb web) {
		if(datos.contains(web)) datos.remove(web);
	}

	@Override
	public String toString() {
		return String.format("%s %n", datos);
	}
	

	
	
}
