package com.colecciones.boletin1.ejercicio8.comparators;

import java.util.Comparator;

import com.colecciones.boletin1.ejercicio8.model.Alumno;

public class AlumnosPorNombreComparator implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		int comparable = 0;
		
		if(o1!=null && o2!=null) {
			comparable = o1.getNombre().compareTo(o2.getNombre());
		}else if(o1==null) {
			comparable = -1;
		}else comparable = 1;
		return comparable;
	}

}
