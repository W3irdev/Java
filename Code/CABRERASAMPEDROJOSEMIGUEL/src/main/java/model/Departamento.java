package main.java.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import main.java.model.exceptions.DepartamentoException;
import main.java.model.exceptions.EmpleadoException;

public class Departamento {

	private Set<Empleado> empleados;
	private String codigoDepartamento;
	
	public Departamento() {
		super();
		empleados=new HashSet<>();
	}
	
	public Departamento(String codigoDepartamento) {
		this();
		this.codigoDepartamento=codigoDepartamento;
	}
	
	
	//Añade un empleado a la colección de empleados. Si ya existe o no es posible se lanzará excepción
	public void addEmpleado(Empleado empleado) throws DepartamentoException{
		if(this.empleados.contains(empleado)) {
			throw new DepartamentoException("Ese empleado ya existe");
		}
		this.empleados.add(empleado);
		
	}
	

	//Cambia el rol al empleado cuyo código coincide con el indicado.
	//Lanza excepción si el empleado no existe, o bien, no se puede cambiar su rol
	public void cambiarRolAEmpleado(String codigoEmpleado, Rol rol) throws DepartamentoException, EmpleadoException{
		Iterator<Empleado> it = this.empleados.iterator();
		boolean encontrado = false;

		while(it.hasNext() && !encontrado) {
			Empleado empleado = it.next();
			if(empleado.getCodigoEmpleado().equals(codigoEmpleado)) {
				empleado.modificarRol(rol);
				encontrado=true;
			}
		}
	}
	
	public Collection<String> obtenerEmpleadosConNombre(String nombre){
		//Set, no podemos repetir empleados.
		List<Empleado> ordenados = new ArrayList<>(this.empleados);
		Set<String> empleados = new HashSet<>();
		Collections.sort(ordenados);
		for(Empleado e:ordenados) {
			if(e.contieneNombre(nombre)) {
				empleados.add(e.toString());
			}
		}
		return empleados;
	}
	
	
	
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public Set<Empleado> getEmpleados(){
		return this.empleados;
	}
	

	public String empleadosToString() {
		StringBuilder sb = new StringBuilder();
		for(Empleado e : this.empleados) {
			sb.append(e+"\n");
		}
		return sb.toString();
	}
	
	
	@Override
	public String toString() {
		return String.format("%s,%s", codigoDepartamento, empleadosToString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoDepartamento);
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj ||obj!=null && obj instanceof Departamento dep && dep.codigoDepartamento.equals(this.codigoDepartamento);
	}
	
}