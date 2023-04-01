package com.jacarandanotas.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota>{

	private static int codigoSiguiente;
	private int codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	/**
	 * @param Crea una nota con un texto
	 */
	public Nota(String texto) {
		super();
		this.texto = texto;
		this.fechaCreacion=LocalDateTime.now();
		this.codigo=codigoSiguiente++;
		
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public void setTexto(String texto) throws NotaAlarmaException {
		
		if(texto!=null && !texto.isEmpty()) {
			this.texto=texto;
		}else throw new NotaAlarmaException("Debe introducir un mensaje");
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaUltimaModificacion;
	}
	
	public boolean isModificado() {
		boolean modificado = false;
		if(this.fechaUltimaModificacion!=null) {
			modificado=true;
		}
		return modificado;
	}
	
	public boolean isEmpty() {
		boolean vacio=false;
		if(this.texto.isBlank()) {
			vacio=true;
		}
		return vacio;
	}
	
	public boolean isCreadoAnterior(Nota otra) {
		boolean anterior=false;
		if(this.getFechaCreacion().isBefore(otra.getFechaCreacion())) {
			anterior=true;
		}
		return anterior;
	}
	
	public boolean isModificadoAnterior(Nota otra) {
		boolean anterior=false;
		if(this.getFechaModificacion().isBefore(otra.getFechaModificacion())) {
			anterior=true;
		}
		return anterior;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual= this == obj;
		
		if (obj!=null && !esIgual && (obj instanceof Nota n)) {
			esIgual = codigo == n.codigo && Objects.equals(fechaCreacion, n.fechaCreacion)
					&& Objects.equals(texto, n.texto);
		}
		
		return esIgual;
	}

	@Override
	public String toString() {
		String modificacion = "";
		if(fechaUltimaModificacion!=null) {
			modificacion="Se modifico el " + fechaCreacion.toString();
		}
		return String.format("%s. Se creo el %s.", texto, fechaCreacion,
				modificacion);
	}

	@Override
	public int compareTo(Nota o) {
		
		return this.fechaCreacion.compareTo(o.fechaCreacion);
	}
	
	
	
	
}
