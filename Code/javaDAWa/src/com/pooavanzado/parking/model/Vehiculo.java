package com.pooavanzado.parking.model;

import java.time.LocalDate;
import java.util.Objects;

import com.pooavanzado.parking.Exceptions.TipoNotExist;

public class Vehiculo implements Comparable<Vehiculo>{

	private String marca;
	private String modelo;
	private String matricula;
	private Combustible combustible;
	private LocalDate fechaEntrada;
	private Tipo tipo;
	
	
	public Vehiculo(String marca, String modelo, String matricula, String combustible, String fechaEntrada,
			String tipo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		setMatricula(matricula);
		try {
			setCombustible(combustible);
		} catch (TipoNotExist e) {
			
			e.printStackTrace();
		}
		this.fechaEntrada = LocalDate.of(Integer.valueOf(fechaEntrada.substring(6)), Integer.valueOf(fechaEntrada.substring(3,5)), Integer.valueOf(fechaEntrada.substring(0,2)));
		try {
			setTipo(tipo);
		} catch (TipoNotExist e) {
			
			e.printStackTrace();
		}
	}





	public void setMatricula(String matricula) {
		
		if(matricula.matches("[0-9]{4}[A-Z]{3}")||matricula.matches("[A-Z]{2}[0-9]{4}[A-Z]{2}")) {
			this.matricula=matricula;
		}
		
	}





	public void setCombustible(String combustible) throws TipoNotExist {
		try {
			
			this.combustible = Combustible.valueOf(combustible.toUpperCase());
		} catch (Exception e) {
			
			throw new TipoNotExist("Ese tipo de combustible no existe");
		}
	}





	public String getMarca() {
		return marca;
	}

	




	public String getMatricula() {
		return matricula;
	}





	public String getModelo() {
		return modelo;
	}





	public Tipo getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) throws TipoNotExist {
		try {
			this.tipo = Tipo.valueOf(tipo.toUpperCase());
			
		} catch (Exception e) {
			throw new TipoNotExist("Ese tipo de vehiculo no existe");
		}
	}





	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}





	@Override
	public int compareTo(Vehiculo o) {
		
		int compare;
		if(o!=null) {
			compare= this.fechaEntrada.compareTo(o.fechaEntrada);
		}else {
			compare=2;
		}
		
		return compare;
	}
	





	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}





	@Override
	public boolean equals(Object obj) {
		boolean igual= this == obj;
		

		if (!igual&&obj!=null&&(obj instanceof Vehiculo)) {
			Vehiculo other = (Vehiculo) obj;
			igual = other.matricula.equals(this.matricula);
		}
		return igual;
	}





	@Override
	public String toString() {
		return String.format("Vehiculo de la marca %s y modelo %s, con matricula %s, tipo %s y combustible %s, entro al parking el dia %s]",
				marca, modelo, matricula, tipo, combustible, fechaEntrada);
	}

	
	
	

}
