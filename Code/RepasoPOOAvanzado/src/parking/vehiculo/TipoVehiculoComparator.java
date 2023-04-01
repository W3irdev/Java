package parking.vehiculo;

import java.util.Comparator;

public class TipoVehiculoComparator implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		int comparable = 0;
		if(o1!=null && o2!=null) {
			comparable = o1.getTipo().compareTo(o2.getTipo());
			if(comparable == 0) {
				comparable = o1.getCombustible().compareTo(o2.getCombustible());
			}
		}else if (o1==null) {
			comparable = 1;
		}else if (o2==null) {
			comparable = -1;
		}
		
		return comparable;
	}


}
