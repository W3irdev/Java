package com.jacaranda.memoryStorage;

import com.jacaranda.Exception.MemoryStorageException;
import com.jacaranda.Exception.PublicacionException;
import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIOS=15;
	private static final int NUM_MAXIMO_PUBLICACIONES=50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Usuario[] usuarios;
	private Publicacion[] publicaciones;
	
	public MemoryStorage() {
		super();
		usuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
		numUsuariosActuales=0;
		numPublicacionesActuales=0;
	}
	
	private int posicionUsuario(String usuario) throws PublicacionException {
		int posicion=-1;
		for(int u=0; u<this.usuarios.length;u++) {
			if(usuarios[u]!=null && usuarios[u].getLogin().equals(usuario)) {
				posicion=u;
			}
		}
		return posicion;
	}
	
	public void addUsuario(String usuario, String pass) {
	
			usuarios[numUsuariosActuales++%NUM_MAXIMO_USUARIOS]= new Usuario(usuario, pass);
			
		
		
	}
	
	public void addPublicacion(String tweet, String usuario) throws MemoryStorageException, PublicacionException {
		if(posicionUsuario(usuario)!=-1) {
			publicaciones[numPublicacionesActuales++%NUM_MAXIMO_PUBLICACIONES]= new Tweet(tweet, usuarios[posicionUsuario(usuario)]);
		}else throw new MemoryStorageException("El usuario no existe");
		
	}
	
	public void addPublicacion(String post, String usuario, String tema) throws PublicacionException, MemoryStorageException {
		if(posicionUsuario(usuario)!=-1) {
			publicaciones[numPublicacionesActuales++%NUM_MAXIMO_PUBLICACIONES]= new Post(post, usuarios[posicionUsuario(usuario)], tema);
		}else throw new MemoryStorageException("El usuario no existe");
	}
	
	public void addPublicacion(String recomendacion, String usuario, int numEstrellas) throws MemoryStorageException, PublicacionException {
		if(posicionUsuario(usuario)!=-1) {
			publicaciones[numPublicacionesActuales++%NUM_MAXIMO_PUBLICACIONES]= new Recomendacion(recomendacion, usuarios[posicionUsuario(usuario)], numEstrellas);
		}else throw new MemoryStorageException("El usuario no existe");
	}
	
	public String mostrarListaPublicaciones() {
		return arraysToString(publicaciones);
	}
	
	public String mostrarTweets() {
		StringBuilder sb = new StringBuilder();
		for(Publicacion t:publicaciones) {
			if(t instanceof Tweet) {
				sb.append(t+"\n");
			}
		}
		return sb.toString();
	}
	
	public String mostrarRecomendacion() {
		StringBuilder sb = new StringBuilder();
		for(Publicacion t:publicaciones) {
			if(t instanceof Recomendacion) {
				sb.append(t+"\n");
			}
		}
		return sb.toString();
	}
	
	public String mostrarPosts() {
		StringBuilder sb = new StringBuilder();
		for(Publicacion t:publicaciones) {
			if(t instanceof Post) {
				sb.append(t+"\n");
			}
		}
		return sb.toString();
	}
	
	private String arraysToString(Object[] array) {
		StringBuilder sb = new StringBuilder();
		for(Object u: array) {
			if(u!=null) {
				sb.append(u);
			}
		}
		return sb.toString();
	}
	
}
