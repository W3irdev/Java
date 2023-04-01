package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {
	
	
	private String login;
	private String password;
	
	
	public Usuario(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	public boolean setPass(String old, String newPass) {
		boolean resultado = false;
		if(old!=null && !old.trim().isEmpty() && old.equals(this.password)
				&& newPass!=null && !newPass.isEmpty()) {
			this.password=newPass;
			resultado = true;
		}
		
		return resultado;
	}
	
	public boolean checkPass(String password2Check) {
		return (password2Check!=null && !password2Check.isEmpty() && password2Check.equals(this.password))	;
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(login, password);
	}


	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj!=null && obj instanceof Usuario) {
			sonIguales = this.login.equals(((Usuario)obj).login);
		}
		
		return sonIguales;
	}


	public String getLogin() {
		return login;
	}
	
	
	
	

}
