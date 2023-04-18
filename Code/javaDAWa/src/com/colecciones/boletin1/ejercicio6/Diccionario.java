package com.colecciones.boletin1.ejercicio6;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {

	private Map<String, Descripcion> dic;

	public Diccionario() {
		dic=new HashMap<>();
	}
	
	public void addPalabra(String palabra, String desc) {
		if(dic.containsKey(palabra)) {
			dic.get(palabra).addSignificado(desc);
		}else {
			dic.put(palabra, new Descripcion(desc));
		}
	}
	
	public Descripcion searchPalabra(String palabra) {
		return palabra!=null && dic.containsKey(palabra)?dic.get(palabra):null;
	}
	
	public void borrarPalabra(String palabra) {
		if(palabra!=null && dic.containsKey(palabra)) {
			dic.remove(palabra);
		}
	}
	
	public String listarPalabras(String comienzo) {
		StringBuilder sb = new StringBuilder();
		
		for (String key : dic.keySet()) {
			if(key.toLowerCase().startsWith(comienzo.toLowerCase())) {
				sb.append(key + "\n");
			}
		}
		
		return sb.toString();
	}
	
}
