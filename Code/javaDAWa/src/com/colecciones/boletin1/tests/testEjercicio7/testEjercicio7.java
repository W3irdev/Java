package com.colecciones.boletin1.tests.testEjercicio7;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.colecciones.boletin1.ejercicio7.Almacen;
import com.colecciones.boletin1.ejercicio7.Caja;

class testEjercicio7 {

	Almacen mercadona = new Almacen();
	List<Caja> cajas;
	Almacen dia;
	
	@Test
	void testAbrirCajaOK() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		dia.abrirCaja(0);
		assertTrue(cajas.get(0).isEstado());
	}
	
	@Test
	void testAbrirCajaKO() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, true));
		dia = new Almacen(cajas);
		dia.abrirCaja(0);
		assertTrue(cajas.get(0).isEstado());
	}

	@Test
	void testCerrarCajaOK() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, true));
		dia = new Almacen(cajas);
		dia.cerrarCaja(0);
		assertFalse(cajas.get(0).isEstado());
	}
	
	@Test
	void testCerrarCajaKO() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		dia.cerrarCaja(0);
		assertFalse(cajas.get(0).isEstado());
	}

	@Test
	void testNuevoClienteOK() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		dia.abrirCaja(0);
		try {
			dia.nuevoCliente();
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testNuevoClienteKO() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		try {
			dia.nuevoCliente();
		} catch (Exception e) {
			assert(true);
		}
	}

	@Test
	void testAtenderClienteOK() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		dia.abrirCaja(0);
		try {
			dia.nuevoCliente();
			dia.atenderCliente(0);
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testAtenderClienteKO() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		try {
			dia.nuevoCliente();
			dia.atenderCliente(0);
		} catch (Exception e) {
			assert(true);
		}
	}

	@Test
	void testAtenderClienteMayorCaja() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		dia.abrirCaja(0);
		try {
			dia.nuevoCliente();
			dia.atenderCliente(21);
		} catch (Exception e) {
			assert(false);
		}
	}
	
	@Test
	void testAtenderClienteMenorCaja() {
		cajas = new ArrayList<>();
		cajas.add(new Caja(0, false));
		dia = new Almacen(cajas);
		dia.abrirCaja(0);
		try {
			dia.nuevoCliente();
			dia.atenderCliente(-5);
		} catch (Exception e) {
			assert(false);
		}
	}
	
}
