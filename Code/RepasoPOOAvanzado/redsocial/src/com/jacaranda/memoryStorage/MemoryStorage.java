package com.jacaranda.memoryStorage;

import java.util.Arrays;

import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {
	
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	
	private Usuario[] usuarios;
	private Publicacion[] publicaciones;
	
	private final static int NUM_MAXIMO_USUARIOS = 15;
	private final static int NUM_MAXIMO_PUBLICACIONES = 50;
	
	
	
	public MemoryStorage() {
		super();
		this.numUsuariosActuales = 0;
		this.numPublicacionesActuales = 0;
		usuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
	}

	private int posicionUsuario(String login) {
		
		int posicion = -1;
		for(int i = 0; i<usuarios.length && posicion==-1; i++) {
			if(this.usuarios[i]!=null && this.usuarios[i].getLogin().equals(login)) {
				posicion = i;
			}
		}
		
		return posicion;
	}
	
	public void addUsuario(String login, String pass) {
		if(posicionUsuario(login)==-1) {
			this.usuarios[numUsuariosActuales++]=new Usuario(login, pass);
		}
	}

	public void addPublicacion(String texto, String login) throws PublicacionException {
		
		// ToDo check repetidas
		int posicion = posicionUsuario(login);
		if(posicion!=-1) {
			Usuario usuario = this.usuarios[posicion];
			Publicacion tweet = new Tweet(texto, usuario);
			this.publicaciones[numPublicacionesActuales++%NUM_MAXIMO_PUBLICACIONES]= tweet;
		}		
	}

	
	public void addPublicacion(String post, String tema, String usuario) {
		
	}
	
	public void addPublicacion(String recomendacion, String usuario, int valoracion) {
		
	}
	
	
	public String mostrarListaPublicaciones() {
		Arrays.sort(this.publicaciones);
		return listarContenido(publicaciones);
	}
	
	public String mostrarTweets() {
		Arrays.sort(this.publicaciones);
		
		int cont = 0;
		for(Publicacion p: publicaciones) {
			if(p instanceof Tweet) {
				cont++;
			}
		}
		
		Tweet[] tweets = new Tweet[cont];
		int pos = 0;
		for(Publicacion p : publicaciones) {
			tweets[pos++]=(Tweet) p;
		}
		
		
		return listarContenido(tweets);
	}
	
	public String mostrarPosts() {
		return "";
	}
	
	public String mostrarRecomendaciones() {
		
		
		return "";
	}
	
	
	private String listarContenido(Publicacion[] publicaciones) {
		StringBuilder contenido = new StringBuilder();
		for(Publicacion p : publicaciones) {
			contenido.append(p).append("------------").append(System.lineSeparator());
		}
		
		return contenido.toString();
	}
	
}
