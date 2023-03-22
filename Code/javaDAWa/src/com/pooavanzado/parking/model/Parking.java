package com.pooavanzado.parking.model;

import java.util.Arrays;

public class Parking {

	private Vehiculo[] vehiculo;
	private final int PLAZAS=50;
	private static int contador = 0;
	
	
	public Parking() {
		super();
		vehiculo= new Vehiculo[0];
	}

















	public Vehiculo[] getVehiculo() {
		return vehiculo;
	}

















	public void aparcar(Vehiculo vehiculo) {
		boolean aparcado = false;
		
		if(this.vehiculo.length<PLAZAS) {
			
			this.vehiculo = Arrays.copyOf(this.vehiculo, this.vehiculo.length+1);
			
			for(int i=0; i<this.vehiculo.length&&!aparcado;i++) {
				if(this.vehiculo[i]==null) {
					this.vehiculo[i]=vehiculo;
					aparcado=true;
					
				}
			
		}
		
		}
		
	
	}
	
	public void salir(Vehiculo vehiculo) {

		for(int i=0; i<this.vehiculo.length;i++) {
			if(vehiculo.equals(this.vehiculo[i])) {
				this.vehiculo[i]=this.vehiculo[this.vehiculo.length-1];
				this.vehiculo = Arrays.copyOf(this.vehiculo, this.vehiculo.length-1);
			}
		}
	}



	@Override
	public String toString() {
		Arrays.sort(vehiculo);
		return String.format("Los vehiculos estacionados en el parking son los siguientes: %s]", Arrays.toString(vehiculo));
	}


























	


	
	
}
