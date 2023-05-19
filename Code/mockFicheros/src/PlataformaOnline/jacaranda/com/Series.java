package PlataformaOnline.jacaranda.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Series {

	private HashMap<String, Serie> mapSeries;
	
	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	public Series(String path) {
		mapSeries=new HashMap<String, Serie>();
		try {
			File series = new File(path);
			if(!series.exists())throw new SerieException("El archivo no existe");
			FileReader fr = new FileReader(series);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null) {
				try {
					String[] lineaSeparada = linea.split(",");
					if(!mapSeries.containsKey(lineaSeparada[0])) {
						mapSeries.put(lineaSeparada[0], new Serie(lineaSeparada[0], Integer.valueOf(lineaSeparada[1]) , Tema.valueOf(lineaSeparada[2])));
					}
					linea=br.readLine();
				} catch (Exception e) {
					linea=br.readLine();
				}
			}
			
			
		} catch (IOException | SerieException e) {
			e.printStackTrace();
		}
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

	public int numeroTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		if(!mapSeries.containsKey(nombreSerie)) throw new SerieException("Esa serie no existe");
	return mapSeries.get(nombreSerie).numeroTemporadas();
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema(String nombreSerie, Tema nuevoTema) throws SerieException{
		if(!mapSeries.containsKey(nombreSerie)||mapSeries.get(nombreSerie).getTema().equals(nuevoTema)) {
			throw new SerieException("La serie no existe, o el tema es identico.");
		} 
		mapSeries.get(nombreSerie).setTema(nuevoTema);		
	}
	
	
	
	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción.
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		List<Serie> serieTemaOrdenado = new ArrayList<>();
		for(Serie s:mapSeries.values()) {
			if(s.getTema().equals(tema)) {
				serieTemaOrdenado.add(s);
			}
		}
		if(serieTemaOrdenado.isEmpty()) throw new SerieException("No existe serie de ese tema");
		
		Collections.sort(serieTemaOrdenado);
		
		return serieTemaOrdenado.toString();
	}
	
	//Ficheros
	
	public void generarSeriesCSV() {
		try {
			FileWriter fw = new FileWriter("files/Series.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("nombreSerie,anno,tema");
			bw.newLine();
			bw.append("--------------------");
			bw.newLine();
			for(Serie s:this.mapSeries.values()) {
				bw.append(String.format("%s,%s,%s", s.getNombreSerie(),s.getAnno(),s.getTema().toString()));
				bw.newLine();

			}
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generarCapitulosCSV() {
		try {
			FileWriter fw = new FileWriter("files/Capitulos.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("nombreSerie,nombreTemporada,nombreCapitulo");
			bw.newLine();
			bw.append("-----------------------------------------------------------------");
			bw.newLine();
			for(Serie s:this.mapSeries.values()) {
				for(Temporada t:s.getTemporadas()) {
					for(String c : t.getCapitulos()) {
						bw.append(String.format("%s,%s,%s", s.getNombreSerie(),t.getNombreTemporada(),c));
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
	
	public void generarXML(String path) {
		
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element series =doc.createElement("series");
			doc.appendChild(series);
			for(Serie s:this.mapSeries.values()) {
				Element serie = doc.createElement("serie");
				series.appendChild(serie);
				Element nombre = doc.createElement("nombre");
				Element year = doc.createElement("year");
				Element tema = doc.createElement("tema");
				nombre.appendChild(doc.createTextNode(s.getNombreSerie()));
				year.appendChild(doc.createTextNode(String.valueOf(s.getAnno())));
				tema.appendChild(doc.createTextNode(String.valueOf(s.getTema())));
				serie.appendChild(nombre);
				serie.appendChild(year);
				serie.appendChild(tema);
				
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
	
	
}
