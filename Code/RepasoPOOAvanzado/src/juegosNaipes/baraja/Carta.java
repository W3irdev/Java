package juegosNaipes.baraja;

import java.util.Objects;

import juegosNaipes.exceptions.CartaValueException;

public class Carta {

	private int number;
	private Palo palo;
	
	public Carta(int number, String palo) throws CartaValueException {
		
		if(this.number>7&&this.number<10) {
			throw new CartaValueException();
		}
		this.number=number;
		this.palo=Palo.valueOf(palo);
		
	}
	
	public double getValor() {
		double valor = (double) number;
		if(this.number>9) {
			valor = 0.5;
		}
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, palo);
	}

	@Override
	public boolean equals(Object obj) {
		boolean esIgual = this == obj;
		
		if (obj!=null&&!esIgual&& (obj instanceof Carta other)) {
			esIgual = number == other.number && palo == other.palo;
			//esIgual = this.hashCode()==other.hashCode();
		}
		
		
		return esIgual;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public Palo getPalo() {
		return this.palo;
	}

	@Override
	public String toString() {
		return String.format("%s de %s", number, palo.toString());
	}
	
	
	
	
	
	
}
