package restaurante.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bebida extends Producto{

	private static final double IVA_BEBIDAS_ALC = 1.15;
	private double graduacion;
	
	
	public Bebida(String nombre, String descripcion, Alergeno alergeno, double precioBase, double graduacion) {
		super(nombre, descripcion, alergeno, precioBase);

		this.graduacion=graduacion;
		
	}


	@Override
	public double getPrecioProducto() {

		double precioProducto=0;
		
		if(esBebidaAlcoholica()) {
			precioProducto= this.precioBase*IVA_BEBIDAS_ALC;
		}else {
			precioProducto=this.precioBase*Producto.IVA_GENERAL;
		}
		
		return precioProducto;
	}

	public boolean esBebidaAlcoholica() {
		return this.graduacion>0;
	}

	@Override
	public boolean estaCaducado() {
		return false;
	}


	@Override
	public String toString() {
		return String.format("%s \n"
				+ "Graduacion: %s ", super.toString(), graduacion);
	}
	
	
	
	
	

}
