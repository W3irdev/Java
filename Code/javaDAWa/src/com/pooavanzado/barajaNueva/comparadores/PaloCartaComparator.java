package com.pooavanzado.barajaNueva.comparadores;

import java.util.Comparator;

import com.pooavanzado.barajaNueva.model.Carta;

public class PaloCartaComparator implements Comparator<Carta>{

	@Override
	public int compare(Carta o1, Carta o2) {
		int compare = 0;
		if(o1!=null&&o2!=null) {
			compare = o1.getPalo().toString().compareTo(o2.getPalo().toString());
		}else if(o1==null) {
			compare = 1;
		}else if(o2==null) {
			compare = -1;
		}
		
		return compare;
	}

}
