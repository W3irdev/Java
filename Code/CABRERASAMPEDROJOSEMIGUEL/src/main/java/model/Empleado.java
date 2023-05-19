package main.java.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import main.java.model.exceptions.EmpleadoException;

public class Empleado implements Comparable<Empleado>{

	private String nombreCompleto;
	private String codigoEmpleado;
	private String fechaNacimiento;
	private Rol rol;
	
	
	public Empleado() {
		super();
	}
	
	
	public Empleado(String nombreCompleto, String codigoEmpleado, String fechaNacimiento, Rol rol) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.codigoEmpleado = codigoEmpleado;
		this.fechaNacimiento = fechaNacimiento;
		this.rol = rol;
	}




	
	//Cambia el rol si es diferente al actual, si no es posible lanza excepción
	public void modificarRol(Rol rol) throws EmpleadoException {
		if(this.rol.equals(rol)) {
			throw new EmpleadoException("El rol coincide");
		}
		this.rol=rol;
	}
	
	public boolean contieneNombre(String nombre) {
		return this.nombreCompleto.contains(nombre);
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigoEmpleado);
	}
	

	@Override
	public boolean equals(Object obj) {
		return this==obj ||obj!=null && obj instanceof Empleado && obj.hashCode()==this.hashCode();
	}


	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	
	public int getEdad() {
		return (int)ChronoUnit.YEARS.between(
					LocalDate.parse(this.fechaNacimiento, DateTimeFormatter.ISO_DATE),
					LocalDate.now());
	}
	
	


	public Rol getRol() {
		return rol;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	@Override
	public String toString() {
		return String.format("%s,%s", codigoEmpleado, nombreCompleto);
	}


	@Override
	public int compareTo(Empleado o) {
		return this.getEdad()-o.getEdad();
	}
	
	
	
	
	
}
