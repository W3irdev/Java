package com.edu.aerolines.models;

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
		Double media=0.0;
		if (kmVolados>=1&&numVuelos>=1) {
			media = this.kmVolados/this.numVuelos;
		}
		
		return media;
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


	public Integer getCapacidad() {
		return capacidad;
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
		boolean esPosibleAsignarVuelvo = false;
		
		if (capacidad>=asientos&&asientos>0&&distancia>0) {
			this.numVuelos++;
			this.kmVolados+=distancia;
			
		}
		
		return esPosibleAsignarVuelvo;
		
	}

	@Override
	public String toString() {
		return "Avion con id: " + idAvion + ", de la compañia: " + compannia +", ha realizado " + numVuelos + ", con un total de " + kmVolados + "kms, y una media de: " + getMediaKm() + " kms por vuelo";
	}
	
	
	

	

}
