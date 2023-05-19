package main.java.model;

import java.time.LocalDate;

public class Persona {
	
	private static final int TOPE_JOVEN = 30;
	private static final int MAYORIA_EDAD = 18;
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;


	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido, String dni) {
		this();
		if(validarDatos(nombre, apellido, dni)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;

		}else {
			throw new PersonaException();
		}
	}
	
	public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String genero) {
		this();
		if(validarDatos(nombre, apellido, dni, fechaNacimiento, genero)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = fechaNacimiento;
			this.genero = Genero.valueOf(genero);
		}else {
			throw new PersonaException();
		}
	}
	
	
	public boolean validarDatos(String nombre, String apellido, String dni) {
		boolean esValido = true;
		if (dni == null || nombre == null  || apellido == null || nombre.isEmpty()  || apellido.isEmpty()  || dni.isEmpty()) {
			esValido = false;
		}else if(dni.length() < 9 || Character.isDigit(dni.charAt(8))
				|| "TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(dni.substring(0, 8))%23)!= dni.toUpperCase().charAt(8)) {
			esValido=false;
			for(int i=0; i<dni.length()-1; i++) {
				if(Character.isAlphabetic(dni.charAt(i))) 
					esValido =  false;
				
			}
		}
		return esValido;
	}
	
	public boolean validarDatos(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String genero) {
		boolean esValido = validarDatos(nombre, apellido, dni);
		
		if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now()) || genero == null || genero.isEmpty()
				|| !Genero.HOMBRE.equals(Genero.valueOf(genero)) && !Genero.MUJER.equals(Genero.valueOf(genero)) && esValido) {
			esValido = false;
		}

		
		return esValido;
	}
	
	
	
	public boolean bonoJovenDisponible() {
		return (LocalDate.now().getYear()-this.fechaNacimiento.getYear()> MAYORIA_EDAD) && 
				(LocalDate.now().getYear()-this.fechaNacimiento.getYear()< TOPE_JOVEN);
		
	}
	
	public int obtenerEdad() {
		return LocalDate.now().compareTo(fechaNacimiento)>=0?
						LocalDate.now().minusYears(this.fechaNacimiento.getYear()).getYear()	:	-1;
	}
	
	public int obtenerEdadPara(int year) {
		if(year>=this.fechaNacimiento.getYear()) {
			return year-this.fechaNacimiento.getYear();
		}
		return -1;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	

}
