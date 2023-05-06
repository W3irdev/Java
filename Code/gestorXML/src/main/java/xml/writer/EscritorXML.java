package main.java.xml.writer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import main.java.model.Estudiante;

public class EscritorXML {

	/*public void escribirXML(List<Estudiante> estudiantes, String path) {
	
		
		try {
		
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element nodoRaiz = doc.createElement("estudiantes");
			doc.appendChild(nodoRaiz);
			Element primerNodoHijo = doc.createElement("estudiante");
			Attr atributoId = doc.createAttribute("id");
			atributoId.setValue("001");
			primerNodoHijo.setAttributeNode(atributoId);
			
			nodoRaiz.appendChild(primerNodoHijo);
			
			Element nombreEstudiante = doc.createElement("nombre");
			nombreEstudiante.appendChild(doc.createTextNode("Juan"));
			primerNodoHijo.appendChild(nombreEstudiante);
			
			Element apellidoEstudiante = doc.createElement("apellido");
			apellidoEstudiante.appendChild(doc.createTextNode("Gomez"));
			primerNodoHijo.appendChild(apellidoEstudiante);
			
			
			
			
			
			
			Transformer optimus = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));	
			optimus.setOutputProperty(OutputKeys.INDENT, "yes");
			optimus.transform(source, result);
			
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		
	}*/
	
	public void escribirXML(List<Estudiante> estudiantes, String path) {
	
		
		try {
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element nodoRaiz = doc.createElement("estudiantes");
			doc.appendChild(nodoRaiz);
			for(Estudiante e:estudiantes) {
				
				Element primerNodoHijo = doc.createElement("estudiante");
				Attr atributoId = doc.createAttribute("id");
				atributoId.setValue(String.valueOf(e.getId()) );
				primerNodoHijo.setAttributeNode(atributoId);
				
				nodoRaiz.appendChild(primerNodoHijo);
				
				Element nombreEstudiante = doc.createElement("nombre");
				nombreEstudiante.appendChild(doc.createTextNode(e.getNombre()));
				primerNodoHijo.appendChild(nombreEstudiante);
				
				Element apellidoEstudiante = doc.createElement("apellido");
				apellidoEstudiante.appendChild(doc.createTextNode(e.getApellidos()));
				primerNodoHijo.appendChild(apellidoEstudiante);
				
				Element fechaNacimiento= doc.createElement("fechaNacimiento");
				fechaNacimiento.appendChild(doc.createTextNode(e.getFechaNacimiento()));
				primerNodoHijo.appendChild(fechaNacimiento);
				
				Element genero = doc.createElement("genero");
				genero.appendChild(doc.createTextNode(String.valueOf(e.getGenero())));
				primerNodoHijo.appendChild(genero);
			}
			
			
			
			
			Transformer optimus = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));	
			optimus.setOutputProperty(OutputKeys.INDENT, "yes");
			optimus.transform(source, result);
			
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		
	}
		
}
