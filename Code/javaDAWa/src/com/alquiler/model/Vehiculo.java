package com.alquiler.model;

import java.util.Objects;

public class Vehiculo{

	protected String matricula;
	Gama gama;
	protected double precioBase;
	
	/**
	 * @param matricula
	 * @param gama
	 * @param precioBase
	 * @throws Exception 
	 */
	public Vehiculo(String matricula, Gama gama) throws Exception {
		super();
		setMatricula(matricula);
		this.gama = gama;
		this.precioBase = gama.getValor();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws Exception {
		if(matricula!=null && matricula.matches("[0-9]{4}[A-Za-z]{3}") || 
				matricula.matches("[A-Za-z]{2}[0-9]{4}[A-Za-z]{2}")) {
			this.matricula=matricula;
		}else throw new Exception("El formato de matricula no es valida");
	}

	public Gama getGama() {
		return gama;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual= this == obj;

		if (obj!=null && !esIgual &&(obj instanceof Vehiculo v)) {
			esIgual = Objects.equals(matricula, v.matricula);
		}
		
		return esIgual;
	}

	@Override
	public String toString() {
		return String.format("%s: \n"
				+ "Matricula: %s \n"
				+ "Gama: %s \n"
				+ "Precio Base: %s", getClass().getSimpleName(), matricula, gama.toString(), precioBase);
	}
	
	
	
}
