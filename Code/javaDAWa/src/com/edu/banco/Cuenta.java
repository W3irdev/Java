package com.edu.banco;

import java.util.Random;

public class Cuenta {

	private double saldo;
	private String nombreTitular;
	private long numeroCuenta;
	private int contadorIngresos;
	private int contadorReintegros;
	
	public Cuenta(String nombreTitular, double saldo) {
		
		this.saldo = saldo;
		this.nombreTitular=nombreTitular;
		contadorIngresos=0;
		contadorReintegros=0;
		
		Random rnd=new Random();
		numeroCuenta=Math.abs(rnd.nextLong());
	}
	
	public void setIngreso(double ingreso) {
		String mensaje = "No se permiten ingresos negativos";
		
		if (ingreso<0) {
			System.err.println(mensaje);
		}else {
			saldo+=ingreso;
			contadorIngresos++;
		}
	}
	
	public void setReintegro(double reintegro) {
		
		saldo-=reintegro;
		contadorReintegros++;
	}
	
	public int getContadorIngresos() {
		return contadorIngresos;
	}

	public int getContadorReintegros() {
		return contadorReintegros;
	}

	public String getSaldo() {
		return "El saldo de la cuenta es: " +saldo;
	}
	


}
