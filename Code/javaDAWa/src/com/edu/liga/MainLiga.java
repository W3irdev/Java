package com.edu.liga;

import com.edu.liga.model.Equipo;
import com.edu.liga.model.Partido;

public class MainLiga {

	public static void main(String[] args) {
		Equipo local = new Equipo ("Betis", "Benito Villamarin","Sevilla");
		Equipo visitante = new Equipo ("Sevilla", "Ramon Sanchez-Pizjuan","Sevilla");
		Partido partido = new Partido(local, visitante);
		
		partido.ponerResultado("2-1");
		System.out.println(partido);
		
		try {
			
			Partido partido2 = new Partido(local, visitante);
			partido2.ponerResultado("X-0");
			
			Partido partido3 = new Partido(local, visitante);
			partido3.ponerResultado("1-2");
			
		}catch (Exception e) {
			Partido partido2 = new Partido(local, visitante);
			partido2.ponerResultado("1-0");
			System.out.println(partido2);
		}
		
		
		
	}

}
