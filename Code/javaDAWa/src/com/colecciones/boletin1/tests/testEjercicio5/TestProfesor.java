package com.colecciones.boletin1.tests.testEjercicio5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameters;

class TestProfesor {

	
	
	@ParameterizedTest
	@CsvSource({"Hola como estas, 20, 25000000C", "Hola como estas, 20, 25000000C"})
	void testEnviarMensajeAprofesor(String mensaje, int edad, String dni) {
		Profesor p = new Profesor("Esto no lo veo", 25, "25669874M");
		Profesor p2 = new Profesor(mensaje, edad, dni);
		Alumno a = new Alumno(mensaje, edad, dni);
		p.enviarMensaje(p2, mensaje);
		p.enviarMensaje(a, mensaje);
		
		assertTrue(p2.chat.size()>0);
		assertTrue(a.chat.size()>0);
	}

	@ParameterizedTest
	@CsvSource({"Hola como estas, 20, 25000000C", "Hola como estas, 15, 25000000C"})
	void testEnviarMensajeAalumno(String mensaje, int edad, String dni) {
		Profesor p = new Profesor("Esto no lo veo", 25, "25669874M");
		Alumno a = new Alumno("Hola", 18, "25555");
		Alumno a2 = new Alumno(mensaje, edad, dni);
		try {
			a2.enviarMensaje(a, mensaje);
			assertTrue(a2.chat.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	@Test
	void testLeerMensajes() {
		fail("Not yet implemented");
	}

	@Test
	void testLeerMensajesOrdenados() {
		fail("Not yet implemented");
	}

	@Test
	void testBorrarMensaje() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarMensaje() {
		fail("Not yet implemented");
	}

}
