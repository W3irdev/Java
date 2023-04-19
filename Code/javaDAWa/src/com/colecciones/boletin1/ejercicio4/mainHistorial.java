package com.colecciones.boletin1.ejercicio4;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.colecciones.boletin1.ejercicio4.model.Historial;
import com.colecciones.boletin1.ejercicio4.model.PaginaWeb;

public class mainHistorial {

	public static void main(String[] args) {

		Historial historia = new Historial();
		
		PaginaWeb web1 = new PaginaWeb("goologolo.es");
		PaginaWeb web2 = new PaginaWeb("yiahuu.es", LocalDateTime.now());
		PaginaWeb web3 = new PaginaWeb("chatGPT.es", LocalDateTime.now().plusDays(2));
		
		try {
			historia.addPagina(web1);
			historia.addPagina(web2);
			historia.addPagina(web3);
			
			System.out.println(historia);
			
			System.out.println(historia.consultarHistorial());
			System.out.println(historia.consultarHistorial(LocalDate.now()));
			
			historia.borrarHistorial();
			System.out.println(historia);
			
			historia.addPagina(web1);
			historia.addPagina(web2);
			historia.addPagina(web3);
			
			System.out.println(historia);
			
			historia.borrarHistorial("chatGPT.es");
			
			System.out.println(historia);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
