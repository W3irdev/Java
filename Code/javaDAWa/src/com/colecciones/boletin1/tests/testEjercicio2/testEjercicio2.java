package com.colecciones.boletin1.tests.testEjercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.colecciones.boletin1.ejercicio2.model.Alumno;
import com.colecciones.boletin1.ejercicio2.model.AlumnoException;
import com.colecciones.boletin1.ejercicio2.model.Equipo;

class testEjercicio2 {
	
	Alumno alum1 = new Alumno("JM", "123123");
	Alumno alum2 = new Alumno("JC", "123423");
	
	Equipo betis = new Equipo("Betis");

	@Test
	void testAddAlumnoOK() {
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testAddAlumnoKO() {
		try {
			betis.addAlumno(null);
			betis.addAlumno(null);
		} catch (AlumnoException e) {
			assert(true);
		}
	}

	@Test
	void testDelAlumno() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteAlumno() {
		fail("Not yet implemented");
	}

	@Test
	void testUnionEquipo() {
		fail("Not yet implemented");
	}

	@Test
	void testIntersectEquipo() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarAlumnos() {
		fail("Not yet implemented");
	}

}
