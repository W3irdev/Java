package com.colecciones.boletin1.ejercicio5.model;

public class Profesor extends Persona {

	public Profesor(String nombre, int edad, String dni) {
		super(nombre, edad, dni);
	}

	@Override
	protected void enviarMensaje(Persona destinatario, String mensaje) {

		Mensaje enviar = new Mensaje(this, mensaje);
		destinatario.chat.add(enviar);
		
	}



}
