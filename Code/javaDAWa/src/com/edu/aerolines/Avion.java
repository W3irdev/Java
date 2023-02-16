package com.edu.aerolines;

public class Avion {

	private String idAvion;
	private Integer capacidad;
	private Integer numVuelos = 0;
	private Double kmVolados = 0.0;
	private String compannia;
	
	
	public Integer getNumVuelos() {
		return numVuelos;
	}

	public Double getKmVolados() {
		return kmVolados;
	}
	
	public Double getMediaKm() {
		return this.kmVolados/this.numVuelos;
	}

	
	public Avion(String idAvion, Integer capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
	}
	
	public Avion() {
		super();
		this.idAvion = "0";
		this.capacidad = 0;
		this.compannia = "";
		
	}
	
	public Avion(String idAvion,String compannia, Integer capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
		this.compannia = compannia;
		
	}

	public String getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	protected void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getCompannia() {
		return compannia;
	}

	public void setCompannia(String compannia) {
		this.compannia = compannia;
	}

	public void setNumVuelos(Integer numVuelos) {
		this.numVuelos = numVuelos;
	}

	public void setKmVolados(Double kmVolados) {
		this.kmVolados = kmVolados;
	}
	
	public boolean asignarVuelo(int asientos, Double distancia) {
		
		return capacidad>asientos&&distancia>0;
		
	}
	
	

	

}
