package com.edu.jarras.model;

public class Jarra {
	
	private double capacidad;
	private double cantidad;
	private static double consumido;
	

	public Jarra() {
		super();
		this.capacidad = 0;
		this.cantidad = 0;
	}
	
	public Jarra(double capacidad) {
		this();
		setCapacidad(capacidad);
		setCantidad(0);
	}
	
	
	public void llenarJarra() {
		
		setCantidad(this.capacidad);
		consumido+=getCantidad();
	}
	
	public void vaciarJarra() {
		
		setCantidad(0);
	}

	public void volcarJarra(Jarra otraJarra) {
		
		double capacidadReal = otraJarra.capacidad-otraJarra.cantidad;
		double sobrante = this.cantidad-capacidadReal;
		double nuevaCantidad=capacidadReal-sobrante;
		if ((sobrante)<0) {
			otraJarra.setCantidad(otraJarra.capacidad+sobrante);
			
			setCantidad(0);
			consumido+=otraJarra.getCantidad();
		}else if (sobrante>0) {
			nuevaCantidad=capacidadReal+sobrante;
			if (nuevaCantidad>capacidadReal) {
				
				setCantidad(nuevaCantidad-capacidadReal);
				otraJarra.setCantidad(otraJarra.capacidad);
				consumido+=otraJarra.getCantidad();
			}	
		}
	}
	
	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		if (capacidad>0) {
			
			this.capacidad = capacidad;
		}
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		if (cantidad>0&&cantidad<=this.capacidad) {
			this.cantidad = cantidad;
		}
		
	}

	public static double getConsumido() {
		return consumido;
	}

	@Override
	public String toString() {
		return String.format("Jarra tiene una capacidad de %s, una cantidad de cantidad %s, y se ha gastado un total de %s litros", capacidad, cantidad, consumido);
	}
	
	
	

}
