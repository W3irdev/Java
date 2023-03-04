package com.arrays.seneca.model;

import java.util.Arrays;

public class Seneca {
	
	private int numeroAlumnos;
	private String[] listaAlumnos;
	private double[] notaAlumnos;
	private int posicion=0;
	
	
	
	public Seneca(int numeroAlumnos) {
		super();
		setNumeroAlumnos(numeroAlumnos);
		listaAlumnos = new String[numeroAlumnos];
		notaAlumnos = new double[numeroAlumnos];
	}


	

	public int getNumeroAlumnos() {
		return numeroAlumnos;
	}




	public void setNumeroAlumnos(int numeroAlumnos) {
		try {
			if(numeroAlumnos>0) {
				this.numeroAlumnos=numeroAlumnos;
			}
		} catch (Exception e) {
			System.err.println("Introduce un numero correcto y mayor 0");
		}
		
	}




	public void addAlumno(String nombre, double nota) {
		
		try {
				listaAlumnos[posicion]=nombre;
				notaAlumnos[posicion]=nota;
				posicion++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("No hay espacio para mas alumnos o La nota introducida no es correcta");
		}
	}
	
	public String alumnosAprobados() {
		StringBuilder aprobados = new StringBuilder();
		
		for (int i=0; i<notaAlumnos.length;i++) {
			if (notaAlumnos[i]>=5) {
				aprobados.append(listaAlumnos[i]+" con "+notaAlumnos[i]+"\n");
			}
			
		}
		return aprobados.toString();
	}
	
	public String alumnosSuspensos() {
		StringBuilder suspensos = new StringBuilder();
		
		for (int i=0; i<notaAlumnos.length;i++) {
			if (notaAlumnos[i]<5) {
				suspensos.append(listaAlumnos[i]+" con "+notaAlumnos[i]+"\n");
			}
			
		}
		return suspensos.toString();
	}
	
	public double notaMedia() {
		double total=0;
		
		for(int i=0; i<notaAlumnos.length;i++) {
			total+=notaAlumnos[i];
		}
		
		return total/notaAlumnos.length;
	}
	
	public String notaMayor(double nota) {
		StringBuilder conMasNota = new StringBuilder();
		
		for(int i=0; i<notaAlumnos.length;i++) {
			if(notaAlumnos[i]>nota) {
				conMasNota.append(listaAlumnos[i]+"\n");
			}
		}
		return conMasNota.toString();
		
	}
	
	public String notaMaximaMinima() {
		StringBuilder sb = new StringBuilder();
		double notaMinima=10;
		double notaMaxima=0;
		StringBuilder personaMinima = new StringBuilder();
		StringBuilder personaMaxima = new StringBuilder();
		
		for(int i=0; i<notaAlumnos.length;i++) {
			
	
			if (notaAlumnos[i]<notaMinima) {
				notaMinima = notaAlumnos[i];
				personaMinima.setLength(0);
				personaMinima.append(listaAlumnos[i]);
				
			}
			if (notaAlumnos[i]>notaMaxima) {
				notaMaxima = notaAlumnos[i];
				personaMaxima.setLength(0);
				personaMaxima.append(listaAlumnos[i]);
				
			}
			
		}
		
		return "El alumno con mas nota es: "+personaMaxima.toString()+" Y el alumno con menor nota es: "+personaMinima;
	}
	
	public String ordenarLista() {
		String[] listaOrdenadaAlumnos = new String[listaAlumnos.length];
		double[] notaOrdenadaAlumnos = notaAlumnos;
		double notaMinima=10;
		double notaMaxima=0;
		StringBuilder listadoOrdenado = new StringBuilder();
		
		for(int i=0; i<notaOrdenadaAlumnos.length;i++) {
			for(int j=0; j<notaAlumnos.length;j++) {
				if(notaOrdenadaAlumnos[i]>notaAlumnos[j]) {
					notaOrdenadaAlumnos[i]=notaAlumnos[j];
					listaOrdenadaAlumnos[i]=listaAlumnos[j];
				}
			}
			
		}
		
		for(String alumno:listaOrdenadaAlumnos) {
			listadoOrdenado.append(alumno+"\n");
		}
		
		return listadoOrdenado.toString();
	}
	

	/*7. Realiza un programa que solicite el número de alumnos de una clase y
pida por pantalla para cada uno de los alumnos su nombre y su nota.
Después se presentará un menú que permitirá realizar las siguientes
operaciones:
1. Mostrar el nombre y la nota de los alumnos aprobados.
2. Mostrar el nombre y la nota los alumnos suspensos.
3. Mostrar la nota media de la clase.
4. Mostrar los alumnos que tienen más de una nota X (se solicitará
X por teclado).
5. Mostrar el alumno con la nota máxima y mínima.
6. Mostrar un listado ordenado de forma creciente por la nota.
7. Salir.*/
	
	
	
}
