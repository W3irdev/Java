package com.jacaranda;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.jacaranda.memoryStorage.MemoryStorage;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MainTweeter {

	public static void main(String[] args) {
		MemoryStorage tweeter = new MemoryStorage();
		
		try {
			LocalDateTime horas = LocalDateTime.now();
			LocalDateTime futuro = LocalDateTime.now().plusDays(2);
			System.out.println(ChronoUnit.HOURS.between(horas, futuro));
			
			System.out.println(horas.getHour());
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
			pruebaValoracion.valorar("uybuena");
			System.out.println(pruebaValoracion);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}

}
