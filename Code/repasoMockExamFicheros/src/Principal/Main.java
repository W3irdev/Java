package Principal;

import java.util.Scanner;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;

public class Main {

	
	
	public static void main(String[] args) {
		
		Series series = new Series();
		try {
//			series.annadirSerie("This is us", 2015, Tema.DRAMA);
//			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
//			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
//			series.annadirTemporada("This is us", "Empezamos");
//			series.annadirTemporada("Dallas", "Empezamos Dallas");
//			series.annadirTemporada("This is us", "Seguimos");
//			series.annadirTemporada("This is us", "Finalizamos");
//			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
//			series.annadirCapituloTemporada("Dallas", "Empezamos Dallas", "La familia de Dallas");
//			series.annadirCapituloTemporada("Dallas", "Empezamos Dallas", "La familia de Dallas2");
//			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
//			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema no es problema");
//			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
//			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
//			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
//			
//			//series.seriesFromJSON("files/series.json");
//			series.toXML();
//			
			series.cargarXML("files/Series.xml");
			System.out.println(series);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
}
