package com.edu.practicaExamen;

import java.util.Scanner;

public class BaseUsuariosUtils {
	private static final String RESTRICCIONES = ".-/%!$%&/()=?¿";
	static StringBuilder bbdd = new StringBuilder();
	
	public static boolean esValido(String nombre) {
		boolean esValido=true;
		
		for (int i=0; i<nombre.length()&&esValido;i++) {
			esValido = !nombre.contains(String.valueOf(RESTRICCIONES.charAt(i)));
			
		}
		return esValido;
	}
	
	public static String crearUsuario () {
		String nombre;
		String password;
		String repeatPassword;
		
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("Introduce nombre de usuario");
			nombre = sc.nextLine();
			
			
		}while (!esValido(nombre));
		
		
		do {
			System.out.println("Introduce contraseña");
			password= sc.nextLine();
		}while (password.length()<8||password.length()>12);
		
		do {
			System.out.println("Repite contraseña");
			repeatPassword= sc.nextLine();
		}while (!repeatPassword.equals(password));
		
		
		return ","+nombre+","+password;
	}

	public static void bbdd(String userpass) {
		
		String mostrar;
		bbdd.append(userpass);
		
		Scanner sc = new Scanner(System.in);
		
		String[] usuarios = bbdd.toString().split(",");
		
		do {
			System.out.println("¿Quieres mostrar usuarios S/N");
			mostrar = sc.nextLine();
		}while ("SN".indexOf(mostrar)==-1);
		
		
		for (int i=0; i<usuarios.length&&mostrar.equals("S");i++) {
			
			
			if (i%2!=0) {
			System.out.println(usuarios[i]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		int capacidad=0;
		while (capacidad<5) {
		bbdd(crearUsuario());
		capacidad++;
		
		}
	}

}
