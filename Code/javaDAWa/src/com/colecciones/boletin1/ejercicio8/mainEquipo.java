package com.colecciones.boletin1.ejercicio8;

import com.colecciones.boletin1.ejercicio2.model.Alumno;
import com.colecciones.boletin1.ejercicio2.model.AlumnoException;
import com.colecciones.boletin1.ejercicio2.model.Equipo;

public class mainEquipo {

	public static void main(String[] args) {

		Equipo prueba = new Equipo("El pruebas");
		Equipo prueba2 = new Equipo("El pruebas Externo");
		Equipo prueba3 = new Equipo("El pruebas Otro");
		
		try {
			prueba.addAlumno(new Alumno("El capitan", "12345678C"));
			prueba.addAlumno(new Alumno("El portero", "123123123"));
			prueba.addAlumno(new Alumno("El pivot", "75656566"));
			prueba.addAlumno(new Alumno("El portero del intersect", "22222"));
			prueba.addAlumno(new Alumno("El pivot del intersect", "33333"));
			
			System.out.println(prueba);
			
			prueba2.addAlumno(new Alumno("El capitan del otro", "34234"));
			prueba2.addAlumno(new Alumno("El portero del otro", "56664"));
			prueba2.addAlumno(new Alumno("El pivot del otro", "56756756"));
			
			System.out.println(prueba2);
			
			System.out.println(prueba.unionEquipo(prueba2));
			
			prueba3.addAlumno(new Alumno("El capitan del intersect", "11111"));
			prueba3.addAlumno(new Alumno("El portero del intersect", "22222"));
			prueba3.addAlumno(new Alumno("El pivot del intersect", "33333"));

			
			System.out.println(prueba3);
			
			System.out.println(prueba.intersectEquipo(prueba3));
			
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
	}

}
