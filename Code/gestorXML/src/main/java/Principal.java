package main.java;

import java.util.List;

import main.java.model.Estudiante;
import main.java.xml.reader.LectorXML;

public class Principal {

	public static void main(String[] args) {
		String ruta = "files/estudiantes.xml";
		List<Estudiante> estudiantes = new LectorXML().cargarEstudiantes(ruta);
		
		for(Estudiante e : estudiantes) {
			System.out.println(e);
		}
	}
	
}
