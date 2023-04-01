package com.alquiler;

import java.util.Scanner;

import com.alquiler.model.Alquiler;
import com.alquiler.model.Coche;
import com.alquiler.model.Combustible;
import com.alquiler.model.Furgoneta;
import com.alquiler.model.Gama;
import com.alquiler.model.Microbus;

public class MainAlquiler {

	public static void main(String[] args) {
		Alquiler alquiler = new Alquiler();
		Scanner sc = new Scanner(System.in);
		String opcion="";
		String menu="""
				1. Alta de vehiculo.
				2. Calculo alquiler.
				3. Salir.
				""";
		String tipo="""
				1. Coche
				2. Microbus
				3. Furgoneta
				
				Seleccione tipo de vehiculo: 
				""";
		String tipoOpcion;
		
		String gamaMenu="""
				1. Baja
				2. Media
				3. Alta
				
				Seleccione gama: 
				""";
		double pma;
		Gama[] gamas = {Gama.BAJA, Gama.MEDIA, Gama.ALTA};
		String gamaOpcion="4";
		String combustibleMenu="""
				
				1. Gasolina
				2. Gasoil
				
				Selecciona tipo de combustible: 
				""";
		String combustibleOpcion="4";
		int plazas;
		Combustible[] combustibles = {Combustible.GASOLINA, Combustible.DIESEL};
		String matricula;
		int dias;
		do {
			dias=0;
			pma=0.0;
			matricula="";
			plazas=0;
			tipoOpcion="4";
			
			System.out.println(menu);
			System.out.println("Introduzca opcion: ");
			opcion = sc.nextLine();
			
			if(opcion.equalsIgnoreCase("1")) {
				while ("123".indexOf(tipoOpcion)==-1) {
					System.out.println(tipo);
					tipoOpcion=sc.nextLine();
				}
				if(tipoOpcion.equals("1")) {
					while ("123".indexOf(gamaOpcion)==-1) {
						System.out.println(gamaMenu);
						
						gamaOpcion=sc.nextLine();
					}
					while ("12".indexOf(combustibleOpcion)==-1) {
						System.out.println(combustibleMenu);
						
						combustibleOpcion=sc.nextLine();
					}
					System.out.println("Introduzca matricula: ");
					matricula=sc.nextLine();
					
					try {
						alquiler.altaVehiculo(new Coche(matricula, gamas[Integer.valueOf(gamaOpcion)-1], combustibles[Integer.valueOf(combustibleOpcion)-1]));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else if(tipoOpcion.equals("2")) {
					while ("123".indexOf(gamaOpcion)==-1) {
						System.out.println(gamaMenu);
						
						gamaOpcion=sc.nextLine();
					}
					while (plazas<1) {
						System.out.println("De cuantas plazas desea el microbus");
						plazas=Integer.valueOf(sc.nextLine());
						
					}
					
					System.out.println("Introduzca matricula: ");
					matricula=sc.next("[0-9]{4}[A-Za-z]{3}");
					
					try {
						alquiler.altaVehiculo(new Microbus(matricula, gamas[Integer.valueOf(gamaOpcion)-1], plazas));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else if(tipoOpcion.equals("3")) {
					while ("123".indexOf(gamaOpcion)==-1) {
						System.out.println(gamaMenu);
						
						gamaOpcion=sc.nextLine();
					}
					while (pma<1000) {
						System.out.println("Elija MMA > 1000");
						pma=Integer.valueOf(sc.nextLine());
						
					}
					
					System.out.println("Introduzca matricula: ");
					matricula=sc.nextLine();
					try {
						alquiler.altaVehiculo(new Furgoneta(matricula, gamas[Integer.valueOf(gamaOpcion)-1], pma));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
			}else if(opcion.equals("2")) {
				
				System.out.println("Introduzca matricula: ");
				matricula=sc.nextLine();
				
				while (dias<1) {
					System.out.println("Cuantos dias ha estado en uso?");
					dias=Integer.parseInt(sc.nextLine());
					
				}

				try {
					System.out.println("El precio total asciende a: "+ alquiler.calcularPrecio(matricula, dias));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} while (!opcion.equals("3"));
	}

}
