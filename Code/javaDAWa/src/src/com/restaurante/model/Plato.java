package src.com.restaurante.model;

import java.util.Objects;

import src.com.restaurante.exception.PriceNotValidException;

public class Plato {
	
	
	private Vino vinoRecomendado;
	private String nombre;
	private double precio;
	
	private static double iva = 0.21;
	
	
	public Plato(String nombre) {
		super();
		this.nombre=nombre;
	}
	
	
	public Plato(String nombre, double precio) {
		this(nombre);
		setPrecio(precio);
	}

	
	
	
	public String getNombre() {
		return nombre;
	}


	public void setPrecio(double precio) {
		if(precio <=0) {
			throw new PriceNotValidException();
		}
		this.precio=precio;
	}
	
	public double getPrecioVentaPublico() {
		return this.precio+this.precio*iva;
	}

	public String getVinoRecomendado() {
		String descripcion = "Sin recomendaciones para el vino";
		if(vinoRecomendado != null) {
			descripcion = vinoRecomendado.toString();
		}
		
		return descripcion;
	}


	public void setVinoRecomendado(Vino vinoRecomendado) {
		this.vinoRecomendado = vinoRecomendado;
	}
	
	public void setVinoRecomendado(String nombre, double graduacion) throws Exception {
		Vino vino = new Vino(nombre, graduacion);
		setVinoRecomendado(vino);
	}
	
	public void incrementarPrecio(double incremento) {
		this.precio+=incremento;
	}

	
	public double getGraduacionVinoRecomendado() {
		return vinoRecomendado!=null? vinoRecomendado.getGraduacion():0.0;
	}

	public static double getIva() {
		return iva;
	}
	
	
	
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof Plato) {
			Plato casteado = (Plato)obj;
			
			sonIguales = 
					this.nombre!=null && casteado.nombre!=null &&
					this.nombre.equalsIgnoreCase(casteado.nombre);
			//alternativamente
			sonIguales = Objects.equals(casteado.nombre, this.nombre);
		}
		
		
		return sonIguales;
	}

	
	@Override
	public String toString() {
		return String.format("Plato con nombre %s, precio sin iva %s,"
				+ " pvp %s y %s", 
				
				this.nombre, this.precio, getPrecioVentaPublico(), getVinoRecomendado());
	}
	
	

}
