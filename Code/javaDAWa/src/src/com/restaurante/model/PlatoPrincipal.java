package src.com.restaurante.model;

public class PlatoPrincipal extends Plato {
	
	private String acompanamiento;

	public PlatoPrincipal(String nombre) {
		super(nombre);
		this.acompanamiento="No hay acompañamiento";
	}

	public PlatoPrincipal(String nombre, double precio, Vino vinoRecomendado, String acompanamiento) {
		super(nombre, precio);
		
		this.acompanamiento = acompanamiento;
	}

	public String getAcompanamiento() {
		return this.acompanamiento;
	}
	
	public void setAcompanamiento(String acompanamiento) {
		
	}

	@Override
	public String toString() {
	
		
		return String.format("%s trae ademas de acompañamiento %s",super.toString(), getAcompanamiento()  ) ;
	}
	
	
	
	
}
