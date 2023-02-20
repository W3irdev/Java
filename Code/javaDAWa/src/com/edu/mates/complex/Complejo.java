package com.edu.mates.complex;

public class Complejo {

	private double parteReal;
	private double parteImaginaria;
	
	
	
	public Complejo(double parteReal, double parteImaginaria) {
		super();
		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}
	public double getParteReal() {
		return parteReal;
	}
	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}
	public double getParteImaginaria() {
		return parteImaginaria;
	}
	public void setParteImaginaria(double parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}
	
	
	public Complejo suma(Complejo com2) {
        double nuevaParteReal = this.parteReal + com2.parteReal;
        double nuevaParteImaginaria = this.parteImaginaria + com2.parteImaginaria;
        return new Complejo(nuevaParteReal, nuevaParteImaginaria);
	}
	
	
	public Complejo resta(Complejo com2) {
        double nuevaParteReal = this.parteReal - com2.parteReal;
        double nuevaParteImaginaria = this.parteImaginaria - com2.parteImaginaria;
        return new Complejo(nuevaParteReal, nuevaParteImaginaria);
	}
	
	public String mostrarInfo() {
		String datos = String.valueOf(this.parteReal)+", "+String.valueOf(this.parteImaginaria);

		return datos;
	}
	
	
	
	 public String toString() {
		 String resultado;
	        if (parteImaginaria >= 0) {
	            resultado = parteReal + " + " + parteImaginaria + "i";
	        } else {
	            resultado = parteReal + " - " + (-parteImaginaria) + "i";
	        }
	        
	        return resultado;
	    }

	
}
