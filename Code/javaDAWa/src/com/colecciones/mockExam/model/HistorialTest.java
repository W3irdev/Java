package com.colecciones.mockExam.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class HistorialTest {

	Historial h1 = new Historial();
	int[] combinacion1 = {2,3,4,5,6};
	int[] combinacion2 = {7,8};


	@Test
	void testAddSorteoIntIntIntCombinacion() {
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			assertTrue(h1.addSorteo(22, 04, 2023, c1));
		} catch (HistorialException | CombinacionException e) {
			assert(false);
		}
		
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			assertFalse(h1.addSorteo(22, 04, 2023, c1));
			assertFalse(h1.addSorteo(0, 0, 0, null));
		} catch (HistorialException | CombinacionException e) {
			assert(true);
		}
	}

	@Test
	void testActualizarSorteoIntIntIntCombinacion() {
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			h1.addSorteo(22, 04, 2023, c1);
			assertTrue(h1.actualizarSorteo(22, 04, 2023, c2));
		} catch (HistorialException | CombinacionException e) {
			assert(false);
		}
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			assertFalse(h1.actualizarSorteo(21, 04, 2023, c2));
			
		} catch (CombinacionException e) {
			assert(false);
		}
	}

	@Test
	void testBorrarSorteo() {
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			h1.addSorteo(22, 04, 2023, c1);
			assertTrue(h1.borrarSorteo(LocalDate.of(2023, 04, 22)));
		} catch (HistorialException | CombinacionException e) {
			assert(false);
		}
		assertFalse(h1.borrarSorteo(LocalDate.of(2023, 04, 22)));
		
	}

	@Test
	void testListarSorteosDesdeFecha() {
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			h1.addSorteo(22, 04, 2023, c1);
			h1.addSorteo(23, 04, 2023, c2);
			assertTrue(!h1.listarSorteosDesdeFecha(LocalDate.of(2023, 04, 22)).isEmpty());
			
		} catch (HistorialException | CombinacionException e) {
			assert(false);
		}
		
		assertTrue(h1.listarSorteosDesdeFecha(LocalDate.of(2024, 04, 22)).isEmpty());
	}

	@Test
	void testMostrarHistorico() {
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			h1.addSorteo(22, 04, 2023, c1);
			h1.addSorteo(23, 04, 2023, c2);
			assertTrue(!h1.mostrarHistorico().isEmpty());
		} catch (HistorialException | CombinacionException e) {
			assert(false);
		}
	}

	@Test
	void testMostrarHistoricoFail() {
		assertTrue(h1.mostrarHistorico().isEmpty());
	}
	
	@Test
	void testComprobarAciertos() {
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			h1.addSorteo(22, 04, 2023, c1);
			h1.addSorteo(23, 04, 2023, c2);
			assertTrue(h1.comprobarAciertos(LocalDate.of(2023, 04, 22), c1).equals(h1.comprobarAciertos(LocalDate.of(2023, 04, 22), c2)));
			
		} catch (HistorialException | CombinacionException e) {
			assert(false);
		}
		
		try {
			Combinacion c1 = new Combinacion(combinacion1, combinacion2);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			assertFalse(h1.comprobarAciertos(LocalDate.of(2023, 04, 22), c1).equals(h1.comprobarAciertos(LocalDate.of(2023, 04, 23), c3)));
		} catch (HistorialException | CombinacionException e) {
			assert(true);
		}
	}

}
