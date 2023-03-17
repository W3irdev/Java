package com.exam.model;

import java.util.Objects;

public class Usuario {

	
	private String nombre;
	private String apellidos;
	private String email;
	private int intentos;
	private Credencial cred;
	private final Exception BLOCKACCOUNT=new Exception("Cuenta bloqueada");

	public Usuario(String nombre, String apellidos, String password) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		
		try {
			cred = new Credencial(nombre, apellidos, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	public Usuario(String nombre, String apellidos, String email, String password) {
		this(nombre, apellidos, password);
		
		this.email=email;
		
		
	}

	public boolean esCuentaBloqueada() {
		return this.intentos>2;
		
	}
	

	
	public boolean esPasswordSegura() {
		boolean contiene=false;
		if(cred.esPasswordSegura()) {
			contiene=true;
		}
			return contiene;
		}
	
	public boolean modificarPassword(String oldpass, String newpass, String newpassverif) {
		final String ABC = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		final String DIGIT = "1234567890";
		boolean contiene=newpass.length()>8&&newpass.contains(ABC)&&newpass.contains(DIGIT);
		boolean puede=false;
		
		if(cred.comprobarPassword(oldpass)&&contiene&&newpass.equals(newpassverif)&&!oldpass.equals(newpass)) {
			cred.setPassword(newpass);
			puede=true;
		}
		return puede;
	}
	
	public String getUsername() {
		return cred.getUsername();
	}

	public boolean hacerLogin(String username, String password) throws Exception {
		boolean login=false;
		if(username.equals(cred.getUsername())) {
			if(!cred.comprobarPassword(password)) {
				
				intentos+=1;
			}else {
				intentos=0;
				login=true;
			}
			if(esCuentaBloqueada()) {
				throw BLOCKACCOUNT;
			}
		}
		return login;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, email, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esigual=false;
		
		if (this == obj && obj!=null&&(obj instanceof Usuario)) {
			esigual = true;
		}
		
		Usuario other = (Usuario) obj;
		
		esigual = other!=null&&(Objects.equals(apellidos, other.apellidos) && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre))||cred.equals(obj);
		return esigual;
	}

	@Override
	public String toString() {
		String mensaje="Cuenta bloqueada";
		if(!esCuentaBloqueada()) {
			mensaje="Usuari@: "+ this.nombre+" "+ this.apellidos+" con email "+this.email+" "+cred.toString();
		}
		return mensaje;
	}
	

	
	
	
	
	
}
