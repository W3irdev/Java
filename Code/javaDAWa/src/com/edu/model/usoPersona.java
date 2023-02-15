package com.edu.model;

public class usoPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona prueba = new Persona();
		System.out.println(prueba.getPeso());
		
		Profesor prof = new Profesor ("Jose Manuel", 40, "26668741M", 1.65, 72, "H");
		System.out.println(prof.getDepartamento());
	}

}
