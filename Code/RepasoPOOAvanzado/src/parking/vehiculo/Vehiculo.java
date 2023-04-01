package parking.vehiculo;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public class Vehiculo implements Comparable<Vehiculo>{

	private String marca;
	private String modelo;
	private String matricula;
	private Combustible combustible;
	private LocalDateTime fechaEntrada;
	private Tipo tipo;
	public Vehiculo(String marca, String modelo, String matricula, String combustible,
			String tipo) throws VehiculoException {
		super();
		this.marca = marca;
		this.modelo = modelo;
		setMatricula(matricula);
		setCombustible(combustible);
		this.fechaEntrada = LocalDateTime.now();
		setTipo(tipo);
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws VehiculoException {
		
		if(matricula.matches("[a-zA-Z]{2}[0-9]{4}[a-zA-Z]{2}") || matricula.matches("[0-9]{4}[a-zA-Z]{3}")) {
			this.matricula = matricula.toUpperCase();
		}else throw new VehiculoException("El formato de la matricula no es valido");
		
	}
	
	public void setCombustible(String combustible) throws VehiculoException {
		try {
			this.combustible = Combustible.valueOf(combustible.toUpperCase());
		} catch (Exception e) {
			throw new VehiculoException("Ese tipo de combustible no existe");
		}
		
	}
	
	public void setTipo(String tipo) throws VehiculoException {
		try {
			this.tipo = Tipo.valueOf(tipo.toUpperCase());
		} catch (Exception e) {
			throw new VehiculoException("Ese tipo de vehiculo no existe");
		}
		
	}

	@Override
	public String toString() {
		return String.format("%s %s con matricula %s, entró el %s", marca, modelo, matricula,
				fechaEntrada);
	}

	@Override
	public int hashCode() {
		return Objects.hash(combustible, fechaEntrada, marca, matricula, modelo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual = this == obj;

		if (obj!=null && !esIgual && (obj instanceof Vehiculo vh)) {
			esIgual = combustible == vh.combustible && Objects.equals(fechaEntrada, vh.fechaEntrada)
					&& Objects.equals(marca, vh.marca) && Objects.equals(matricula, vh.matricula)
					&& Objects.equals(modelo, vh.modelo) && tipo == vh.tipo;
		}
		
		return esIgual;
	}

	@Override
	public int compareTo(Vehiculo o) {
		return this.marca.compareTo(o.marca);
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public Tipo getTipo() {
		return tipo;
	}


	
	
	
}
