package com.jacaranda;

import com.jacaranda.memoryStorage.MemoryStorage;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MainTweeter {

	public static void main(String[] args) {
		MemoryStorage tweeter = new MemoryStorage();
		
		try {
			System.out.println(tweeter.mostrarListaPublicaciones());
			tweeter.addUsuario("Josemi", "hola");
			tweeter.addPublicacion("Prueba", "Josemi");
			System.out.println(tweeter.mostrarListaPublicaciones());
			tweeter.addPublicacion("Lo recomiendoLo recomiendoLo recomiendoLo recomiendo"
					+ "Lo recomiendoLo recomiendoLo recomiendoLo recomiendo"
					+ "Lo recomiendoLo ", "Josemi", 4);
			System.out.println(tweeter.mostrarRecomendacion());
			tweeter.addPublicacion("Prueba Post", "Josemi", "Eltema");
			System.out.println(tweeter.mostrarPosts());
			Usuario josemi = new Usuario("Josemi", "holai");
			Publicacion pruebaValoracion = new Tweet("Prueba Valoracion", josemi);
			System.out.println(pruebaValoracion);
			pruebaValoracion.valorar("MUYBUENA");
			System.out.println(pruebaValoracion);
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
