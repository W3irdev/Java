package com.jacaranda.usuario;

import java.util.Objects;

import com.jacaranda.Exception.PublicacionException;

public class Usuario {

	private String login;
	private String pass;
	
	
	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}
	
	public String getLogin(){
		return this.login;
		
		
	}
	
	public boolean setPass(String antigua, String nueva) {
		boolean set = false;
		if(checkPass(antigua)) {
			this.pass = nueva;
			set = true;
		}
		
		return set;
	}
	
	public boolean checkPass(String pass) {
		boolean esCorrecta = false;
		if (pass.equals(this.pass)) {
			esCorrecta = true;
		}
		return esCorrecta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, pass);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual = this == obj;
	
		if (!esIgual && obj!=null && obj instanceof Usuario) {
			Usuario other = (Usuario) obj;
			
			esIgual = this.login!=null && this.pass!=null && 
					Objects.equals(login, other.login) && 
					Objects.equals(pass, other.pass);
			
		}
		
		
		return esIgual;
	}
	
	
	
}
