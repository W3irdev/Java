package com.mapas;

import java.util.HashSet;
import java.util.Set;

public class mainMapeando {

	public static void main(String[] args) {

		
		Persona p1 = new Persona ("ana", "lopez", Genero.FEMENINO);
        Persona p2 = new Persona ("jose", "perez", Genero.MASCULINO);
        Persona p3 = new Persona ("CARMEN", "garcia", Genero.FEMENINO);
        Persona p4 = new Persona ("pablo", "sanchez", Genero.MASCULINO);
        Persona p5 = new Persona ("NUL", "fernandez", Genero.NEUTRO);
        Persona p6 = new Persona ("acac", "pineda", Genero.DESCONOCIDO);
        Persona p7 = new Persona ("rober", "williams", Genero.NEUTRO);
        Set<Persona> lista = new HashSet<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        
        System.out.println(Mapeando.mapearPersonasPorGenero(lista));
        
		
		
	}

}
