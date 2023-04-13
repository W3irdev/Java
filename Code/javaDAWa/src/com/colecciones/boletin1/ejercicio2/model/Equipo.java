package com.colecciones.boletin1.ejercicio2.model;

import java.util.*;


public class Equipo {

	private String nombreEquipo;
	private Set<Alumno> miembros;
	
	
	
	public Equipo(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		miembros = new HashSet<>();
	}
	

	public void addAlumno(Alumno alumno) throws AlumnoException {
		
		if(alumno!=null && existeAlumno(alumno)==null) {
			miembros.add(alumno);
		}else throw new AlumnoException();
	}
	
	public void delAlumno(Alumno alumno) throws AlumnoException {
		
		if(alumno!=null && existeAlumno(alumno).equals(alumno)) {
			miembros.remove(alumno);
		}else throw new AlumnoException("El alumno no existe en el equipo");
	}
	
	public Alumno existeAlumno(Alumno alumno) {
		Alumno miembro=null;
		if(alumno!=null && miembros.contains(alumno)==true) {
			miembro=alumno;
			
		}
		
		return miembro;
	}

	
	public Equipo unionEquipo(Equipo equipoExterno){
		if(equipoExterno!=null && !this.equals(equipoExterno)) {
			
			boolean nuevoEquipo = this.miembros.addAll(equipoExterno.miembros);
		}
		
		return this;
		
	}
	
	public Equipo intersectEquipo(Equipo equipoExterno){
		Iterator<Alumno> it = this.miembros.iterator();
		Set<Alumno> nuevoEquipo = new HashSet<>();
		Alumno nuevo;
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
