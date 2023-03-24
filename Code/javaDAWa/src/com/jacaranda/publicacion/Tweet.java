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
	public boolean valorar(String valoracion) {
		boolean valorado = false;
		if (Valoraciones.valueOf(valoracion) != null) {
			valorado = true;
			if (valoracion.equals("MUYBUENA")) {
				this.valoracion+=4;
			}else if (valoracion.equals("NORMAL")) {
				this.valoracion+=2;
			}else if (valoracion.equals("MUYMALA")){
				this.valoracion-=4;
			}
			
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
