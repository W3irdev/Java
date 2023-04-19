package com.colecciones.boletin1.ejercicio4.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {

	private String url;
	private LocalDateTime visita;
	
	public PaginaWeb(String url) {
		this.url = url;
		this.visita = LocalDateTime.now();
	}
	
	public PaginaWeb(String url, LocalDateTime visita) {
		this(url);
		this.visita = visita;
	}
	
	
	public String getUrl() {
		return this.url;
	}
	

	public LocalDateTime getVisita() {
		return visita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		boolean igual = this == obj;
		
		if (obj!=null && !igual && (obj instanceof PaginaWeb web)) {
			igual = Objects.equals(url, web.url);
		}
		
		return igual;
	}

	@Override
	public String toString() {
		return String.format("%s, se visito el %s", url, visita);
	}
	
	
	
	
	
}
