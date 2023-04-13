package com.colecciones.boletin1.ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProfesorTest {

	Profesor p = new Profesor("JM", 38, "26666666X");
	Profesor p2 = new Profesor("JC", 30, "26623466X");
	Profesor p3 = new Profesor("JX", 30, "64545366X");
	private static final String MENSAJE = "Este es un mensaje prueba";
	@Test
	void testEnviarMensaje() {

		p.enviarMensaje(p2, MENSAJE);
	}

	@Test
	void testProfesor() {
		Profesor p = new Profesor("JM", 38, "26666666X");
	}

	@Test
	void testLeerMensajes() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p2.leerMensajes();
	}

	@Test
	void testLeerMensajesOrdenados() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p3.enviarMensaje(p2, "Este es un mensaje prueba3");
		p2.leerMensajesOrdenados();
	}

	@Test
	void testBorrarMensaje() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p3.enviarMensaje(p2, "Este es un mensaje prueba3");
		try {
			p2.borrarMensaje(2);
		} catch (Exception e) {
			//
		}
	}
	
	@Test
	void testBorrarMensajeB2() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p3.enviarMensaje(p2, "Este es un mensaje prueba3");
		try {
			p2.borrarMensaje(-1);
		} catch (Exception e) {
			//
		}
	}

	@Test
	void testBorrarMensajeB3() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p3.enviarMensaje(p2, "Este es un mensaje prueba3");
		try {
			p2.borrarMensaje(100);
		} catch (Exception e) {
			//
		}
	}
	
	@Test
	void testBorrarMensajeNull() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p3.enviarMensaje(p2, "Este es un mensaje prueba3");
		try {
			p2.borrarMensaje(0);
			p2.borrarMensaje(0);
		} catch (Exception e) {
			//
		}
	}
	
	@Test
	void testBuscarMensaje() {
		p.enviarMensaje(p2, MENSAJE);
		p.enviarMensaje(p2, "Este es un mensaje prueba2");
		p3.enviarMensaje(p2, "Este es un mensaje prueba3");
		p3.enviarMensaje(p2, "Otra cosa sin nada que ver");
		try {
			p2.buscarMensaje("ver");
		} catch (Exception e) {
		}
	}
	
	@Test
	void testBuscarMensajeB2() {
		try {
			p2.buscarMensaje("ver");
		} catch (Exception e) {
		}
	}

}
