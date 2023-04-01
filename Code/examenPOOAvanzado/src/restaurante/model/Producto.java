package restaurante.model;

import java.time.LocalDate;

public abstract class Producto{

	protected static final double IVA_GENERAL=1.07;
	protected LocalDate fechaAltaMenu;
	protected LocalDate fechaBajaMenu;
	protected String nombre;
	protected String descripcion;
	protected Alergeno alergeno;
	protected double precioBase;
	protected String codigoProducto;
	protected static int secuenciaProducto;
	
	

	
	

	
	public Producto(String nombre, String descripcion, Alergeno alergeno, double precioBase) {
		super();
		this.codigoProducto = String.format("%s%s", getClass().getSimpleName(), String.valueOf(secuenciaProducto++) );
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alergeno = alergeno;
		this.precioBase = precioBase;
		this.fechaAltaMenu = LocalDate.now();
	}



	public Alergeno getAlegerno() {
		return alergeno;
	}



	public abstract double getPrecioProducto();



	public LocalDate getFechaBajaMenu() {
		return fechaBajaMenu;
	}



	public void setFechaBajaMenu(LocalDate fechaBajaMenu) {
		this.fechaBajaMenu = fechaBajaMenu;
	}
	
	public abstract boolean estaCaducado();



	public String getCodigoProducto() {
		return codigoProducto;
	}



	@Override
	public String toString() {
		
		String presenta = getAlegerno()!=null?"S":"N";
		LocalDate preferente = this.fechaAltaMenu.plusDays(15);
		
		return String.format(
				"%s: %s \n"
				+ "Precio: %s \n"
				+ "Presenta alergenos: %s ",
				getClass().getSimpleName(), this.nombre ,getPrecioProducto(), presenta);
	}
	
	
	
	
}
