package com.colecciones.boletin1.ejercicio5;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class Persona {

	protected String nombre;
	protected int edad;
	protected String dni;
	protected List<Mensaje> chat;
	protected int codMensaje;
	
	
	protected Persona(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		chat = new ArrayList<>();

	}

	protected abstract void enviarMensaje(Persona destinatario, String mensaje) throws Exception;
	
	public String leerMensajes() {
		StringBuilder sb = new StringBuilder();
		
		for (Mensaje mensaje : chat) {
			if(mensaje!=null) {
				sb.append(String.format("Mensaje %s: %n"
									  + "De: %s %n"
									  + "Texto: %s %n"
									  + "Fecha y hora: %s", 
									  ++codMensaje, mensaje.getRemitente(), mensaje.getTexto(), mensaje.getEnvio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
			}
		}
		
		return sb.toString();
		
	}
	
	public String leerMensajesOrdenados() {
		chat.sort(new RemitenteAlfabeticoComparator());
		return leerMensajes();
	}
	
	public void borrarMensaje(int numMensaje) throws Exception {
		if(numMensaje<0 || numMensaje >= chat.size() || chat.get(numMensaje)==null) throw new Exception("El mensaje no existe");
		chat.remove(numMensaje);
		
	}
	
	public String buscarMensaje(String frase) throws Exception {
		StringBuilder sb = new StringBuilder();
		Iterator<Mensaje> it = chat.iterator();
		boolean encontrado=false;
		String mensaje;
		while(it.hasNext()) {
			mensaje=it.next().getTexto();
			if(mensaje.contains(frase)) {
				sb.append(mensaje+"\n");
			}
		}
		if (sb.isEmpty()) throw new Exception("No se encuentran coincidencias.");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual= this == obj;

		if (obj!=null && !esIgual &&(obj instanceof Persona p)) {
			esIgual = this.hashCode()==p.hashCode();
		}
		
		return esIgual;
	}

	@Override
	public String toString() {
		return String.format("%s %s", nombre, dni);
	}
	
	
	
	
	
	
	
}
