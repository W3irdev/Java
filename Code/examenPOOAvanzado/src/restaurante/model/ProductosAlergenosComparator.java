package restaurante.model;

import java.util.Comparator;

public class ProductosAlergenosComparator implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		int comparable = 0;
		if(o1!=null && o2!=null) {
			comparable = o1.alergeno.compareTo(o2.alergeno);
		}else if(o1==null) {
			comparable = 1;
		}else if(o2==null) {
			comparable = -1;
		}
		return comparable;
	}

}
