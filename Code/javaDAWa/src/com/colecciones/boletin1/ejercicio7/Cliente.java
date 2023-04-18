package com.colecciones.boletin1.ejercicio7;

public class Cliente {

	private int codCliente;

	public Cliente() {
		codCliente++;
	}
	
	

	public int getCodCliente() {
		return codCliente;
	}



	@Override
	public String toString() {
		return String.format("Es usted el cliente %s", codCliente);
	}
	
	
	
	
}
