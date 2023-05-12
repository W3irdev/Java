package main.java;

import java.util.ArrayList;
import java.util.List;

import main.java.json.JSONManager;
import main.java.model.Estudiante;
import main.java.model.Genero;
import main.java.xml.reader.LectorXML;
import main.java.xml.writer.EscritorXML;

public class Principal {

	public static void main(String[] args) {
		/*String ruta = "files/estudiantes.xml";
		List<Estudiante> estudiantes = new LectorXML().cargarEstudiantes(ruta);
		
		for(Estudiante e : estudiantes) {
			System.out.println(e);
		}
		
		new EscritorXML().escribirXML(estudiantes, "files/nuevos_estudiantes.xml");*/
		
		new JSONManager().cargarDatos("files/estudiantes.json");
		List<Estudiante> est = new ArrayList<>(
				List.of(new Estudiante(1, "jm", "c", "2002-1-1", Genero.HOMBRE),
						new Estudiante(2, "jma", "cd", "2002-1-2", Genero.HOMBRE),
						new Estudiante(3, "jmb", "cc", "2002-1-3", Genero.HOMBRE)
						));
		
		new JSONManager().toJSON(est, "files/estudiantesToJSON.json");
	
	}
	
	
	
}
