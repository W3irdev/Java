/*
 * Enumerado que almacena el tipo de elementos que nos podemos encontrar en el tablero.
 * Se define un tipo, un símbolo y un fichero
 */
package elementos;

import logicaJuego.Constantes;

public enum ElementType {
	
	ROCA(Constantes.ROCA,'R',"roca.png", Constantes.NUM_ROCAS),
	DINERO(Constantes.DINERO,'D',"dinero.png", Constantes.NUM_DINERO),
	GEMA(Constantes.GEMA,'Y',"gema.png", Constantes.NUM_GEMAS),
	POCION(Constantes.POCION,'P',"pocion.png", Constantes.NUM_POCIONES),
	ELFO(Constantes.ELFO,'E',"elfo.png", 0),
	GUERRERO(Constantes.GUERRERO,'G',"guerrero.png", 0),
	MAGO(Constantes.MAGO,'M',"mago.png", 0),
	OGRO(Constantes.OGRO,'O',"ogro.png", 0);
	
	private int type;
	private char symbol;
	private String image;
	private int cantidad;
	
	
	private ElementType(int type, char symbol, String image, int cantidad) {
		this.type = type;
		this.symbol = symbol;
		this.image = image;
		this.cantidad = cantidad;
	}

	public int getType() {
		return type;
	}

	public char getSymbol() {
		return symbol;
	}

	public String getImage() {
		return image;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	
	
	

}
