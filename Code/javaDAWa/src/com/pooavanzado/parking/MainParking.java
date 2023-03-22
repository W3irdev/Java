package com.pooavanzado.parking;

import java.util.Arrays;

import com.pooavanzado.parking.comparables.MarcaVehiculoComparator;
import com.pooavanzado.parking.model.Parking;
import com.pooavanzado.parking.model.Vehiculo;

public class MainParking {

	public static void main(String[] args) {
		Parking pk = new Parking();
		pk.aparcar(new Vehiculo("Mercedes", "CLK", "2417GNX", "GASOLINA", "23-03-2023", "AUTOMOVIL"));
		pk.aparcar(new Vehiculo("Mercedes", "CLK", "2407GNX", "GASOLINA", "20-03-2023", "AUTOMOVIL"));
		pk.aparcar(new Vehiculo("Mercedes", "CLK", "2408GNX", "GASOLINA", "21-03-2023", "AUTOMOVIL"));
		pk.aparcar(new Vehiculo("Mercedes", "CLK", "2409GNX", "GASOLINA", "22-03-2023", "AUTOMOVIL"));
		pk.salir(new Vehiculo("Mercedes", "CLK", "2407GNX", "GASOLINA", "20-03-2023", "AUTOMOVIL"));
		
		System.out.println(pk);
		
		Vehiculo coche = new Vehiculo("Ford", "Mondeo", "2503GNX", "GASOIL", "20-03-2023", "AUTOMOVIL");
		
		Arrays.sort(pk.getVehiculo(), new MarcaVehiculoComparator());

	
		
		
	}

}