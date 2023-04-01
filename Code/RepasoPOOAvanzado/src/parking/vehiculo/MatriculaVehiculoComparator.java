package parking.vehiculo;

import java.util.Comparator;

public class MatriculaVehiculoComparator implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		int comparable = 0;
		if(o1!=null && o2!=null) {
			comparable = o1.getMatricula().compareTo(o2.getMatricula());
		}else if (o1==null) {
			comparable = 1;
		}else {
			comparable = -1;
		}
		return comparable;
	}

}
