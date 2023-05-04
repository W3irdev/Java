package main.java.model;

public class Estudiante {

	private int id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private Genero genero;
	
	public Estudiante(int id, String nombre, String apellidos, String fechaNacimiento, Genero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return String.format("Estudiante con id %s nombre %s apellidos %s"
				+ " fecha de nacimiento %s y genero %s", id, nombre,
				apellidos, fechaNacimiento, genero);
	}
	
	
	
}
