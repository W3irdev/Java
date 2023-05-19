package PlataformaOnline.jacaranda.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Series {

	private HashMap<String, Serie> mapSeries;
	
	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		super();
		mapSeries=new HashMap<String, Serie>();
	}
	
	
	/** Añade una serie a la lista de series. Si existe una serie con el mismo nombre lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	
	/** Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}
	
	
	/** Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}
	
	
	/** Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}
	
	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por parámetro
	 * Si no existe la serie saltará la excepción.
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		if(!this.mapSeries.values().contains(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		return this.mapSeries.get(nombreSerie).getNumTemporadas();
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema( String nombreSerie, Tema nuevoTema) throws SerieException {
		
		if(!this.mapSeries.values().contains(nombreSerie)) {
			throw new SerieException("Esa serie no existe");
		}else if(this.mapSeries.get(nombreSerie).getTema().equals(nuevoTema)) {
			throw new SerieException("Esa serie es del mismo tema, no se puede cambiar");
		}
		
		this.mapSeries.get(nombreSerie).setTema(nuevoTema);
		
	}
	
	
	
	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción.
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public  String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		List<Serie> ordenados = new ArrayList<>();

		for(Serie e: this.mapSeries.values()) {
			if(e.getTema().equals(tema)) {
				ordenados.add(e);
			}
		}
		Collections.sort(ordenados);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre, Año, Numero de temporadas \n");
		for(Serie e:ordenados) {
			sb.append(String.format("%s, %s, %s%n", e.getNombreSerie(),e.getAnno(),e.getNumTemporadas()));
		}
		
		
		return sb.toString();
	}
	
	public void seriesToCsv() {
		File exportado = new File("files/Series.csv");
		try {
			exportado.createNewFile();
			FileWriter fw = new FileWriter(exportado);
			BufferedWriter bw = new BufferedWriter(fw);			
			bw.append("nombreSerie,anno,tema");
			bw.append("--------------------");
			for(Serie s:this.mapSeries.values()) {
				bw.append(String.format("%s,%s,%s", s.getNombreSerie(), s.getAnno(), s.getTema().toString()));
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void seriesToJSON() {

		File exportado = new File("files/series.json");
		try {
			exportado.createNewFile();
			Gson gson = new GsonBuilder().setPrettyPrinting().enableComplexMapKeySerialization().create();
			FileWriter fw = new FileWriter(exportado);
			BufferedWriter bw = new BufferedWriter(fw);
			gson.toJson(this.mapSeries, bw);
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public void capitulosToCsv() {
		File exportado = new File("files/Capitulos.csv");
		try {
			exportado.createNewFile();
			FileWriter fw = new FileWriter(exportado);
			BufferedWriter bw = new BufferedWriter(fw);			
			bw.append("nombreSerie,nombreTemporada,nombreCapitulo\n");
			bw.append("-----------------------------------------------------------------\n");
			for(Serie s:this.mapSeries.values()) {
				for(Temporada t : s.toList()) {
					for(String c:t.toList()) {
						bw.append(String.format("%s,%s,%s", s.getNombreSerie(), t.getNombreTemporada(), c));
						bw.newLine();
					}
				}
				
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cargarXML(String path) {
		try {
			File archivo = new File(path);
			DocumentBuilder document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
			Document doc = document.parse(archivo);
			doc.getDocumentElement().normalize();
			NodeList series = doc.getElementsByTagName("Series");
			NodeList temporadas = doc.getElementsByTagName("Temporadas");
			for(int i=0; i<series.getLength();i++) {
				Element nodo = (Element) series.item(i);
				String nombreSerie = nodo.getAttribute("Name");
				int anno = Integer.valueOf(nodo.getElementsByTagName("Year").item(0).getTextContent());
				Tema tema = Tema.valueOf(nodo.getElementsByTagName("Tema").item(0).getTextContent());
				Serie s = new Serie(nombreSerie, anno, tema);
				for(int j=0; j<temporadas.getLength();j++) {
					Element nodo2 = (Element) temporadas.item(j);
					String nombreTemporada = nodo2.getAttribute("Name");
					s.annadirTemporada(nombreTemporada);
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException | SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cargarDatos(String path) {
		File archivo = new File(path);
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			br.readLine();
			String linea = br.readLine();
			while(linea!=null) {
				String[] lineaSep = linea.split(",");
				
				this.mapSeries.put(lineaSep[0], new Serie(lineaSep[0], Integer.valueOf(lineaSep[1]), Tema.valueOf(lineaSep[2]) ));
				
				linea=br.readLine();
			}
			
			br.close();
			fr.close();
		} catch (IOException | NumberFormatException | SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void seriesFromJSON(String path) {
		List<Serie> series = null;
		File archivo = new File(path);
		try {
			Gson gson = new GsonBuilder().create();
			FileReader fr = new FileReader(archivo);
			
			Serie[] s = gson.fromJson(fr, Serie[].class);
		
			series = new ArrayList<>(Arrays.asList(s));
			for(Serie se:series) {
				this.mapSeries.put(se.getNombreSerie(), se);
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void toXML() {
		File archivo = new File("files/Series.xml");
		try {
			
			archivo.createNewFile();
			
			Document doc = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();
			Node series = doc.createElement("Series");
			doc.appendChild(series);
			for(Serie s:this.mapSeries.values()) {
				Element serie = doc.createElement("Serie");
				series.appendChild(serie);
				Attr nameSerie = doc.createAttribute("Name");
				nameSerie.setValue(s.getNombreSerie());
				serie.setAttributeNode(nameSerie);
				Element anno = doc.createElement("Year");
				anno.setTextContent(String.valueOf(s.getAnno()));
				serie.appendChild(anno);
				Element tema = doc.createElement("Tema");
				tema.setTextContent(String.valueOf(s.getTema()));
				serie.appendChild(tema);
				
				Element temporadas = doc.createElement("Temporadas");
				serie.appendChild(temporadas);
				for(Temporada t:s.getTemporadas()) {
					Element temporada = doc.createElement("Temporada");
					Attr nameTemp = doc.createAttribute("Name");
					nameTemp.setValue(t.getNombreTemporada());
					temporada.setAttributeNode(nameTemp);
					Element capitulos = doc.createElement("Capitulos");
					StringBuilder sb = new StringBuilder();
					for(String c:t.getCapitulos()) {
						sb.append(c+", ");
						capitulos.setTextContent(sb.toString());
					}
					
					
					temporada.appendChild(capitulos);
					temporadas.appendChild(temporada);
				}
				
				
				
			}
			
			Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(archivo);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			
			
		} catch (IOException | ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
