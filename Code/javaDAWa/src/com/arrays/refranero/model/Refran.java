package com.arrays.refranero.model;

import java.util.Objects;

public class Refran {

	private String contenido;
	
	
	
	public Refran(String contenido) {
		super();
		this.setContenido(contenido);
	}



	public String getContenido() {
		return contenido;
	}



	public void setContenido(String contenido) {
		this.contenido = contenido;
	}



	@Override
	public int hashCode() {
		return Objects.hash(contenido);
	}



	@Override
	public String toString() {
		return String.format("%s", contenido);
	}



	@Override
	public boolean equals(Object obj) {
		boolean igual = this == obj;

		if (obj==null||!(obj instanceof Refran)) {
			igual = false;
		}
		Refran other = (Refran) obj;
		this.contenido.equalsIgnoreCase(other.getContenido());
		
		return igual; 
	}

	public boolean contains(String palabra) {
		
		return (getContenido().contains(palabra));
	}

	
	/*8. Realizar un programa que presente el siguiente menú:
1. Guardar un refrán: Se solicitará la frase con el refrán y se guardará.
Si el refrán ya estaba, se mostrará un mensaje de error y no se
guardará.
2. Buscar un refrán que contenga una palabra: Se solicitará una
palabra y se buscará el primer refrán que contenga esa palabra. Si
no se encuentra se mostrará el mensaje de error
3. Listar refranes: Se mostrará por pantalla un listado de todos los
refranes guardados ordenados alfabéticamente. 
4. Salir.
NOTAS:
 Se guardarán un máximo de 50 refranes, si se intenta superar este
máximo se producirá un error.
 Debe crearse una clase Refrán, otra clase Refranes que contenga el
vector de Refrán y una clase Principal*/
	
	
	
}
