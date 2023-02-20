package com.edu.banco;

import java.util.Scanner;

public class UsoCuenta {

	public static void main(String[] args) {
		String opcion;
		String salir;
		Cuenta cuenta1 = new Cuenta("Jose Miguel", 600);
		Scanner sc = new Scanner(System.in);
		String menu = """
				1. Hacer un reintegro.
				2. Hacer un ingreso.
				3. Consultar el saldo y el número de reintegros e ingresos realizados.
				4. Finalizar las operaciones. 
				
				""";
		
		
		do {
			System.out.println(menu);
			opcion = sc.nextLine();
			
			switch (opcion) {
			case "1" -> {
				System.out.println("Introduzca cantidad a retirar: ");
				cuenta1.setReintegro(Double.valueOf(sc.nextLine()));
				System.out.println("Saldo: "+ cuenta1.getSaldo());
			}
			case "2" ->{
				System.out.println("Introduzca cantidad a ingresar: ");
				cuenta1.setIngreso(Double.valueOf(sc.nextLine()));
				System.out.println("Saldo: "+ cuenta1.getSaldo());
			}
			case "3" ->{
				System.out.println("Saldo: "+ cuenta1.getSaldo()+"\n"+
			"Se han realizado: "+ cuenta1.getContadorReintegros()+" retiradas, y"
			+" se han realizado: "+cuenta1.getContadorIngresos()+" ingresos.");
			}
			case "4" ->{
				System.out.println("¿Esta seguro que desea salir? S/N");
				salir=sc.nextLine().toUpperCase();
				if ("SN".indexOf(salir)!=-1){
					if(salir.equals("S")) {
						opcion="salir";
					}
					
				}
				
				
			}
			
			}
			
			
		}while (!opcion.equals("salir"));
	}

}
