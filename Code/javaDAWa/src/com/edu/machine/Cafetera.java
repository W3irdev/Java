package com.edu.machine;

public class Cafetera {

	private int cafe;
	private int leche;
	private int vasos;
	private double caja;
	private static final double PRECIOSOLO = 1;
	private static final double PRECIOLECHE = 0.8;
	private static final double PRECIOCAFELECHE = 1.5;
	
	
	public static double getPreciosolo() {
		return PRECIOSOLO;
	}

	public static double getPrecoileche() {
		return PRECIOLECHE;
	}

	public static double getPreciocafeleche() {
		return PRECIOCAFELECHE;
	}

	public Cafetera() {
		super();
		caja = 30.0;
		cafe = 50;
		leche = 50;
		vasos = 80;
		
	}
	
	public void servirBebida(String tipo, double dinero) {
		
		
		
		switch (tipo){
		case "SOLO" ->{
			if (dinero>=PRECIOSOLO) {
			cafe--;
			vasos--;
			caja+=PRECIOSOLO;
			System.out.println("Su cafe solo, gracias");
			if (dinero>PRECIOSOLO&&dinero<caja) {
				System.out.println("Recoge tu cambio de "+ (dinero-PRECIOSOLO)+" euros.");
			}
			
			}else {
				System.err.println("Introduce mas monedas");
}
		}
		case "LECHE" ->{
			leche--;
			vasos--;
			caja+=PRECIOLECHE;
			System.out.println("Su vaso leche, gracias");
			if (dinero>PRECIOLECHE&&dinero<caja) {
				System.out.println("Recoge tu cambio de "+ (dinero-PRECIOLECHE)+" euros.");
			}else {
				System.err.println("Introduce mas monedas");
}
		}
		case "CAFELATTE" ->{
			cafe--;
			leche--;
			vasos--;
			caja+=PRECIOCAFELECHE;
			System.out.println("Su cafe con leche, gracias");
			if (dinero>PRECIOCAFELECHE&&dinero<caja) {
				System.out.println("Recoge tu cambio de "+ (dinero-PRECIOCAFELECHE)+" euros.");
			}else {
				System.err.println("Introduce mas monedas");
}
		}
		default -> System.err.println("Debe elegir un tipo de bebida");
		}
		
	}

	public int getCafe() {
		return cafe;
	}

	public void setDepositos(int cafe, int leche, int vasos) {
		if (cafe>=0&&leche>=0&&vasos>=0) {
		this.cafe = cafe;
		this.leche = leche;
		this.vasos = vasos;
		}else {
			System.err.println("Debe introducir valores numericos mayor o igual que 0");
		}
	}

	public int getLeche() {
		return leche;
	}


	public int getVasos() {
		return vasos;
	}

	public void getEstado() {
		System.out.println("Quedan--->"
				+ "\nCafes: "+ cafe
				+"\nLeche: "+ leche
				+"\nVasos: "+ vasos
				+"\nCaja: "+ caja);
	}

	public double getCaja() {
		return caja;
	}

	public void setCaja(double caja) {
		this.caja = caja;
	}
	
	
	
	
	
}
