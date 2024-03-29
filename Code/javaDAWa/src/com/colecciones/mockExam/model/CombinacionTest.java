package com.colecciones.mockExam.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CombinacionTest {



	@Test
	void testComprobarCombinacion() {
		Combinacion c1;
		try {
			c1 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c2 = new Combinacion(2, 3, 4, 5, 6, 7, 8);
			Combinacion c3 = new Combinacion(12, 13, 14, 15, 16, 10, 9);
			assertTrue(c1.comprobarCombinacion(c2)==7);
			assertFalse(c1.comprobarCombinacion(c2)==2);
			assertFalse(c1.comprobarCombinacion(c3)==2);
			
		} catch (CombinacionException e) {
			assert(false);
		}
	}

}
