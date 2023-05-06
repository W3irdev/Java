package logicaJuego;

import java.util.Objects;
import java.util.Random;

public class Coordenada {

	private int x;
	private int y;
	
	
	
	
	public Coordenada() {
		super();
		
		this.x = new Random().nextInt(Constantes.TAMANNO);
		this.y = new Random().nextInt(Constantes.TAMANNO);
	}
	
	public Coordenada(int x, int y) {
		super();
		
		if (x>=0 && x<=Constantes.TAMANNO && y>=0 && y<=Constantes.TAMANNO) {
			this.x = x;
			this.y = y;
			
		}else {
			this.x=0;
			this.y=0;
		}
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean goRight() {
		boolean move = false;
		if(this.x!=Constantes.TAMANNO) {
			this.x++;
			move=true;
		}
		
		return move;
	}
	
	public boolean goLeft() {
		boolean move = false;
		if(this.x!=0) {
			this.x--;
			move=true;
		}
		
		return move;
	}
	
	public boolean goUp() {
		boolean move = false;
		if(this.y!=0) {
			this.y--;
			move=true;
		}
		
		return move;
	}
	
	public boolean goDown() {
		boolean move = false;
		if(this.y!=Constantes.TAMANNO) {
			this.y++;
			move=true;
		}
		
		return move;
	}
	
	public Coordenada clone() {
		return new Coordenada(this.x, this.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Coordenada c && this.hashCode()==c.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("X: %s Y: %s", this.x, this.y);
	}
	
	
	
	
	
}
