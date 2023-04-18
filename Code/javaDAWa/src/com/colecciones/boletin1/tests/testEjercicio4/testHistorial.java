package com.colecciones.boletin1.tests.testEjercicio4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.colecciones.boletin1.ejercicio4.model.Historial;
import com.colecciones.boletin1.ejercicio4.model.PaginaWeb;

class testHistorial {
	
	PaginaWeb web = new PaginaWeb("goologolo.es");
	PaginaWeb web2 = null;
	Historial h = new Historial();
	
	@Test
	void testAddPaginaOK() {
		assertThrows(Exception.class, ()->{h.addPagina(web);},"Hola");
	}

	@Test
	void testAddPaginaKO() {
		assertThrows(Exception.class, ()->{h.addPagina(web2);},"Hola");
	}
	
	@Test
	void testConsultarHistorial() {
		fail("Not yet implemented");
	}

	@Test
	void testConsultarHistorialLocalDateTime() {
		fail("Not yet implemented");
	}

	@Test
	void testBorrarHistorial() {
		assertThrows(Exception.class, ()->{h.borrarHistorial();},"Hola");
	}

	@Test
	void testBorrarHistorialPaginaWeb() {
		fail("Not yet implemented");
	}

}
