package com.colecciones.boletin1.tests.testEjercicio5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameters;

class TestProfesor {

	Profesor p = new Profesor("Juan", 22, "25669874M");
	Alumno a = new Alumno("Paco", 25, "85214789M");
	Profesor p2 = new Profesor("Alfo", 22, "123456879M");
	
	@ParameterizedTest(name="Numero 1")
	@CsvSource({"16, Profesor","17, Alumno","20, Profesor", "21, Alumno"})
	void testEnviarMensajeAprofesor(int edad, String tipo) {
		Profesor p = new Profesor("Juan", 22, "25669874M");
		Alumno a;
		Profesor p2;
		if(tipo.equals("Profesor")) {
			p2 = new Profesor("Pepe", edad, "123456879M");
			
			p.enviarMensaje(p2, "Hola don Pepito");
			assertTrue(!p2.chat.isEmpty());
		}else {
			a = new Alumno("Paco", edad, "85214789M");
			p.enviarMensaje(a, "hola don Jose");
			assertTrue(!a.chat.isEmpty());
		}
		
	}

	@ParameterizedTest(name="CSVARCHIVO")
	@CsvFileSource(files = "files/enviarMensaje.csv")
	void testEnviarMensajeAprofesorCSV(int edad, String tipo) {
		Profesor p = new Profesor("Juan", 22, "25669874M");
		Alumno a;
		Profesor p2;
		if(tipo.equals("Profesor")) {
			p2 = new Profesor("Pepe", edad, "123456879M");
			
			p.enviarMensaje(p2, "Hola don Pepito");
			assertTrue(!p2.chat.isEmpty());
		}else {
			a = new Alumno("Paco", edad, "85214789M");
			p.enviarMensaje(a, "hola don Jose");
			assertTrue(!a.chat.isEmpty());
		}
		
	}
	
	
	static Map<String,Integer> tipoEdades(){
		Map<String,Integer> valores = new HashMap<>();
		valores.put("alumno", 18);
		valores.put("alumno", 19);
		valores.put("alumno", 15);
		valores.put("profesor", 20);
		
		return valores;
		
	}
	
	@ParameterizedTest(name="Numero 3")
	@MethodSource("tiposEdades")
	void testEnviarMensajeAprofesorMethod(int edad, String tipo) {
		Profesor p = new Profesor("Juan", 22, "25669874M");
		Alumno a;
		Profesor p2;
		if(tipo.equals("Profesor")) {
			p2 = new Profesor("Pepe", edad, "123456879M");
			
			p.enviarMensaje(p2, "Hola don Pepito");
			assertTrue(!p2.chat.isEmpty());
		}else {
			a = new Alumno("Paco", edad, "85214789M");
			p.enviarMensaje(a, "hola don Jose");
			assertTrue(!a.chat.isEmpty());
		}
		
	}
	
	
	@Test
	void testLeerMensajes() {
		p.enviarMensaje(a, "Hola");
		
		assertTrue(!a.leerMensajes().isBlank());
	}

	@Test
	void testLeerMensajesOrdenados() {
		p.enviarMensaje(a, "Hola");
		p.enviarMensaje(a, "Holaaaaaaaaa");
		p2.enviarMensaje(a, "Hola");
		p2.enviarMensaje(a, "Adiooossss");
		
		a.leerMensajesOrdenados();
		
		assertEquals(a.chat.get(0).getTexto(),"Hola");
	}

	@Test
	void testBorrarMensaje() {
		p.enviarMensaje(a, "Hola");
		p.enviarMensaje(a, "Holaaaaaaaaa");
		
		try {
			a.borrarMensaje(0);
		} catch (Exception e) {
			assert(false);
		}
		
		assertEquals(a.chat.get(0).getTexto(), "Holaaaaaaaaa"); 
	}

	@Test
	void testBuscarMensaje() {
		p.enviarMensaje(a, "Hola");
		p.enviarMensaje(a, "Holaaaaaaaaa");
		try {
			assertEquals(a.buscarMensaje("Holaa"), "Holaaaaaaaaa"+"\n"); 
		} catch (Exception e) {
			assert(false);
		}
		
		
	}

}
