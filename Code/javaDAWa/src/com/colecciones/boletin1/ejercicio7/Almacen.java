package com.colecciones.boletin1.ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Almacen {

	private List<Caja> caja;
	private static final int MAXIMO_CAJAS=20;

	public Almacen() {
		this.caja= new ArrayList<>();
		
		for(int i=0; i<MAXIMO_CAJAS; i++) {
			this.caja.add(new Caja(i, false));
		}
		
	} 
	
	public Almacen(List cajas) {
		this.caja= new ArrayList<>(cajas);
		
	}
	
	//Corregir, quien hace la accion es la propia caja (Realizar logica en clase caja)
	public void abrirCaja(int numeroCaja) {
		if(!caja.get(numeroCaja).isEstado()) {
			caja.get(numeroCaja).setEstado(true);
		}
	}
	
	//Corregir, quien hace la accion es la propia caja (Realizar logica en clase caja)
	public void cerrarCaja(int numeroCaja) {
		if(caja.get(numeroCaja).isEstado()) {
			caja.get(numeroCaja).setEstado(false);
		}
	}
	
	public void nuevoCliente() throws Exception {
		Cliente cliente = new Cliente();
		caja.sort(new CajaSizeComparator());
		caja.get(0).addCliente(cliente);
		
	}
	
	public void atenderCliente(int numCaja) throws Exception {
		if(numCaja<0 || numCaja>caja.size() || !caja.get(numCaja).isEstado() ) { //En el metodo antender de caja, esta la comprobacion de que haya clientes
			throw new Exception("La caja esta cerrada");
		}
		
		caja.get(numCaja).atenderCliente();
		
	}
	
	
	
}
