package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
		
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length()>50) {
			throw new PublicacionException("El mensaje no puede exceder los 50 caracteres");
		}		
		this.texto = texto;
	}
	
	
	public boolean valorar(String valoracion) {
		boolean resultado = false;
		try {
			Valoraciones v = Valoraciones.valueOf(valoracion.toUpperCase());
			valoracion+=v.getValoracion() * 2;
			resultado = true;
		}catch(Exception e) {
			
		}
		return resultado;
	}


}
