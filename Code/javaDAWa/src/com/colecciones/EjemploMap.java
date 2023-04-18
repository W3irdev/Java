package com.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EjemploMap {

	public static void main(String[] args) {
		
		Map<String, String> stockAlmacen = new HashMap<>();
		
		stockAlmacen.put("258963", "Jabon de baño");
		stockAlmacen.put("123123", "Raton de ordenador");
		stockAlmacen.put("234345", "Pantalla de ordenador");
		
		System.out.println(stockAlmacen.get("258963"));
		System.out.println(stockAlmacen.keySet());
		System.out.println(stockAlmacen.values());
		
		for(String k : stockAlmacen.keySet()) {
			System.out.println(k + ": " +stockAlmacen.get(k));
		}
		

		Map<String, Collection<String>> animalesPorCategoria = new HashMap<>();
		
		animalesPorCategoria.put("Mamiferos", new HashSet<>());
		animalesPorCategoria.get("Mamiferos").add("Leon");
		animalesPorCategoria.get("Mamiferos").add("Cabra");
		
		animalesPorCategoria.put("Reptiles", new ArrayList<>());
		animalesPorCategoria.get("Reptiles").add("Serpiente");
		animalesPorCategoria.get("Reptiles").add("Cocodrilo");
		
		System.out.println(animalesPorCategoria.get("Reptiles"));
		
		System.out.println(animalesPorCategoria.get("Artropodos"));
	}

}
