package com.pooavanzado.parking.model;

import java.util.Arrays;

import com.pooavanzado.parking.comparables.MarcaVehiculoComparator;
import com.pooavanzado.parking.comparables.MatriculaVehiculoComparator;
import com.pooavanzado.parking.comparables.TipoVehiculoComparator;

public class Parking {

	private Vehiculo[] vehiculo;
	private final int PLAZAS=50;
	public Parking() {
		super();
		vehiculo= new Vehiculo[0];
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

	public String ordenarPorMarca() {
		Arrays.sort(vehiculo, new MarcaVehiculoComparator());
		
		return arraysToString(vehiculo);
	}
	public String ordenarPorMatricula() {
		Arrays.sort(vehiculo, new MatriculaVehiculoComparator());
		
		return arraysToString(vehiculo);
	}
	public String ordenarPorTipo() {
		Arrays.sort(vehiculo, new TipoVehiculoComparator());
		
		return arraysToString(vehiculo);
	}
	

	public String arraysToString(Object[] array) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<array.length-1;i++) {
			if(array[i]==null) {
				sb.append("\n");
			}else {
				sb.append(array[i]+"\n");
			}
		}
		
		return sb.toString();
	}

	@Override
	public String toString() {
		Arrays.sort(vehiculo);
		return String.format("Los vehiculos estacionados en el parking son los siguientes: %s]", Arrays.toString(vehiculo));
	}




	


	
	
}
