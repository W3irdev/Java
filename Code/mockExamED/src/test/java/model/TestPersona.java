package test.java.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.java.model.Persona;

class TestPersona {

	Persona prueba = new Persona("Jose", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
	@Test
	void testPersonaStringStringStringOK() {
		try {
			new Persona("Jose", "Miguel", "47349821C");
			assertTrue(new Persona("Jose", "Miguel", "47349821C") instanceof Persona);
		} catch (Exception e) {
			assert(false);
		}
		
	}
	
	@Test
	void testPersonaStringStringStringKO() {
		try {
			new Persona("Jose", "Miguel", "47349821A");
		} catch (Exception e) {
			assert(true);
		}
		
	}

	@Test
	void testPersonaStringStringStringLocalDateStringOK() {
		try {
			new Persona("Jose", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
			assertTrue(new Persona("Jose", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE") instanceof Persona);
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testPersonaStringStringStringLocalDateStringKO() {
		try {
			new Persona("Jose", "Miguel", null, LocalDate.of(1000, 07, 20), "HOMBRE");
		} catch (Exception e) {
			assert(true);
		}
	}

	@Test
	void testValidarDatosStringStringStringOK() {
		assertTrue(prueba.validarDatos("Josemi", "Cabrera", "47349821C"));
		
	}
	
	@Test
	void testValidarDatosStringStringStringKOEmpty(){
		assertFalse(prueba.validarDatos("", "Cabrera", "47349821A"));
		assertFalse(prueba.validarDatos("Josemi", "", "47349821A"));
		assertFalse(prueba.validarDatos("Josemi", "Cabrera", ""));
		assertFalse(prueba.validarDatos("Josemi", "Cabrera", "234523"));
		assertFalse(prueba.validarDatos("Josemi", "Cabrera", "4739821C"));
		assertFalse(prueba.validarDatos("Josemi", "Cabrera", "4739821K"));
		assertFalse(prueba.validarDatos("Josemi", "Cabrera", "473D98212"));
		
	}
	
	@Test
	void testValidarDatosStringStringStringKONull() {
		assertFalse(prueba.validarDatos(null, "Cabrera", "47349821A"));
		assertFalse(prueba.validarDatos("Josemi", null, "47349821A"));
		assertFalse(prueba.validarDatos("Josemi", "Cabrera", null));
		
	}

	@Test
	void testValidarDatosStringStringStringLocalDateStringOK() {
		assertTrue(prueba.validarDatos("Jose", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE"));
	
	}
	
	@Test
	void testValidarDatosStringStringStringLocalDateStringKOEmpty() {
		assertFalse(prueba.validarDatos("", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", "473498212", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", "4734921C", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", "4734921A", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", "", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), ""));
	
	}
	
	@Test
	void testValidarDatosStringStringStringLocalDateStringKONull() {
		assertFalse(prueba.validarDatos(null, "Miguel", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", null, "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", null, LocalDate.of(1992, 07, 20), "HOMBRE"));
		assertFalse(prueba.validarDatos("Josemi", "Miguel", "47349821C", null, "HOMBRE"));
		assertFalse(prueba.validarDatos("Jose", "Miguel", "47349821C", LocalDate.of(1992, 07, 20), null));
	
	}

	@Test
	void testBonoJovenDisponibleOK() {
		Persona joven = new Persona("Josemi", "Miguel", "47349821C", LocalDate.of(1995, 07, 20), "HOMBRE");
		assertTrue(joven.bonoJovenDisponible());
	}
	
	@Test
	void testBonoJovenDisponibleKOMenor() {
		Persona joven = new Persona("Josemi", "Miguel", "47349821C", LocalDate.of(2005, 07, 20), "HOMBRE");
		assertFalse(joven.bonoJovenDisponible());
	}
	
	@Test
	void testBonoJovenDisponibleKO() {
		Persona joven = new Persona("Josemi", "Miguel", "47349821C", LocalDate.of(1990, 07, 20), "HOMBRE");
		assertFalse(joven.bonoJovenDisponible());
	}

	@Test
	void testObtenerEdadOK() {
		assertEquals(prueba.obtenerEdad(), 31);
	}

	@ParameterizedTest
	@CsvSource({"2030,38","2031,39"})
	void testObtenerEdadPara(int year, int edad) {
		assertTrue(prueba.obtenerEdadPara(year)==edad);
	}
	
	@ParameterizedTest
	@MethodSource("yearList")
	void testObtenerEdadParaMethod(int year, int edad) {
		assertTrue(prueba.obtenerEdadPara(year)==edad);
	}

	static Stream<Arguments> yearList(){
		return Stream.of(
				Arguments.of("2030","38"),
				Arguments.of("2031","39"),
				Arguments.of("2032","40")
				);
	}
	
}
