package parking.parking;

import java.util.Arrays;

import parking.vehiculo.MarcaVehiculoComparator;
import parking.vehiculo.MatriculaVehiculoComparator;
import parking.vehiculo.TipoVehiculoComparator;
import parking.vehiculo.Vehiculo;

public class Parking {

	private static final int PLAZAS=50;
	private int estacionados;
	private Vehiculo[] garaje;
	
	public Parking() {
		super();
		garaje = new Vehiculo[PLAZAS];
		this.estacionados=0;
	}
	
	public int buscarVehiculo(String matricula) {
		int esta=-1;
		for(int i=0; i<garaje.length && esta==-1;i++) {
			if(garaje[i]!=null && garaje[i].getMatricula().equals(matricula)) {
				esta=i;
			}
		}
		
		return esta;
	}
	
	public void estacionar(Vehiculo vehiculo) throws ParkingException {
		if(buscarVehiculo(vehiculo.getMatricula())==-1 && estacionados<PLAZAS) {
			boolean libre=false;
			for(int i=0; i<garaje.length && !libre;i++) {
				if(garaje[i]==null) {
					libre=true;
					garaje[i]=vehiculo;
				}
			}
		}else throw new ParkingException("El vehiculo esta dentro o no hay espacio");
		
		
	}
	
	public void salir(Vehiculo vehiculo) throws ParkingException {
		if(buscarVehiculo(vehiculo.getMatricula())!=-1) {
			garaje[buscarVehiculo(vehiculo.getMatricula())]=null;

		}else throw new ParkingException("El vehiculo no se encuentra en el parking");
		
		
	}

	public String ordenarPorMarca() {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(garaje, new MarcaVehiculoComparator());
		for(Vehiculo v:garaje) {
			if(v!=null) sb.append(v);
		}
		
		return sb.toString();
	}
	
	public String ordenarPorMatricula() {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(garaje, new MatriculaVehiculoComparator());
		for(Vehiculo v:garaje) {
			if(v!=null) sb.append(v);
		}
		
		return sb.toString();
	}
	
	public String ordenarPorTipo() {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(garaje, new TipoVehiculoComparator());
		for(Vehiculo v:garaje) {
			if(v!=null) sb.append(v);
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Vehiculo v:garaje) {
			if(v!=null) sb.append(v);
		}
		return String.format("%s", sb.toString());
	}
	
	
	
}
