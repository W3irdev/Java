package com.jacaranda.publicacion;

import com.jacaranda.Exception.PublicacionException;
import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion implements Valorable {

	private int numeroLecturas;
	private String tema;
	
	public Post(String texto, Usuario usuario, String tema) throws PublicacionException {
		super(texto, usuario);
		this.tema=tema;
		setTexto(texto);
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto!=null || !texto.isBlank()) {
			this.texto = texto;
		}else {
			throw new PublicacionException("El mensaje no puede estar en blanco");
		}
		
	}

	@Override
	public boolean valorar(String valoracion) {
		boolean valorado = false;
		if (Valoraciones.valueOf(valoracion) != null) {
			valorado = true;
			this.numeroLecturas++;
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
		return String.format("Post.\n"
				+ "Publicacion: %s \n"
				+ "Realizada por: %s \n"
				+ "Valoracion: %s \n"
				+ "Fecha de publicacion: %s \n",
				getTexto(), getLoginUsuario(), getValoracion(), getFechaCreacion());
	}

	public int getNumeroLecturas() {
		return numeroLecturas;
	}

	public String getTema() {
		return tema;
	}
	
	

	
	
	

}
