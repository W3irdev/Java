package com.alquiler.model;

import java.util.Arrays;

public class Alquiler {

	private static final int MAXIMO_VEHICULOS=200;
	private int codigo;
	private int dias;
	private double precio;
	private Vehiculo[] alquiler;

	
	
	public Alquiler() {
		super();
		alquiler= new Vehiculo[MAXIMO_VEHICULOS];
		
		
	}
	
	public void altaVehiculo(Vehiculo v) {

		if (v!=null) {
			alquiler[codigo++%MAXIMO_VEHICULOS]=v;
		}
	}
	
	public int posicionVehiculo(String matricula) {
		int encontrado=-1;
		for(int i=0; i<alquiler.length && encontrado==-1;i++) {
			if(alquiler[i]!=null && alquiler[i].getMatricula().equals(matricula)) {
				encontrado=i;
			}
		}
		return encontrado;
	}
	
	public double calcularPrecio(String matricula, int dias) throws Exception {
		double precioTotal=0;
		if(posicionVehiculo(matricula)!=-1) {
			precioTotal=alquiler[posicionVehiculo(matricula)].getPrecioBase()*dias;
		}else throw new Exception("El vehiculo no existe o la matricula es incorrecta");
		return precioTotal;
	}

	@Override
	public String toString() {
		return String.format("%s \n", Arrays.toString(alquiler));
	}
	
	
	
}
