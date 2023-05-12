package main.java.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import main.java.model.Estudiante;



public class JSONManager {
	
	public List<Estudiante> cargarDatos(String path) {
		List<Estudiante> estudiantes = null;
		Gson gson = new GsonBuilder().create();
		try {
			Estudiante[] array = gson.fromJson(new FileReader(new File(path)), Estudiante[].class);
			
			estudiantes= new ArrayList<>(Arrays.asList(array));
			System.out.println();
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return estudiantes;
	}
	
	public void toJSON(List<Estudiante> estudiante, String path) {
		Gson gson = new GsonBuilder().setPrettyPrinting().enableComplexMapKeySerialization().create();
		
		try {
			File archivo = new File(path);
			archivo.createNewFile();
			FileWriter fw = new FileWriter(new File(path));
			gson.toJson(estudiante, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
