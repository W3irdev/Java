package com.alquiler.model;

public class Furgoneta extends Vehiculo {
	private double pma;

	public Furgoneta(String matricula, Gama gama, double pma) throws Exception {
		super(matricula, gama);

		if(pma>=1) {
			this.pma=pma;
			super.precioBase+=(0.5*pma);
		}else throw new Exception("Introduzca un pma valido");
		
	}

	public double getPma() {
		return pma;
	}

	@Override
	public String toString() {
		return String.format("%s \n"
				+ "Con Peso Maximo Autorizado: %s.", super.toString(), pma);
	}
	
	

}
