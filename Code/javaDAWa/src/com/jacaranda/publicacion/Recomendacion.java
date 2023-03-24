package com.jacaranda.publicacion;

import com.jacaranda.Exception.PublicacionException;
import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion{

	private int numeroEstrellas;
	
	public Recomendacion(String texto, Usuario usuario, int numEstrellas) throws PublicacionException {
		super(texto, usuario);
		this.numeroEstrellas = numEstrellas;
		if (numEstrellas>0 && numEstrellas < 6) {
			setTexto(texto);
		}
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length()>=100 && texto.length()<=200) {
			this.texto= texto;
		}else {
			throw new PublicacionException("El mensaje tiene que tener entre 100 y 200 caracteres y al menos una estrella.");
		}
		
	}

	@Override
	public String toString() {
		return String.format(
				"Recomendacion. \n"
				+ "Publicacion: %s \n"
				+ "Realizada por: %s \n"
				+ "Valoracion: %s \n"
				+ "Fecha de publicacion: %s \n"
				+ "Numero de estrellas: %s \n",
				getTexto(), getLoginUsuario(), getValoracion(), getFechaCreacion(), numeroEstrellas);
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	
	
}
