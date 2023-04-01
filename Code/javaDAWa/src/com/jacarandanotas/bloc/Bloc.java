package com.jacarandanotas.bloc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import com.jacarandanotas.notas.Nota;
import com.jacarandanotas.notas.NotaAlarma;
import com.jacarandanotas.notas.NotaAlarmaException;

public class Bloc{

	private static final int NUMERO_NOTAS_MAXIMA=5;
	private int numeroNotas;
	private String nombre;
	private Nota[] notas;
	
	/**
	 * @param nombre
	 */
	public Bloc(String nombre) {
		super();
		this.nombre = nombre;
		notas= new Nota[NUMERO_NOTAS_MAXIMA];
	}
	
	public String getNota(int numero) {
		String nota="No existe nota";
		
		if(notas[numero]!=null && numero>=0 && numero <=NUMERO_NOTAS_MAXIMA) {
			nota=notas[numero].getTexto();
		}
		
		return nota;
	}
	
	public void updateNota(int numeroNota, String nuevoTexto) throws NotaAlarmaException, BlocException {
		
		if(notas[numeroNota]!=null && nuevoTexto!=null && numeroNota>=0 && numeroNota <=NUMERO_NOTAS_MAXIMA) {
			notas[numeroNota].setTexto(nuevoTexto);
		}else if (notas[numeroNota]==null && nuevoTexto!=null && numeroNota>=0 && numeroNota <=NUMERO_NOTAS_MAXIMA) {
			notas[numeroNota]=new Nota(nuevoTexto);
			this.numeroNotas++;
			
		}else throw new BlocException();
		
	}
	
	public void activa(int numeroNota) throws BlocException, NotaAlarmaException {
		String mensaje;
		
		if(notas[numeroNota]!=null && numeroNota>=0 && numeroNota <=NUMERO_NOTAS_MAXIMA) {
			mensaje = notas[numeroNota].getTexto();
			notas[numeroNota]=new NotaAlarma(mensaje, LocalDateTime.now(), true);
			
			
		}else throw new BlocException("Esa nota no es alarma");
	}
	
	public void desactiva(int numeroNota) throws BlocException {
		
		if(notas[numeroNota]!=null && numeroNota>=0 && numeroNota <=NUMERO_NOTAS_MAXIMA && notas[numeroNota] instanceof NotaAlarma na) {
			
			na.desactivar();
			
		}else throw new BlocException("Esa nota no es alarma");
	}

	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Nota n:notas) {
			if(n!=null) {
				sb.append(n);
			}
		}
		
		return String.format("El bloc %s contiene %s notas y son: %s", nombre, numeroNotas, sb.toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual= this == obj;

		if (obj!=null && !esIgual && (obj instanceof Bloc b)) {
			esIgual= Objects.equals(nombre, b.nombre);
		}
		return esIgual;
	}
	
	public String ordenaBloc() {
		StringBuilder sb = new StringBuilder();
		
		for(Nota n:notas) {
			if(n!=null) {
				sb.append(n);
			}
		}
		
		return sb.toString();
	}
	
	
}
