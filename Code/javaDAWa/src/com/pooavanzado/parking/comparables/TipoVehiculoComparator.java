package com.pooavanzado.parking.comparables;

import java.util.Comparator;

import com.pooavanzado.parking.model.Vehiculo;

public class TipoVehiculoComparator implements Comparator<Vehiculo>{

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		int comparable = 0;
		
		if(o1!=null&&o2!=null) {
			comparable = o1.getTipo().compareTo(o2.getTipo());
		}
		
		
		return comparable;
	}

}
