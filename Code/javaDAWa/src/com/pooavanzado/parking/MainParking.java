package com.pooavanzado.parking;

import java.util.Arrays;

import com.pooavanzado.parking.comparables.MarcaVehiculoComparator;
import com.pooavanzado.parking.model.Parking;
import com.pooavanzado.parking.model.Vehiculo;

public class MainParking {

	public static void main(String[] args) {
		Parking pk = new Parking();
		pk.aparcar(new Vehiculo("Mercedes", "CLK", "2417GNX", "GASOLINA", "23-03-2023", "TRANSPORTE_MERCANCIAS"));
		pk.aparcar(new Vehiculo("FORD", "FOCUS", "2407GNX", "GASOIL", "20-03-2023", "AUTOMOVIL"));
		pk.aparcar(new Vehiculo("DACIA", "SANDERO", "2408GNX", "GASOLINA", "21-03-2023", "TRANSPORTE_MERCANCIAS"));
		pk.aparcar(new Vehiculo("DACIA", "DUSTER", "2409GNX", "GASOIL", "22-03-2023", "AUTOMOVIL"));
		pk.salir(new Vehiculo("Mercedes", "CLK", "2423GNX", "GASOLINA", "20-03-2023", "TRANSPORTE_MERCANCIAS"));
		
		System.out.println(pk);
		
		
		System.out.println(pk.ordenarPorTipo());

	
		
		
	}

}
