package com.exam.model;

import java.util.Objects;

public class Credencial {
	
	private String username;
	private String password;
	private static int secuencia=100;
	private final Exception STDOUT=new Exception("La contraseña no es segura");
	
	
	Usuario user;
	

	
	
	public Credencial(String nombre, String apellidos, String password) throws Exception {
		super();
		String cabecera=nombre.substring(0,4).toLowerCase();
		String cuerpo=apellidos.substring(0,4).toLowerCase();
		this.username=cabecera+cuerpo+secuencia;
		this.password=password;
		setPassword(password);
		
		secuencia+=1;
	
	}


	public boolean esPasswordSegura() {
		final String ABC = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		final String DIGIT = "1234567890";
		boolean contiene=password.length()>8&&password.contains(ABC)&&password.contains(DIGIT);
		
			return contiene;
		}
	
	
	public String getUsername() {
		return this.username;
	}

	public boolean comprobarPassword(String password) {
		return password.equals(this.password);
		
	}
	
	public void setPassword(String newpass) {
		final String ABC = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		final String DIGIT = "1234567890";
		boolean contiene=newpass.length()>8&&newpass.contains(ABC)&&newpass.contains(DIGIT);
		
		if(contiene) {
			
			this.password=newpass;
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(username);
	}


	@Override
	public boolean equals(Object obj) {
		
		boolean iguales=false;
		if (this == obj && obj!=null&&obj instanceof Credencial) {
			iguales=true;
		}
	
		
		Credencial other = (Credencial) obj;
		
		iguales=other!=null&&Objects.equals(username, other.username);
		return iguales;
	}


	@Override
	public String toString() {
		StringBuilder passcifrada= new StringBuilder();
		for(int i=0; i<password.length();i++) {
			passcifrada.append("*");
		}
		
		return "username " +username+" y contraseña "+ passcifrada;
	}
	
	
	
}
