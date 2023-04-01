package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.Exception.PublicacionException;
import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable, Comparable<Publicacion>{

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente=0;
	private Usuario usuario;
	
	
	public Publicacion(String texto, Usuario usuario) {
		super();
		this.usuario = usuario;
		fechaCreacion = LocalDateTime.now();
		this.valoracion=0;
		this.codigo=codigoSiguiente++;
		
		
		
	}

	

	protected String getTexto() {
		return texto;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getLoginUsuario() {
		return this.usuario.getLogin();
	}

	protected abstract void setTexto(String texto) throws PublicacionException;
	
	

	public LocalDateTime getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	
	public int getValoracion() {
		return valoracion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}



	@Override
	public boolean equals(Object obj) {
		boolean esIgual = this == obj;
		
		if (obj != null && !esIgual && obj instanceof Publicacion) {
			Publicacion other = (Publicacion) obj;
			esIgual = this.codigo==other.codigo;
		}
		return esIgual;
	}



	@Override
	public boolean valorar(String valoracion) throws Exception {
		boolean valorado = false;
		if (Valoraciones.valueOf(valoracion) != null) {
			valorado = true;
			if (valoracion.equals("MUYBUENA")) {
				this.valoracion+=2;
			}else if (valoracion.equals("NORMAL")) {
				this.valoracion++;
			}else if (valoracion.equals("MUYMALA")){
				this.valoracion-=2;
			}
			
		}else throw new Exception("No existe ese tipo de valoracion");
		return valorado;
	}



	@Override
	public String toString() {
		return String.format("Publicacion : %s \n"
				+ "Realizada por: %s \n"
				+ "Valoracion: %s \n"
				+ "Fecha de publicacion: %s ",
				getTexto(), getLoginUsuario(), valoracion, fechaCreacion.toString());
	}
	
	public int compareTo(Publicacion pub) {
		int compare = 0;
		if(this.getValoracion()>pub.getValoracion()) {
			compare = 1;
		}else if(this.getValoracion()<pub.getValoracion()) {
			compare = -1;
		}else if(compare == 0) {
			compare = this.getFechaCreacion().compareTo(pub.getFechaCreacion());
		}
		
		return compare;
	}

	public boolean isAnterior(Publicacion pub) {
		
		return this.getFechaCreacion().isBefore(pub.getFechaCreacion());
	}
}
	
