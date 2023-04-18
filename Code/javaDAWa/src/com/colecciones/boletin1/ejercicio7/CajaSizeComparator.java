package com.colecciones.boletin1.ejercicio7;

import java.util.Comparator;

public class CajaSizeComparator implements Comparator<Caja> {

	@Override
	public int compare(Caja o1, Caja o2) {
		int comparable = 0;
		if(o1!=null && o2!=null) {
			if(o1.getSizeCaja()==o2.getSizeCaja()) {
				comparable = o1.getNumCaja()-o2.getNumCaja();
			}else {
				comparable = o1.getSizeCaja()-o2.getSizeCaja();
				
			}
		}else if(o1==null) {
			comparable = -1;
			
		}else {
			comparable = 1;
		}
		return comparable;
	}

}
