package com.alquiler.model;

public class Microbus extends Vehiculo{
	private int plazas;
	

	public Microbus(String matricula, Gama gama, int plazas) throws Exception {
		super(matricula, gama);
		if(plazas>=1) {
			this.plazas=plazas;
			super.precioBase+=(plazas*5);
			
		}else throw new Exception("Debe indicar numero de plazas");
	}


	public int getPlazas() {
		return plazas;
	}


	@Override
	public String toString() {
		return String.format("%s \n"
				+ "Con %s plazas.", super.toString(), plazas);
	}

	
	

}
