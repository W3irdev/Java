package com.arrays.seneca;

import java.util.Scanner;

import com.arrays.seneca.model.Seneca;

public class MainSeneca {
	public static void mainPrograma() {
		Scanner sc = new Scanner(System.in);
		int contador=0;
		String nombre;
		double nota;
		String menu="";
		System.out.println("Introduzca el numero de alumnos de la clase");
		
		try {
			Seneca clase1 = new Seneca(Integer.valueOf(sc.nextLine()));
			
			while (contador<clase1.getNumeroAlumnos() ) {
				System.out.println("Introduzca nombre del alumno "+ (contador+1)+"/"+clase1.getNumeroAlumnos());
				nombre=sc.nextLine();
				System.out.println("Introduzca nota del alumno "+ (contador+1)+"/"+clase1.getNumeroAlumnos());
				nota = Double.valueOf(sc.nextLine());
				
				clase1.addAlumno(nombre, nota);
				contador++;
			}
			do {
				
				System.out.println("""
					1. Mostrar el nombre y la nota de los alumnos aprobados.
					2. Mostrar el nombre y la nota los alumnos suspensos.
					3. Mostrar la nota media de la clase.
					4. Mostrar los alumnos que tienen más de una nota X (se solicitará
					X por teclado).
					5. Mostrar el alumno con la nota máxima y mínima.
					6. Mostrar un listado ordenado de forma creciente por la nota.
					7. Salir.
					""");
				menu=sc.nextLine();
				
				switch (menu) {
				case "1" -> System.out.println(clase1.alumnosAprobados());
				case "2" -> System.out.println(clase1.alumnosSuspensos());
				case "3" -> System.out.println(clase1.notaMedia());
				case "4" -> {
					double notaCorte=0;
					boolean valido=false;
					System.out.println("Introduzca una nota para sacar lista con"
							+ " alumnos con notas mayores");
					
					while(!valido) {
						try {
							notaCorte= Double.valueOf(sc.nextLine());
							System.out.println(clase1.notaMayor(notaCorte));
							valido=true;
						} catch (Exception e) {
							System.err.println("Introduzca una nota valida");
							valido=false;
						}
						
					}
					
				}
				case "5" -> System.out.println(clase1.notaMaximaMinima()); 
				case "6" -> System.out.println(clase1.ordenarLista()); 
				case "7" -> {
					System.out.println("Saliendo");
					break;
				}

				
				
				default ->
				throw new IllegalArgumentException("Unexpected value: " + menu);
				}
				
			}while(!menu.equals("7"));
			
		} catch (NumberFormatException n) {
			System.err.println("Introduce el numero de forma correcta y mayor 0");
			mainPrograma();
		}
		
		
	}

	public static void main(String[] args) {

		mainPrograma();

		
		
	}

}
