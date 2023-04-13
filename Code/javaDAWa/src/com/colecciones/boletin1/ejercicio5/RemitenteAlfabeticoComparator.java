package com.colecciones.boletin1.ejercicio5;

import java.util.Comparator;

public class RemitenteAlfabeticoComparator implements Comparator<Mensaje> {

	@Override
	public int compare(Mensaje o1, Mensaje o2) {
		int comparador=0;
		
		if(o1!=null && o2!=null) {
			comparador=o1.getRemitente().nombre.compareTo(o2.getRemitente().nombre);
		}else if(o1==null) {
			comparador=1;
		}else if(o2==null) {
			comparador=-1;
		}
		
		return comparador;
	}

}
