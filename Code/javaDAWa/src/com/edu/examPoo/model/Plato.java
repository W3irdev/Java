package com.edu.examPoo.model;

import java.util.Objects;

public class Plato {
	
	private static final Exception valueError = new Exception("El precio debe ser mayor 0");
	private String nombre;
	private double precio;
	private static final double IVA=1.21;
	private Vino vinoRecomendado;
	

	
	
	public Plato(String nombre, double precio) {
		super();
		this.nombre = nombre;
		try {
			setPrecio(precio);
			vinoRecomendado = new Vino("Sin recomendaciones para el vino", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Plato(String nombre) {
		super();
		try {
			this.nombre = nombre;
			vinoRecomendado = new Vino("Sin recomendaciones para el vino", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double getIva() {
		return IVA;
	}
	
	public Vino getVinoRecomendado() {
		return vinoRecomendado;
	}

	public void setVinoRecomendado(Vino vinoRecomendado) {
		this.vinoRecomendado = vinoRecomendado;
	}
	
	public void setVinoRecomendado(Vino vinoRecomendado, double graduacion) {
		try {
			this.vinoRecomendado = new Vino(vinoRecomendado.getNombre(), graduacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	public double getGradosVinoRecomendado() {
		return vinoRecomendado.getGraduacion();
	}

	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioBase() {
		return precio;
	}
	
	public double getPrecioVentaPublico() {
		return precio*IVA;
	}

	public void setPrecio(double precio) throws Exception {
		if (precio>0) {
			this.precio = precio;
			
		}else {
			throw valueError;
		}
	}
	
	public void incrementaPrecio(double incremento) {
		if(incremento>0) {
			try {
				setPrecio(getPrecioBase()+incremento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean igual = this == obj;

		if (obj==null||!(obj instanceof Plato)) {
			igual = false;
		}
		Plato other = (Plato) obj;
		igual = Objects.equals(nombre, other.nombre);
		return igual;
	}

	@Override
	public String toString() {
		String vinoRecomendado = String.valueOf(this.vinoRecomendado.getNombre());
		if (vinoRecomendado==null||this.vinoRecomendado.getNombre().equals("")) {
			vinoRecomendado = "Sin recomendaciones para el vino";
			
		}
		return String.format(
				"El plato es %s, con un precio de %s, le recomendamos el vino, %s, con una graduacion de %s, el total a pagar seria %s",
				nombre, precio, vinoRecomendado, getGradosVinoRecomendado(), getPrecioVentaPublico());
	}
	
	
	

}
