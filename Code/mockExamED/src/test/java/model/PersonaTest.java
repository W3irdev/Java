package test.java.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import main.java.model.Persona;

class PersonaTest {

	@Test
	void testPersonaStringStringStringOK() {
		try {
			Persona people = new Persona("Jose", "Cabrera", "47349821C");
			
		} catch (Exception e) {
			assert(false);
		}
		
	}
	
	@Test
	void testPersonaStringStringStringKO() {
		try {
			Persona people = new Persona("Jose", "Cabrera", "47349821A");
			
		} catch (Exception e) {
			assert(true);
		}
		
	}

	@Test
	void testPersonaStringStringStringLocalDateStringOK() {
		try {
			Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testPersonaStringStringStringLocalDateStringKO() {
		try {
			Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 97, 20), "HOMBRE");
		} catch (Exception e) {
			assert(true);
		}
	}

	@Test
	void testValidarDatosStringStringStringOK() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		assertTrue(people.validarDatos("Jose", "Cabrera", "47349821C"));
	}
	
	@Test
	void testValidarDatosStringStringStringKO() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		
		assertFalse(people.validarDatos("Jose", "Cabrera", "47349821A"));
	}

	@Test
	void testValidarDatosStringStringStringLocalDateStringOK() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		assertTrue(people.validarDatos("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE"));
	}
	
	@Test
	void testValidarDatosStringStringStringLocalDateStringKO() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		
		assertFalse(people.validarDatos("Jose", "Cabrera", "47349821A", LocalDate.of(1992, 07, 20), "HOMBRE"));
	}

	@Test
	void testBonoJovenDisponibleOK() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(2000, 07, 20), "HOMBRE");
		assertTrue(people.bonoJovenDisponible());
	}
	
	@Test
	void testBonoJovenDisponibleKO() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		
		assertFalse(people.bonoJovenDisponible());
	}

	@Test
	void testObtenerEdadOK() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		assertEquals(people.obtenerEdad(), 31);
	}
	
	@Test
	void testObtenerEdadKO() {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		
		assertEquals(people.obtenerEdad(), 29);
	}

	@ParameterizedTest
	@CsvSource({"2033,41","2043,51","2053,61"})
	void testObtenerEdadParaOK(int year, int edad) {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		assertEquals(people.obtenerEdadPara(year), edad);
		
	}
	
	@ParameterizedTest
	@CsvSource({"2033,43","2043,53","2053,63"})
	void testObtenerEdadParaKO(int year, int edad) {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		assertNotEquals(people.obtenerEdadPara(year), edad);
		
	}

	@ParameterizedTest
	@CsvFileSource(files = "files/source.csv")
	void testObtenerEdadParaOK2(int year, int edad) {
		Persona people = new Persona("Jose", "Cabrera", "47349821C", LocalDate.of(1992, 07, 20), "HOMBRE");
		assertEquals(people.obtenerEdadPara(year), edad);
		
	}
	
}
