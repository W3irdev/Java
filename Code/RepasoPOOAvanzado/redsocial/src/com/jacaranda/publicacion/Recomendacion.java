package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {
	
	private int numeroEstrellas;

	public Recomendacion(String texto, Usuario usuario, int estrellas) throws PublicacionException {
		super(texto, usuario);
		if(estrellas <1 || estrellas > 5) {
			throw new PublicacionException("El número de estrellas no es correcto.");
		}
		this.numeroEstrellas = estrellas;
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length()<100 || texto.length()>200) {
			throw new PublicacionException("La longitud no es válida.");
		}	
		this.texto = texto;
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	@Override
	public String toString() {
		return String.format("%s \n Número de estrellas: %s",
							super.toString(), this.numeroEstrellas);
	}
	
}
