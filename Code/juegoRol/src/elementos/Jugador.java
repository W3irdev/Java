package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;
import logicaJuego.Coordenada;

public class Jugador extends Element {

	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;
	private String nombre;
	private static int jugador;
	private Coordenada coordenada; //Añadido, coordenada de un jugador.
	
	
	public Jugador(PlayerType type) {
		super(ElementType.valueOf(type.name()));
		this.player=type;
		this.nombre=String.valueOf(Constantes.NOMBRE_JUGADORES[jugador++]);
		try {
			setDinero(Constantes.DINERO);
			setPociones(Constantes.POCION);
			setGemas(Constantes.NUM_GEMAS);
			this.coordenada = new Coordenada();
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private int getFuerza() {
		return this.player.getFuerza();
	}
	
	private int getMagia() {
		return this.player.getMagia();
	}
	
	private int getVelocidad() {
		return this.player.getVelocidad();
	}
	
	public int getFuerzaParaLuchar() {
		return new Random().nextInt(getFuerza());
	}
	
	public int getMagiaParaLuchar() {
		return new Random().nextInt(getMagia());
	}
	
	public int getVelocidadParaLuchar() {
		int velocidad = new Random().nextInt(getVelocidad());
		if(velocidad==0) velocidad=1;
		return velocidad;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void setDinero(int dinero) throws JugadorException {
		if(dinero<Constantes.NUM_DINERO) throw new JugadorException("Debe introducir una cantidad de dinero mayor");
		this.dinero=dinero;
	}
	
	public int getPociones() {
		return this.pociones;
	}
	
	public void setPociones(int pociones) throws JugadorException {
		if(pociones<Constantes.NUM_POCIONES) throw new JugadorException("Debe introducir una cantidad mayor de pociones");
		this.pociones=pociones;
	}
	
	public int getGemas() {
		return this.gemas;
	}
	
	public void setGemas(int gemas) throws JugadorException {
		if(gemas<Constantes.NUM_GEMAS) throw new JugadorException("Debe introducir una cantidad mayor de gemas");
		this.gemas=gemas;
	}
	
	public PlayerType getPlayer() {
		return this.player;
	}
	
	public String getResumen() {
		return String.format("El jugador %s, tiene %s oros, %s pociones, y %s gemas", this.nombre, this.dinero, this.pociones, this.gemas);
	}
	
	public int lucha(Jugador oponente) {
		int estadisticas = getFuerzaParaLuchar()+getMagiaParaLuchar()+getVelocidadParaLuchar();;
		int statsOponente = oponente.getFuerzaParaLuchar()+oponente.getMagiaParaLuchar()+oponente.getVelocidadParaLuchar();
		return estadisticas-statsOponente;
		
	}
	
	public Coordenada getCoordenadas() {
		return this.coordenada;
	}
	
	public int encuentraRoca() {
		int ocurre = new Random().nextInt(2);
		if(ocurre==0) this.gemas--;
		return ocurre;
	}
	
	public void encuentraDinero() {
		int gana = new Random().nextInt(Constantes.DINERO);
		this.dinero = gana!=0?dinero+gana:dinero+1;
	}
	
	public void encuentraPocion() {
		int gana = new Random().nextInt(Constantes.POCION);
		this.pociones = gana!=0?pociones+gana:pociones+1;
	}
	
	public void encuentraGema() {
		int gana = new Random().nextInt(Constantes.GEMA);
		this.gemas = gana!=0?gemas+gana:gemas+1;
	}
	
	public void moverJugador(Coordenada coordDestino) {
		this.coordenada=coordDestino;
	}

	@Override
	public String toString() {
		return String.format("%nJugador dinero=%s, gemas=%s, player=%s, pociones=%s, nombre=%s, coordenada=%s", dinero,
				gemas, player, pociones, nombre, coordenada);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(player);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Jugador j && this.hashCode()==j.hashCode();
	}
	
	

	
	
}
