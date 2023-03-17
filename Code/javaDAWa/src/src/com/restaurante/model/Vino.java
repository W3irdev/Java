package src.com.restaurante.model;

import java.util.Objects;

public class Vino {
	
	private String nombre;
	private double graduacion;
	
	public Vino(String descripcion) {
		super();
		this.nombre=descripcion;
	}
	
	public Vino(String descripcion, double graduacion) throws Exception {
		this(descripcion);
		setGraduacion(graduacion);
	}
	
	
	private void setGraduacion(double graduacion) throws Exception {
		if(graduacion<0) {
			throw new Exception("No se puede asignar una graduación negativa");
		}
		this.graduacion=graduacion;
	}
	
	
	public double getGraduacion() {
		return graduacion;
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof Vino) {
			Vino casteado = (Vino)obj;
			sonIguales = Objects.equals(casteado.nombre, this.nombre);
		}
		
		
		return sonIguales;
	}
	
	@Override

	public String toString() {
		return String.format("Vino con nombre %s y graduación %s", 
						this.nombre, this.graduacion);
				
	}
	
	

}
