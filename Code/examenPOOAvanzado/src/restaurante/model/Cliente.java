package restaurante.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente implements Comparable<Cliente>{ 
	
	private Alergeno alergia;
	private LocalDate fechaNacimiento;
	private String codigoCliente;
	private Producto[] consumos;
	private final int MAX_PLATOS=10;
	private static int numeroCliente=0;
	private int consumoRealizado;
	

	public Cliente(LocalDate fechaNacimiento, Alergeno alergico) {
		super();
		this.codigoCliente = String.valueOf(numeroCliente++);
		this.consumos= new Producto[MAX_PLATOS];
		this.fechaNacimiento=fechaNacimiento;
		this.alergia = alergico;
	}


	public boolean solicitarServicio(Producto s) throws ServicioNoDisponibleException {

		
		if(s!=null && s instanceof Plato p) {
			if(this.alergia!=null && esAlergicoA(p.getAlegerno())) {
				throw new ServicioNoDisponibleException("El cliente es alergico ");
			}
			this.consumos[consumoRealizado++%MAX_PLATOS]=p;
		}else if (s!=null && s instanceof Bebida b) {
			if(b.esBebidaAlcoholica()&&!esMayorEdad()) {
				throw new ServicioNoDisponibleException("No se puede servir bebidas a menores");
			}
			
			this.consumos[consumoRealizado++%MAX_PLATOS]=b;
		}
		
		return false;
	}
	

	public int compareTo(Cliente otro) {
		return this.codigoCliente.compareTo(otro.codigoCliente);
	}
	

	public double calcularImporteConsumido() {
		double importe=0;
		
		for(Producto p:consumos) {
			if(p!=null) {
				
				importe+=p.getPrecioProducto();
			}
		}
		
		
		return importe;
	}
	

	public boolean esMayorEdad() {
		
		return getEdadActual()>=18 ;
	}
	

	public int getEdadActual() {
		LocalDate ahora = LocalDate.now();
		LocalDate nacimiento = this.fechaNacimiento;
		
		return (int) Math.abs(ChronoUnit.YEARS.between(ahora, nacimiento)) ;
	}
	
	public boolean esAlergicoA(Alergeno alergeno) {
		boolean esAlergico = false;
		if(alergeno!=null) {
			for(Alergeno g: alergeno.values()) {
				if(alergeno.equals(g)) {
					esAlergico=true;
				}
			}
		}
		return esAlergico;
	}
	

	public String getCodigoCliente() {
		return codigoCliente;
	}


	public boolean esBebedor() {
		boolean bebe=false;
		for(Producto p:consumos) {
			if(p instanceof Bebida) {
				((Bebida) p).esBebidaAlcoholica();
				bebe = true;
			}
		}
		return bebe;
	}


	@Override
	public String toString() {
		return String.format("Cliente con id %s ha consumido %s€", getCodigoCliente(),
				calcularImporteConsumido());
	}
	
	
	
}
