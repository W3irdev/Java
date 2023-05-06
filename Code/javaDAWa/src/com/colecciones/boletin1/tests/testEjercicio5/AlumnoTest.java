package com.colecciones.boletin1.tests.testEjercicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	Profesor p = new Profesor("JM", 38, "26666666X");
	Alumno a = new Alumno("JA", 15, "123123123");
	Alumno a2 = new Alumno("JASON", 14, "65656565");
	Alumno a3 = new Alumno("JASON", 25, "445345354");
	private static final String MENSAJE = "Este es un mensaje prueba";
	
	@Test
	void testEnviarMensaje() {
		try {
			a.enviarMensaje(p, MENSAJE);
			a.enviarMensaje(a2, MENSAJE);
		} catch (Exception e) {
			//
		}
	}
	
	@Test
	void testEnviarMensajeB2() {
		try {
			a.enviarMensaje(a2, MENSAJE);
		} catch (Exception e) {
			//
		}
	}
	
	
	@Test
	void testEnviarMensajeB3() {
		try {
			a3.enviarMensaje(a2, MENSAJE);
		} catch (Exception e) {
			//
		}
	}

}
