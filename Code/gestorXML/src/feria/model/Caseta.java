package feria.model;

import java.util.Objects;

public class Caseta {

	private String titulo;
	private String calle;
	private String numero;
	private String modulos;
	private String clase;
	private String id;
	private String id_calle;
	
	public Caseta(String titulo, String calle, String numero, String modulos, String clase, String id, String id_calle) {
		super();
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
		this.id = id;
		this.id_calle = id_calle;
	}

	
	
	public String getTitulo() {
		return titulo;
	}

	


	public void restarNumero(int modulos) throws Exception {

		if((Integer.parseInt(numero)-modulos)<0) throw new Exception("El numero - modulo es menor de 0");
		this.numero= String.valueOf(Integer.parseInt(numero)-modulos);
		
	}



	public String getCalle() {
		return calle;
	}



	public String getNumero() {
		return numero;
	}



	public String getModulos() {
		return modulos;
	}



	public String getClase() {
		return clase;
	}



	public String getId() {
		return id;
	}



	public String getId_calle() {
		return id_calle;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Caseta && this.hashCode()==obj.hashCode();
	}



	@Override
	public String toString() {
		return String.format("Caseta %s Titulo %s ID calle %s en calle %s numero %s, modulos %s de clase %s.",
				id, titulo, id_calle, calle, numero, modulos, clase);
	}
	
	
	
	
	
	
}
