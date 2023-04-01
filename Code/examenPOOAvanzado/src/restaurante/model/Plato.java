package restaurante.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Plato extends Producto {
	
	protected LocalDate fechaConsumoPreferente;

	public Plato(String nombre, String descripcion, Alergeno alergeno, double precioBase) {
		super(nombre, descripcion, alergeno, precioBase);
		
	}
	
	public LocalDate getFechaConsumoPreferente() {
		return this.fechaConsumoPreferente;
	}

	
	public void setFechaConsumoPreferente() {
		this.fechaConsumoPreferente = this.fechaAltaMenu.plusDays(15);
	}
	
	@Override
	public double getPrecioProducto() {
		return this.precioBase*Producto.IVA_GENERAL;
	}

	@Override
	public boolean estaCaducado() {
		
		/*LocalDate ahora = LocalDate.now();
		LocalDate antes = this.fechaAltaMenu;
		ChronoUnit.DAYS.between(ahora, antes)>15?true:false;*/
		
		return LocalDate.now().isAfter(fechaConsumoPreferente);

	}

	@Override
	public String toString() {
		return String.format("%s \n"
				+ "Fecha de consumo preferente: %s \n"
				+ "Ingredientes: %s ", super.toString(), this.fechaConsumoPreferente, this.descripcion);
	}

	
	
	
	
}
