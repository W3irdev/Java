package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;
import com.jacaranda.usuario.Usuario;


public abstract class Publicacion implements Comparable<Publicacion>, Valorable {

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente;
	private Usuario usuario;
	
	
	public Publicacion(String texto, Usuario usuario) throws PublicacionException {
		super();
		this.usuario = usuario;
		setTexto(texto);
		this.fechaCreacion = LocalDateTime.now();
		this.codigo = codigoSiguiente++;
	}

	
	protected String getTexto() {
		return this.texto;
	}
	
	protected abstract void setTexto(String texto) throws PublicacionException;
	
	
	public int hashCode() {
		return Objects.hash(texto, fechaCreacion);
	}
	
	
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof Publicacion) {
			Publicacion otro = (Publicacion)obj;
			sonIguales = this.texto.equals(otro.texto) && obj.getClass().equals(this.getClass());
		}
		return sonIguales;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public int getValoracion() {
		return valoracion;
	}


	public int getCodigo() {
		return codigo;
	}
	
	
	public String getLoginUsuario() {
		return this.usuario.getLogin();
	}
	
	
	public String toString() {
		return String.format("%s"
							+ "Publicación: %s \n"
							+ "Realizada por: %s \n"
							+ "Valoración: %s \n"
							+ "Fecha de publicación: %s \n", 
							getClass().getSimpleName(),
							this.texto, 
							getLoginUsuario(), 
							this.valoracion, 
							this.fechaCreacion);
	}
	
	public int compareTo(Publicacion publicacion) {
		return this.valoracion==publicacion.valoracion?
				this.fechaCreacion.compareTo(publicacion.fechaCreacion):
					this.valoracion-publicacion.valoracion
				;
	}
	
	
	public boolean isAnterior(Publicacion pub) {
		return this.fechaCreacion.isBefore(pub.fechaCreacion);
	}
	
	public boolean valorar(String valoracion) {
		boolean resultado = false;
		try {
			Valoraciones v = Valoraciones.valueOf(valoracion.toUpperCase());
			valoracion+=v.getValoracion();
			resultado = true;
		}catch(Exception e) {
			
		}
		return resultado;
	}
	

}
