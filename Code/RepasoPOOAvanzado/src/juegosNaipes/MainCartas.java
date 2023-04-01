package juegosNaipes;

import juegosNaipes.baraja.Baraja;
import juegosNaipes.baraja.Carta;
import juegosNaipes.exceptions.CartaValueException;

public class MainCartas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Baraja baraja=new Baraja();
			baraja.barajar();
			System.out.println(baraja);
			
		} catch (CartaValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
