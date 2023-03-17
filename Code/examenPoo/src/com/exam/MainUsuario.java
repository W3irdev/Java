package com.exam;

import com.exam.model.Usuario;

public class MainUsuario {
	
	public static String buscarUsuario(String username, Usuario[] lista) {
		String usuario="El usuario no se encuentra";
		for(int i=0; i<lista.length;i++) {
			if(lista[i]!=null&&username.equals(lista[i].getUsername())){
				usuario=lista[i].toString();
			}
		}
		return usuario;
	}

	public static void main(String[] args) {
		Usuario[] bbdd = new Usuario[10];
		int contador=0;
		
		
		try {
			bbdd[0]= new Usuario("Jose Manuel", "Sevillano", "132G5678");
			System.out.println(bbdd[0]);
			bbdd[1]=new Usuario("Jose Ramon", "Sevicia","hola@hola.com", "132G5678");
			System.out.println(bbdd[1]);
			
			if(bbdd[1].hacerLogin("josesevi101", "132G5678")) {
				System.out.println("Login realizado con exito");
				contador=0;
			}else {
				contador++;
				System.out.println("Llevas " + contador+"/3 intentos");
			}
			bbdd[1].hacerLogin("josesevi101", "132G5678");
			
			//COMPROBACION DE BLOQUEO, LANZA EXCEPCION DE CUENTA BLOQUEADA, SI ES BLOQUEADA
			/*System.out.println(bbdd[1].hacerLogin("josesevi101", "132G5678"));
			System.out.println(bbdd[1].hacerLogin("josesevi101", "133G5678"));
			System.out.println(bbdd[1].hacerLogin("josesevi101", "134G5648"));
			System.out.println(bbdd[1].hacerLogin("josesevi101", "132G5278"));*/
			
			System.out.println(bbdd[1]);
			System.out.println(buscarUsuario("josesevi112301", bbdd));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		for(Usuario u:bbdd) {
			if(u!=null) {
				System.out.println(u);
			}
		}
		
	}

}
