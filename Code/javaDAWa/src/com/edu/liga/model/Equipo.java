package com.edu.liga.model;

import java.util.Objects;

public class Equipo {

	private int goles;
	private String nombre;
	private String estadio;
	private String ciudad;
	
	
	
	public Equipo(String nombre, String estadio, String ciudad) {
		super();
		this.nombre = nombre;
		this.goles = 0;
		this.estadio = estadio;
		this.ciudad = ciudad;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		if (goles>=0) {
		this.goles = goles;}
	}

	
	
	public String getNombre() {
		return nombre;
	}
	public String getEstadio() {
		return estadio;
	}
	public String getCiudad() {
		return ciudad;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Equipo)) {
			return false;
		}
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
