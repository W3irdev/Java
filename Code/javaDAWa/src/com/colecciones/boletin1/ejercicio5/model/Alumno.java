package com.colecciones.boletin1.ejercicio5.model;

public class Alumno extends Persona {

	public Alumno(String nombre, int edad, String dni) {
		super(nombre, edad, dni);
	}

	@Override
	protected void enviarMensaje(Persona destinatario, String mensaje) throws Exception {

		if(this.edad<18 && !(destinatario instanceof Profesor)) {
			throw new Exception("No puede enviar mensajes a otros alumnos");
		}
		Mensaje enviar = new Mensaje(destinatario, mensaje);
		destinatario.chat.add(enviar);
	}

}
