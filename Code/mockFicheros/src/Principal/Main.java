package Principal;

import java.util.Scanner;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;

public class Main {

	
	
	public static void main(String[] args) {
		
		Series series = new Series();
		try {
			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
			series.annadirCapituloTemporada("This is us", "Seguimos", "La familia2");
			series.annadirCapituloTemporada("This is us", "Seguimos", "El problema2");
			series.annadirCapituloTemporada("This is us", "Seguimos", "Los niños2");
			series.annadirCapituloTemporada("This is us", "Seguimos", "CAsi el final2");
			series.annadirCapituloTemporada("This is us", "Seguimos", "El final2");
			
			series.generarCapitulosCSV();
			series.generarSeriesCSV();
		} catch (SerieException e) {
			e.printStackTrace();
		}
		
		Series archivo = new Series("files/Series.csv");
		try {
			System.out.println(archivo.listadoOrdenadoSeriesDeUnTema(Tema.valueOf("INTRIGA")));
			archivo.generarXML("files/SeriesEnXML.xml");
			
		} catch (SerieException e) {
			e.printStackTrace();
		}

	}
	
	
}
