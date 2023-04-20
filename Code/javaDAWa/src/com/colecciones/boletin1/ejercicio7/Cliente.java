package com.colecciones.boletin1.ejercicio7;

import java.util.Objects;

public class Cliente {

	private int codCliente;

	public Cliente() {
		++codCliente;
	}
	
	

	public int getCodCliente() {
		return codCliente;
	}

	


	@Override
	public int hashCode() {
		return Objects.hash(codCliente);
	}



	@Override
	public boolean equals(Object obj) {
		boolean iguales = this == obj;
		
		if (obj!=null && !iguales && (obj instanceof Cliente c)) {
			iguales = codCliente == c.codCliente;
		}
		
		return iguales;
	}



	@Override
	public String toString() {
		return String.format("Es usted el cliente %s", codCliente);
	}
	
	
	
	
}
