package com.colecciones.boletin1.ejercicio3.model;

import java.util.*;

public class Equipo<T> {

	private String nombreEquipo;
	private Set<T> miembros;
	
	
	
	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		miembros = new HashSet<>();
	}
	

	public void addAlumno(T alumno) throws AlumnoException {
		
		if(alumno!=null && existeAlumno(alumno)==null) {
			miembros.add(alumno);
		}else throw new AlumnoException();
	}
	
	public void delAlumno(T alumno) throws AlumnoException {
		
		if(alumno!=null && existeAlumno(alumno).equals(alumno)) {
			miembros.remove(alumno);
		}else throw new AlumnoException("El alumno no existe en el equipo");
	}
	
	public T existeAlumno(T alumno) {
		T miembro=null;
		if(alumno!=null && miembros.contains(alumno)==true) {
			miembro=(T) alumno;
			
		}
		
		return miembro;
	}

	
	public Equipo unionEquipo(Equipo equipoExterno){
		boolean nuevoEquipo = this.miembros.addAll(equipoExterno.miembros);
		
		return this;
		
	}
	
	public Equipo intersectEquipo(Equipo equipoExterno){
		Set<T> nuevoEquipo = new HashSet<>();
		Iterator<T> it = (Iterator<T>) this.miembros.iterator();
		T nuevo;
		Equipo nuevoEquipoFinal=null;
		
		while(it.hasNext()) {
			nuevo=it.next();
			if(equipoExterno.miembros.contains(nuevo)) nuevoEquipo.add(nuevo);
		}
		
		if(nuevoEquipo.size()>=2) {
			nuevoEquipoFinal = new Equipo(this.nombreEquipo);
			nuevoEquipoFinal.miembros=nuevoEquipo;
		}
		return nuevoEquipoFinal;
		
	}
	
	@Override
	public String toString() {
		return String.format("%s", miembros);
	}
	
	
	
	
}
