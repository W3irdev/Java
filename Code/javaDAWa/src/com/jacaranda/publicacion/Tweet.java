package com.jacaranda.publicacion;

import com.jacaranda.Exception.PublicacionException;
import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion implements Valorable {

	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
		setTexto(texto);
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length()<=50) {
			this.texto = texto;
		}else throw new PublicacionException("El mensaje tiene que tener como maximo 50 caracteres");
		
	}

	@Override
	public boolean valorar(String valoracion) throws PublicacionException {
		boolean valorado = false;
		try {
			if (Valoraciones.valueOf(valoracion.toUpperCase()) != null) {
				valorado = true;
				if (valoracion.equalsIgnoreCase("MUYBUENA")) {
					this.valoracion+=4;
				}else if (valoracion.equalsIgnoreCase("NORMAL")) {
					this.valoracion+=2;
				}else if (valoracion.equalsIgnoreCase("MUYMALA")){
					this.valoracion-=4;
				}
				
			}
			
		} catch (IllegalArgumentException e) {
			throw new PublicacionException("No existe la valoracion");
		}
		
		return valorado;
		
	}

	@Override
	public String toString() {
		return String.format("Tweet. \n"
				+ "Publicacion: %s \n"
				+ "Realizada por: %s \n"
				+ "Valoracion: %s \n"
				+ "Fecha de publicacion: %s \n",
				getTexto(), getLoginUsuario(), getValoracion(), getFechaCreacion());
	}

	
}
