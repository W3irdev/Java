package com.jacarandanotas.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable{

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, boolean activar) throws NotaAlarmaException {
		super(texto);

		setFechaAlarma(fechaAlarma);
		
		this.activado=activar;
		
		if(activar==true) {
			this.minutosRepetir=MINUTOS_REPETIR_POR_DEFECTO;
		}
		
	}
	
	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int repetirCada) throws NotaAlarmaException {
		super(texto);

		setFechaAlarma(fechaAlarma);
		activar();
		this.minutosRepetir=repetirCada;
		
	}

	private void setFechaAlarma(LocalDateTime fecha) throws NotaAlarmaException {
		if(fecha!=null) {
			this.fechaAlarma=fecha;
			
		}else throw new NotaAlarmaException();
		
	}
	

	@Override
	public void activar() {

		this.activado=true;
	}

	@Override
	public void desactivar() {
		this.activado=false;	
		
	}

	public boolean isActivado() {
		return this.activado;
	}

	@Override
	public String toString() {
		String activado="no esta activado.";
		if(this.isActivado()) {
			activado="esta activado";
		}
		
		return String.format("%s , sonara a %s, se recordara cada %s, y %s", super.toString(), fechaAlarma, minutosRepetir,
				activado);
	}
	
	
	
}
