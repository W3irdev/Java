package com.colecciones.boletin1.ejercicio8.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.colecciones.boletin1.ejercicio8.comparators.AlumnosPorEdadComparator;
import com.colecciones.boletin1.ejercicio8.comparators.AlumnosPorNombreComparator;


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
		if(alumno!=null && miembros.contains(alumno)) {
			miembro=alumno;
			
		}
		
		return miembro;
	}

	
	public Equipo unionEquipo(Equipo equipoExterno){
		if(equipoExterno!=null && !this.equals(equipoExterno)) {
			
			this.miembros.addAll(equipoExterno.miembros);
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
	
	public String jugadoresMasculinosMayores() {
		StringBuilder sb = new StringBuilder();
		//Alumno[] ordenados =  (Alumno[]) miembros.toArray();
		//Arrays.sort(ordenados, new AlumnosPorEdadComparator());
		List<Alumno> ordenados = new ArrayList<>(miembros);
		ordenados.sort(new AlumnosPorEdadComparator());
		
		for (Alumno alumno : ordenados) {
			if(alumno!=null && alumno.getEdad()>=18 && alumno.getSexo()=='H') {
				sb.append(alumno);
			}
		}
		return sb.toString();
	}
	
	public int jugadorasFemeninoMayores() {
		List<Alumno> ordenados = new ArrayList<>(miembros);
		ordenados.sort(new AlumnosPorEdadComparator());
		int cantidad=0;
		for (Alumno alumno : ordenados) {
			if(alumno!=null && alumno.getEdad()>=18 && alumno.getSexo()=='M') {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public boolean esFemenino() {
		boolean femenino = true;
		
		for (Alumno alumno : miembros) {
			if(alumno.getSexo()=='H') femenino=false;
		}
		return femenino;
	}
	
	public int jugadoraMayor() {
		List<Alumno> ordenados = new ArrayList<>(miembros);
		ordenados.sort(new AlumnosPorEdadComparator());
		int edad=0;
		for (Alumno alumno : ordenados) {
			if(alumno!=null && alumno.getEdad()>=18 && alumno.getSexo()=='M'
					&& alumno.getEdad()>edad) {
				edad=alumno.getEdad();
			}
		}
		return edad;
	}
	
	public Set<Alumno> dniMasculinosMenores() {
		List<Alumno> ordenados = new ArrayList<>(miembros);
		ordenados.sort(new AlumnosPorEdadComparator());
		Iterator<Alumno> it = ordenados.iterator();
		boolean mayorEncontrado=false;
		Alumno alumno;
		Set<Alumno> menoresDni = new HashSet<>();
		while(it.hasNext() && !mayorEncontrado) {
			alumno = it.next();
			if(alumno.getEdad()>=18) {
				mayorEncontrado=true;
			}else if(alumno.getSexo()=='H') {
				menoresDni.add(alumno);
			}
			
		}
		
		return menoresDni;
	}
	
	public List<Alumno> nombreJugadorasAscendente() {
		List<Alumno> ordenados = new ArrayList<>(miembros);
		ordenados.sort(new AlumnosPorNombreComparator());
		Iterator<Alumno> it = ordenados.iterator();
		Alumno alumno;
		List<Alumno> jugadoras = new ArrayList<>();
		while(it.hasNext()) {
			alumno = it.next();
			if(alumno.getSexo()=='H') {
				jugadoras.add(alumno);
			}
		}
		
		return jugadoras;
	}
	
	public boolean existeJugadoraMayor() {
		List<Alumno> ordenados = new ArrayList<>(miembros);
		ordenados.sort(new AlumnosPorEdadComparator());
		boolean esMayor=false;
		for (Alumno alumno : ordenados) {
			if(alumno!=null && alumno.getEdad()>=18 && alumno.getSexo()=='M') {
				esMayor=true;
			}
		}
		return esMayor;
	}
	
	public int contarCiudades() {
		Set<String> ciudades = new HashSet<>();
		
		for (Alumno alumno : miembros) {
			ciudades.add(alumno.getCiudad());
		}
		return ciudades.size();
	}
	
	public String mostrarAlumnos() {
		StringBuilder sb = new StringBuilder();
		for(Alumno alumno:miembros) {
			sb.append(alumno + "\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return String.format("%s", miembros);
	}
	
	
	
	
}
