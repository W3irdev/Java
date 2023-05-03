package ciudades.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class FileCountryGenerator {

	private Set<Country> countries;
	
	
	
	public FileCountryGenerator() throws IOException {
		super();
		this.countries = new HashSet<>();
		setCountries();
	}



	private void setCountries() throws IOException {
		FileReader countries = new FileReader(new File("files/country.txt"));
		BufferedReader br = new BufferedReader(countries);
		br.readLine();
		String line = br.readLine();
		
		while(line!=null) {
			String[] singleLine = line.split(",");
			this.countries.add(new Country(singleLine[0], singleLine[1]));
			line=br.readLine();
			
		}
	}

	public void generateFile() throws IOException {
		File documento = new File("files/generado.txt");
		documento.createNewFile();
		FileWriter fw = new FileWriter(documento);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Country c:countries) {
			bw.append(c.toString());
			bw.newLine();
		}
		bw.close();
		fw.close();
		
	}


	public void generateJson() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(countries);
		File documento = new File("files/generadoJSON.json");
		documento.createNewFile();
		FileWriter fw = new FileWriter(documento);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append(json);
		bw.close();
		fw.close();

	}
	
	
	
}
