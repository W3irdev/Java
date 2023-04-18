package com.colecciones.boletin1.ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiccionarioTest {

	Diccionario dic = new Diccionario();
	
	@Test
	void testAddPalabra() {
		dic.addPalabra("diccionario", "Repertorio en forma de libro o en soporte "
				+ "electrónico en el que se recogen, según un orden determinado, "
				+ "las palabras o expresiones de una o más lenguas, o de una materia "
				+ "concreta, acompañadas de su definición, equivalencia o explicación.");
		
		
	}
	
	@Test
	void testAddPalabraB2() {
		dic.addPalabra("diccionario", "Repertorio en forma de libro o en soporte "
				+ "electrónico en el que se recogen, según un orden determinado, "
				+ "las palabras o expresiones de una o más lenguas, o de una materia "
				+ "concreta, acompañadas de su definición, equivalencia o explicación.");
	
		
		dic.addPalabra("diccionario", "Catálogo de noticias o datos de un mismo "
				+ "género, ordenado alfabéticamente. Diccionario bibliográfico, "
				+ "biográfico, geográfico.");
	
	}


	@Test
	void testSearchPalabra() {
		dic.addPalabra("diccionario", "Catálogo de noticias o datos de un mismo "
				+ "género, ordenado alfabéticamente. Diccionario bibliográfico, "
				+ "biográfico, geográfico.");
		
		dic.addPalabra("flamenco", "Relativo a Flandes, región del norte de Europa, o a sus habitantes.");
		dic.addPalabra("zalamero", "Que demuestra cariño de una forma exagerada y a veces empalagosa, generalmente para conseguir algo.");
		
		
		dic.searchPalabra("flamenco");
	}

	@Test
	void testBorrarPalabra() {
		dic.addPalabra("diccionario", "Catálogo de noticias o datos de un mismo "
				+ "género, ordenado alfabéticamente. Diccionario bibliográfico, "
				+ "biográfico, geográfico.");
		dic.borrarPalabra("diccionario");
	}

	@Test
	void testListarPalabras() {
		dic.addPalabra("flamenco", "Relativo a Flandes, región del norte de Europa, o a sus habitantes.");
		dic.addPalabra("zalamero", "Que demuestra cariño de una forma exagerada y a veces empalagosa, generalmente para conseguir algo.");
		dic.addPalabra("flanco", "texto");
		dic.addPalabra("flan", "texto");
		
		
		dic.listarPalabras("dic");

	}

}
