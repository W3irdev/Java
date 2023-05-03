package ciudades.model;

import java.util.Comparator;

public class OrdenNumeroDireccionesComparator implements Comparator<City> {

	@Override
	public int compare(City o1, City o2) {
		int orden=0;
		if(o1!=null && o2!=null) {
			orden=o1.sizeAddresses()-o2.sizeAddresses();
			if(orden==0) {
				orden=o1.getName().compareTo(o2.getName());
			}
		}else if(o1==null) {
			orden=-1;
		}else orden=1;
		return orden;
	}



}
