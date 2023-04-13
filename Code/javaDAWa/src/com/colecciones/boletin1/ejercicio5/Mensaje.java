package com.colecciones.boletin1.ejercicio5;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje {

	private Persona remitente;
	private String texto;
	private LocalDateTime envio;
	
	public Mensaje(Persona remitente, String texto) {
		super();
		this.remitente = remitente;
		this.texto = texto;
		this.envio = LocalDateTime.now();
	}

	public Persona getRemitente() {
		return remitente;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDateTime getEnvio() {
		return envio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(envio, remitente, texto);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual= this == obj;

		if (obj!=null && !esIgual &&(obj instanceof Mensaje ms)) {
			esIgual = this.hashCode()==ms.hashCode();
		}
		
		return esIgual;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s]", remitente, texto, envio);
	}
	
	
	
	
	
}
