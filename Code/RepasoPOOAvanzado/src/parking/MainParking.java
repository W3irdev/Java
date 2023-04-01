package parking;

import parking.parking.Parking;
import parking.parking.ParkingException;
import parking.vehiculo.Vehiculo;
import parking.vehiculo.VehiculoException;

public class MainParking {

	public static void main(String[] args) {

		Parking pk = new Parking();
		try {
			pk.estacionar(new Vehiculo("Mercedes", "CLK", "2417GNX", "GASOLINA", "MERCANCIAS"));
			pk.estacionar(new Vehiculo("FORD", "FOCUS", "2407GNX", "GASOIL", "AUTOMOVIL"));
			pk.estacionar(new Vehiculo("DACIA", "SANDERO", "2408GNX", "GASOLINA", "MERCANCIAS"));
			pk.estacionar(new Vehiculo("DACIA", "DUSTER", "2409GNX", "GASOIL", "AUTOMOVIL"));
			pk.salir(new Vehiculo("Mercedes", "CLK", "2417GNX", "GASOLINA", "MERCANCIAS"));
			
			System.out.println(pk);
			
			Vehiculo coche = new Vehiculo("Ford", "Mondeo", "2503GNX", "GASOIL", "AUTOMOVIL");
			
			System.out.println(pk.ordenarPorTipo());
		} catch (ParkingException | VehiculoException e) {
			e.printStackTrace();
		}

	}

}
