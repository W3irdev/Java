package mockExam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import mockExam.model.Combinacion;
import mockExam.model.CombinacionException;
import mockExam.model.Historial;

public class Main {

	public static void main(String[] args) {

		
		try {
			Historial historial = new Historial("C:\\Users\\darsh\\Desktop\\DAW\\Programacion\\Java\\Code\\ficheros\\src\\mockExam\\model\\Euromillones.csv");
			Combinacion combi = new Combinacion(10,23,34,43,5,2,5);
			//System.out.println(Historial.estadisticas());
			System.out.println(historial.numeroMenosRepetido());
			System.out.println(historial.numeroMasRepetido());
			System.out.println(historial.maximoAciertosEstadistico(combi));
			System.out.println(historial.maximoConsecutivos());
		} catch (IOException | CombinacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	
		
		
	}

}
