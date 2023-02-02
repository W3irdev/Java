package com.edu.model;

public class Estudiante extends Persona {
	
	public Estudiante(String nombre, int edad, String dni, double altura, double peso, String genero, String curso,
			String nombreCurso, String[] asignaturas) {
		super(nombre, edad, dni, altura, peso, genero);
		this.curso = curso;
		this.nombreCurso = nombreCurso;
		this.asignaturas = asignaturas;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public String[] getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(String[] asignaturas) {
		this.asignaturas = asignaturas;
	}
	private String curso = new String();
	private String nombreCurso = new String();
	private String[] asignaturas = new String[12];
	
}
