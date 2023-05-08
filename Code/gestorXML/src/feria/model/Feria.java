package feria.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

public class Feria {

	private List<Caseta> casetas;


	public Feria(String path) {
		super();
		casetas = new ArrayList<>();
		cargarCasetas(path);
	}


	private void cargarCasetas(String path){
		File fichero = new File(path);
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document documento = builder.parse(fichero);
			documento.getDocumentElement().normalize();
			NodeList listaNodosCasetas = documento.getElementsByTagName("DatosLeidos");
			
			for(int i=0; i<listaNodosCasetas.getLength();i++) {
				Element nodo = (Element) listaNodosCasetas.item(i);
				String id = nodo.getElementsByTagName("ID").item(0).getTextContent();
				String titulo = nodo.getElementsByTagName("TITULO").item(0).getTextContent();
				String calle = nodo.getElementsByTagName("CALLE").item(0).getTextContent();
				String numero = nodo.getElementsByTagName("NUMERO").item(0).getTextContent();
				String modulos = nodo.getElementsByTagName("MODULOS").item(0).getTextContent();
				String clase = nodo.getElementsByTagName("CLASE").item(0).getTextContent();
				String entidad = nodo.getElementsByTagName("ENTIDAD").item(0)!=null?nodo.getElementsByTagName("ENTIDAD").item(0).getTextContent():" ";
				String idCalle = nodo.getElementsByTagName("ID_CALLE").item(0).getTextContent();
				
				Caseta caseta = new Caseta(titulo, calle, numero, modulos, clase, entidad, id, idCalle);
				this.casetas.add(caseta);
				
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String mostrarCasetasCalle(String calle) {
		StringBuilder sb = new StringBuilder();
		
		for(Caseta c:casetas) {
			if(c!=null && c.getCalle().equals(calle)) sb.append(c+"\n");
		}
		
		return sb.toString();
	}
	
	public String mostrarCasetasTipo(String tipo) {
		StringBuilder sb = new StringBuilder();
		
		for(Caseta c:casetas) {
			if(c!=null && tipo.equals("OTROS") && !c.getClase().equals("FAMILIAR") && !c.getClase().equals("DISTRITO")) {
				sb.append(c+"\n");
			}else if((c!=null && c.getClase().equals(tipo))) {
				sb.append(c+"\n");
			}
		}
		
		return sb.toString();
	}
	
	public int contarCasetas(String tipo) {
		
		int contador=0;
		for(Caseta c:casetas) {
			if(c!=null && c.getClase().equals(tipo)) contador++;
		}
		
		return contador;
	}
	
	public void eliminarCaseta(String calle, String numero) throws Exception {
		Iterator<Caseta> it = this.casetas.iterator();
		int moduloBorrado=0;
		boolean borrado=false;
		while(it.hasNext()) {
			Caseta caseta = it.next();
			if(caseta.getCalle().equals(calle) && caseta.getNumero().equals(numero)) {
				moduloBorrado=Integer.parseInt(caseta.getModulos()) ;
				it.remove();
				borrado=true;
			}else if(caseta.getCalle().equals(calle) && Integer.parseInt(caseta.getNumero()) > Integer.parseInt(numero)) {
				caseta.restarNumero(moduloBorrado);
			}
			
		}
		if(!borrado) throw new Exception("La calle o el numero no existe");
	}
	
	public void exportarJson() throws IOException {
		File exportado = new File("./files/casetas.json");
		exportado.createNewFile();
		Gson gson = new Gson();
		String datos = gson.toJson(casetas);
		FileWriter fw = new FileWriter(exportado);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append(datos);
		bw.close();
		fw.close();
		
	}
	
}
