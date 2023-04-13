package com.colecciones.boletin1.ejercicio4.model;

import java.util.ArrayList;
import java.util.List;

public class Historial {

	List<PaginaWeb> datos;

	public Historial() {
		this.datos = new ArrayList<>();
	}
	
	public void addPagina(PaginaWeb web) throws Exception {
		if(datos.get(datos.size()-1).getVisita().isAfter(web.getVisita())) {
			throw new Exception("La fecha es anterior a la ultima");
		}else datos.add(web);
		
	}
	
	
	
}
