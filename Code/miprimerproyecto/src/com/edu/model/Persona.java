package com.edu.model;

public class Persona {

	public Persona(String nombre, int edad, String dni, double altura, double peso, String genero) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.altura = altura;
		this.peso = peso;
		this.genero = genero;
	}
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	private String nombre;
	private int edad;
	private String dni;
	private double altura;
	private double peso;
	private String genero;
}
