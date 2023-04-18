package com.mapas;

import java.util.*;

public class Mapeando {

	Set<Persona> gente = new HashSet<>();
	
	
	
	/**
	 * Recibe una colección de personas y las agrupa por género
	 * @param personas
	 * @return Mapa con la colección de personas clasificadas por género
	 */
	public Map<Genero, Collection<Persona>> mapearPersonasPorGenero(Collection<Persona> personas) {
		Map<Genero, Collection<Persona>> porGenero = new EnumMap<>(Genero.class);
		Set<Persona> iguales = new HashSet<>();
		Iterator<Persona> it = personas.iterator();
		Genero genero;
		
		while(it.hasNext()) {
			genero = it.next().getGenero();
			if(!porGenero.containsKey(genero)) {
				for(Persona p : personas) {
					if(p.getGenero().equals(genero)) {
						iguales.add(p);
					}
				}
				porGenero.put(genero, iguales);
			}
		}
		

		return porGenero;
	}
	
	
	/**
	 * Recibe una colección de números y cuenta cuantas ocurrencias hay de cada uno de ellos
	 * creando un mapa en el que aparece cada número junto a su frecuencia de aparición
	 * @param numeros
	 * @return Tabla de frecuencias de los números facilitados
	 */
	public Map<Integer, Integer> contarNumeros(Collection<Integer> numeros){
		//ToDo
		return null;
	}
	
	
	/**
	 * Genera una lista de números aleatorios entre 0 y 20 del tamaño indicado
	 * @param size tamaño de la lista
	 * @return lista de size números aleatorios
	 */
	public static Collection<Integer> generarNumerosAleatorios(int size){
		List<Integer> numeros = new ArrayList<>() {{
			for(int i=0; i<size; i++) {
				add(new Random().nextInt(0, 20));
			}
		}};
		
		return numeros;
	}
}
