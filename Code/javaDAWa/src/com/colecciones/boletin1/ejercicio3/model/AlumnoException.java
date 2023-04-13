package com.colecciones.boletin1.ejercicio3.model;

public class AlumnoException extends Exception {

	public AlumnoException() {
		super("El alumno ya existe");
	}

	public AlumnoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


}
