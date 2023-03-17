package com.edu.examPoo;

import java.util.Arrays;
import java.util.Scanner;

import com.edu.examPoo.model.Plato;
import com.edu.examPoo.model.Vino;

public class MainPlato {

	static Plato[] menuPlatos = new Plato[20];
	static int index=0;

	
	public static void addPlato(String nombrePlato, double precioPlato) {
		boolean esta= false;
		for(int i=0; i<menuPlatos.length&&!esta;i++) {
			esta = menuPlatos[i].getNombre().equalsIgnoreCase(nombrePlato);
		}
		if(!esta) {
			menuPlatos[index]= new Plato(nombrePlato, precioPlato);
			index++;
			
		}else {
			System.err.println("El plato ya existe");
		}
		
	}
	
	public static void modifyPrice(String plato, double newPrice) {
		try {
			for(int i=0; i<menuPlatos.length;i++) {
				if(menuPlatos[i].getNombre().equalsIgnoreCase(plato)){
					menuPlatos[i].setPrecio(newPrice);
				}
			}
			
		} catch (Exception e) {
			System.err.println("Algo ha ido mal");
		}
		
	}
	
	public static void mostrarInfo(String plato) {
		try {
			for(int i=0; i<menuPlatos.length;i++) {
				if(menuPlatos[i].getNombre().equalsIgnoreCase(plato)){
					System.out.println(menuPlatos[i]);
				}
			}
			
		} catch (Exception e) {
			System.err.println("Algo ha ido mal");
		}
	}
	
	
	public static void asignarVino(String plato, Vino vino) {
		try {
			for(int i=0; i<menuPlatos.length;i++) {
				if(menuPlatos[i].getNombre().equalsIgnoreCase(plato)){
					menuPlatos[i].setVinoRecomendado(vino);
				}
			}
			
		} catch (Exception e) {
			System.err.println("Algo ha ido mal");
		}
		
	}
	
	public static void main(String[] args) {

		
		
		try {
		
			for(int i=0; i<menuPlatos.length;i++) {
				menuPlatos[i]= new Plato("Vacio");
			}
			
			Scanner sc = new Scanner(System.in);
			String menu="";
			String nombrePlato;
			double precioPlato;
			int numVino=0;
			Vino[] vinacoteca = new Vino[5];
			vinacoteca[0]= new Vino("Malaga", 6);
			vinacoteca[1]= new Vino("Sevilla", 7);
			vinacoteca[2]= new Vino("Cadiz", 8);
			vinacoteca[3]= new Vino("Granada", 9);
			vinacoteca[4]= new Vino("Almeria", 3);

			do {
				System.out.println("""
						1. Dar de alta un plato 
						2. Modificar el precio de un plato
						3. Asignar un vino a un plato
						4. Mostrar información de un plato.
						5. Mostrar información de todos los platos.
						6. Salir
						""");
				menu=sc.nextLine();
				
				switch (menu) {
				case "1" -> {
					System.out.println("Vamos a dar de alta un plato");
					System.out.println("Introduce nombre del plato");
					nombrePlato=sc.nextLine();
					System.out.println("Introduce precio del plato");
					precioPlato=Double.valueOf(sc.nextLine());
					
					addPlato(nombrePlato, precioPlato);
					
				}
				case "2" -> {
					System.out.println("Vamos a cambiar el precio de un plato");
					System.out.println("Introduce el nombre del plato");
					nombrePlato=sc.nextLine();
					System.out.println("Introduce el nuevo precio del plato");
					precioPlato=Double.valueOf(sc.nextLine());
					
					modifyPrice(nombrePlato, precioPlato);
					
				}
				case "3" -> {
					System.out.println("Vamos a asignar vino a un plato");
					System.out.println("Introduce el nombre del plato");
					nombrePlato=sc.nextLine();
					
					System.out.println("""
							¿Que vino desea asignar?
							1. Malaga
							2. Sevilla
							3. Cadiz
							4. Granada
							5. Almeria""");
					numVino=Integer.valueOf(sc.nextLine()); 
					
					asignarVino(nombrePlato, vinacoteca[numVino-1]);
					
				}
				case "4" -> {
					System.out.println("¿De que plato desea informacion?");
					nombrePlato=sc.nextLine();
					mostrarInfo(nombrePlato);
					
					
				}
				case "5" -> {
					
					System.out.println(Arrays.toString(menuPlatos));
				}
				case "6" -> {
					System.out.println("Saliendo...");
					break;
				}
				
				default ->
				throw new IllegalArgumentException("Unexpected value: " + menu);
				}
				
			}while(!menu.equals("6"));
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
