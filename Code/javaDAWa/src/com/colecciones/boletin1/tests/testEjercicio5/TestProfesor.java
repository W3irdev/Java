package com.colecciones.boletin1.tests.testEjercicio5;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameters;

class TestProfesor {

	
	@Test
	@ParameterizedTest
	@ValueSource(classes = {Persona.class})
	void testEnviarMensaje(Profesor p) {
		
		p.enviarMensaje(p, "Mensaje de prueba");
		assertTrue(p.chat.size()>0);
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
