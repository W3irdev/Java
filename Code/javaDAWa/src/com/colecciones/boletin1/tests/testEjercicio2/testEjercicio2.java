package com.colecciones.boletin1.tests.testEjercicio2;

import static org.junit.Assert.*;
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
			assertEquals(alum1, betis.existeAlumno(alum1), "Existe");
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testAddAlumnoKO() {
		try {
			betis.addAlumno(null);
			assertNotEquals(alum1, betis.existeAlumno(alum1), "No existe");
		} catch (AlumnoException e) {
			assert(true);
		}
	}

	@Test
	void testDelAlumnoOK() {
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
			betis.delAlumno(alum1);
			assertNotEquals(alum1, betis.existeAlumno(alum1), "Borrado");
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testDelAlumnoKO() {
		try {
			betis.addAlumno(alum2);
			betis.delAlumno(alum1);
			
		} catch (Exception e) {
			assert(true);
		}
	}

	@Test
	void testExisteAlumnoOK() {
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
			assertEquals(alum1, betis.existeAlumno(alum1), "Existe");
		} catch (Exception e) {
			assert(false);
		}
	}
	

	@Test
	void testUnionEquipoOK() {
		Equipo sevilla = new Equipo("sevilla");
		Alumno alum3 = new Alumno("IC", "456456");
		Alumno alum4 = new Alumno("KK", "878978");
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
			sevilla.addAlumno(alum3);
			sevilla.addAlumno(alum4);
			
			sevilla.unionEquipo(betis);
			assertEquals(alum1, sevilla.existeAlumno(alum1), "Existe");
		} catch (AlumnoException e) {
			assert(false);
		}
	}
	
	@Test
	void testUnionEquipoKO() {
		Equipo sevilla = new Equipo("sevilla");
		Alumno alum3 = new Alumno("IC", "456456");
		Alumno alum4 = new Alumno("KK", "878978");
		Alumno alum5 = new Alumno("KOKO", "741698");
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
			sevilla.addAlumno(alum3);
			sevilla.addAlumno(alum4);
			
			sevilla.unionEquipo(betis);
			assertNotEquals(alum5, sevilla.existeAlumno(alum5), "No existe");
		} catch (AlumnoException e) {
			assert(false);
		}
	}

	@Test
	void testIntersectEquipoOK() {
		Equipo sevilla = new Equipo("sevilla");
		Alumno alum3 = new Alumno("IC", "456456");
		Alumno alum4 = new Alumno("KK", "878978");
		Alumno alum5 = new Alumno("KOKO", "741698");
		
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
			betis.addAlumno(alum3);
			sevilla.addAlumno(alum3);
			sevilla.addAlumno(alum4);
			sevilla.addAlumno(alum1);
			
			sevilla.intersectEquipo(betis);
			assertEquals(alum1, sevilla.existeAlumno(alum1), "Existe");
		} catch (AlumnoException e) {
			assert(false);
		}
	}
	
	@Test
	void testIntersectEquipoKO() {
		Equipo sevilla = new Equipo("sevilla");
		Alumno alum3 = new Alumno("IC", "456456");
		Alumno alum4 = new Alumno("KK", "878978");
		Alumno alum5 = new Alumno("KOKO", "741698");
		
		try {
			betis.addAlumno(alum1);
			betis.addAlumno(alum2);
			betis.addAlumno(alum3);
			sevilla.addAlumno(alum3);
			sevilla.addAlumno(alum4);
			sevilla.addAlumno(alum1);
			
			sevilla.intersectEquipo(betis);
			assertNotEquals(alum2, sevilla.existeAlumno(alum2), "Existe");
		} catch (AlumnoException e) {
			assert(false);
		}
	}

	@Test
	void testMostrarAlumnos() {
		try {
			betis.addAlumno(alum1);
			betis.mostrarAlumnos();
		
		} catch (Exception e) {
			assert(false);
		}
	}
	

}
