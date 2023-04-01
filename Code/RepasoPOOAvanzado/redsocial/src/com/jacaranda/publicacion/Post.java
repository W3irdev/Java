package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {

	private int numeroLecturas;
	private String tema;
	
	public Post(String texto, Usuario usuario, String tema) throws PublicacionException {
		super(texto, usuario);
		this.tema = tema;

	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto==null || texto.isBlank()) {
			throw new PublicacionException("El mensaje no puede estar vacío");
		}	
		this.texto = texto;
	}
	
	public int getNumeroLecturas() {
		return numeroLecturas;
	}

	public String getTema() {
		return tema;
	}

	public boolean valorar(String valoracion) {
		this.numeroLecturas++;
		return super.valorar(valoracion);
	}
	


}
