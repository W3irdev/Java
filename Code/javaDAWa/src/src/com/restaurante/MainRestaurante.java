package src.com.restaurante;

import java.util.Scanner;

import src.com.restaurante.model.Plato;
import src.com.restaurante.model.PlatoPrincipal;

public class MainRestaurante {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Plato[] menu = new Plato[10];
		
		PlatoPrincipal plato = new PlatoPrincipal("Macarrones", 22, null, "menestra");
		
		System.out.println(plato);
		
		int contador = 0;
		
		int opcion = 0;
		
		while(opcion!=6) {
			
			if(opcion==1) {
				
				System.out.println("Introduzca el nombre del plato: ");
				String nombre = sc.nextLine();
				
				System.out.println("Introduzca el precio: ");
				double precio = Double.valueOf(sc.nextLine());
				
				int posicion = buscarPlato(nombre, menu);
				
				if(posicion!=-1) {
					System.out.println("El plato ya existe");
				}else {
					menu[contador%menu.length]= new Plato(nombre, precio);
					contador++;
				}
				
				
				
			}else if(opcion==2) {
				
				System.out.println("Introduzca el nombre del plato: ");
				String nombre = sc.nextLine();
				
				int posicion = buscarPlato(nombre, menu);
				
				if(posicion!=-1) {
					System.out.println("Introduzca el precio: ");
					double precio = Double.valueOf(sc.nextLine());
					
					menu[posicion].setPrecio(precio);
					
				}else {
					System.out.println("El plato no existe.");
				}
				
			}else if(opcion==3) {
				System.out.println("Introduzca el nombre del plato: ");
				String nombre = sc.nextLine();
				
				int posicion = buscarPlato(nombre, menu);
				
				if(posicion!=-1) {
					try {
						System.out.println("Introduzca el nombre del vino: ");
						String nombreVino = sc.nextLine();
						
						System.out.println("Introduzca la graduación: ");
						double graduacion = Double.valueOf(sc.nextLine());
						
						menu[posicion].setVinoRecomendado(nombreVino, graduacion);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else {
					System.out.println("El plato no existe.");
				}
				
				
			}else if(opcion==4) {
				System.out.println("Introduzca el nombre del plato: ");
				String nombre = sc.nextLine();
				
				int posicion = buscarPlato(nombre, menu);
				
				if(posicion!=-1) {
					System.out.println(menu[posicion]);
				}else {
					System.out.println("El plato no existe");
				}
			}else if(opcion==5) {
				for(Plato p : menu) {
					if(p!=null) {
						System.out.println(p);
					}
				}
			}
			
			System.out.println("Introduzca una opción: ");
			opcion = Integer.valueOf(sc.nextLine());
			
		}
		

	}

	
	public static int buscarPlato(String nombre, Plato[] menu) {
		
		int posicion = -1;
		for(int i=0; i< menu.length && posicion==-1; i++) {
			if(menu[i]!=null && nombre.equalsIgnoreCase(menu[i].getNombre())) {
				posicion=i;
			}
		}
		return posicion;
	}
	
	
	public static void ejemploValidacionConTratamientoExcepciones() {
		
		int numero = 0;
		
		
		Scanner sc = new Scanner(System.in);
		do {
			try {
				
				System.out.println("Introduzca un número:");
				numero = Integer.valueOf(sc.nextLine());
				
			}catch(NumberFormatException exception) {
				System.out.println("Introduce un dato correcto");
			}catch(Exception e) {
				System.out.println("Se ha producido otro tipo de excepción inesperada");
			}
			
		}while(numero==0);
	}
}
