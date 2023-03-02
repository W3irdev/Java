package com.edu.mates.lines;

import java.util.Objects;

public class Punto {

	private double x;
	private double y;
	
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		try {
			this.x = x;
			
		}catch (Exception e) {
			this.x = 0;
		}
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		
		try {
			this.y = y;
			
		}catch (Exception e) {
			this.y = 0;
		}
	}
	
	public Punto() {
		super();
		
		this.x = 0;
		this.y = 0;
	}
	
	public Punto(double x, double y) {
		this();
		
		setX(x);
		setY(y);
	}
	@Override
	public String toString() {
		return x + "," + y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		boolean esIgual = this == obj || obj instanceof Punto;
		
	
		Punto other = (Punto) obj;
		
		if(!esIgual&&obj!=null&&Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y)) {
			esIgual=true;
		}
		
		return esIgual;
	}
	
	
	
	
}
