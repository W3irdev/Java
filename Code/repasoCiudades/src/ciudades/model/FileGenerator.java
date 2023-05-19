package ciudades.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.w3c.dom.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileGenerator {

	private List<Country> countries;

	public FileGenerator() {
		super();
		this.countries=new ArrayList<>();
		cargarCountries("files/country.txt");
	}
	
	
	private void cargarCountries(String path) {
		File archivo = new File(path);
		
		try {
			FileReader fr = new FileReader(archivo);;
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String linea = br.readLine();
			
			while(linea!=null) {
				String[] lineaSep = linea.split(",");
				try {
					this.countries.add(new Country(lineaSep[0], lineaSep[1]));
				} catch (Exception e) {
				}
				linea=br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void toJSON(String path) {
		 File archivo = new File(path);
		 try {
			archivo.createNewFile();
			GsonBuilder json = new GsonBuilder();
			Gson gson = json.setPrettyPrinting().enableComplexMapKeySerialization().create();
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			gson.toJson(this.countries, bw);
			bw.close();
			fw.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void toCSV(String path) {
		try {
			File archivo = new File(path);
			archivo.createNewFile();
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			StringBuilder sb = new StringBuilder();
			sb.append("CountryID,CountryName,CityID,CityNname\n");
			sb.append("-------------------------------------\n");
			for(Country c:this.countries) {
				for(City ci:c.getListCities()) {
					sb.append(String.format("%s,%s,%s,%s%n", c.getCountryID(), c.getCountryName(), ci.getCityID(), ci.getCityName()));
				}
			}
			bw.write(sb.toString());
			bw.close();
			fw.close();
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void toXML(String path) {
		try {
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element nodoRaiz = doc.createElement("Countries");
			doc.appendChild(nodoRaiz);
			for(Country c:this.countries) {
				Element country = doc.createElement("Country");
				Attr atributoId = doc.createAttribute("id");
				Attr atributoName = doc.createAttribute("name");
				atributoId.setValue(c.getCountryID());
				atributoName.setValue(c.getCountryName());
				country.setAttributeNode(atributoId);
				country.setAttributeNode(atributoName);
				nodoRaiz.appendChild(country);
				Element ciudades = doc.createElement("Ciudades");
				for(City ci:c.getListCities()) {
					Element ciudad = doc.createElement("Ciudad");
					Attr ciudadId = doc.createAttribute("id");
					ciudadId.setValue(ci.getCityID());
					ciudad.setAttributeNode(ciudadId);
					ciudad.appendChild(doc.createTextNode(ci.getCityName()));
					ciudades.appendChild(ciudad);
					country.appendChild(ciudades);
					
					for(Address a:ci.getListAddress()) {
						
						
						Element calles = doc.createElement("Calles");
						Element calle = doc.createElement("Calle");
						Element calleNombre = doc.createElement("name");
						Attr calleId = doc.createAttribute("id");
						calleId.setValue(a.getAddressID());
						calle.setAttributeNode(calleId);
						calleNombre.appendChild(doc.createTextNode(a.getAddressDir()));
						calle.appendChild(calleNombre);
						calles.appendChild(calle);
						ciudades.appendChild(ciudad);
						
		
						
						
					}
				}
			}
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Country c:this.countries) {
			sb.append(c+"\n");
		}
		return sb.toString();
	}
	
	
}
