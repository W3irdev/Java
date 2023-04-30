package com.colecciones.boletin1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	
	private int numCaja;
	private boolean estado;
	private List<Cliente> cola;
	

	
	public Caja(int numCaja, boolean estado) {
		super();
		this.numCaja = numCaja;
		this.estado = estado;
		this.cola = new ArrayList<>();
	}
	
	public int getNumCaja() {
		return numCaja;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getSizeCaja() {
		return this.cola.size();
	}
	
	public void addCliente(Cliente c) throws Exception {
		if(c!=null && isEstado()) {
			cola.add(c);
		}else throw new Exception("La caja esta cerrada");
	}
	

	public void atenderCliente() throws Exception {
		if(this.cola.isEmpty()) throw new Exception("No hay clientes");
		cola.remove(0);
	}
}
