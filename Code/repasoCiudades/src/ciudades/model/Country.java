package ciudades.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country {

	private String countryID;
	private String countryName;
	private List<City> listCities;
	
	public Country(String countryID, String countryName) {
		super();
		this.countryID = countryID;
		this.countryName = countryName;
		this.listCities = new ArrayList<>();
		try {
			cargarCities("files/city.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public List<City> getListCities() {
		return listCities;
	}


	public String getCountryID() {
		return countryID;
	}


	public String getCountryName() {
		return countryName;
	}


	private void cargarCities(String path) throws FileNotFoundException {
		File archivo = new File(path);	
		try {
			FileReader fr  = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String linea = br.readLine();
			
			while(linea!=null) {
				String[] lineaSep = linea.split(",");
				try {
					if(this.countryID.equals(lineaSep[2])) {
						listCities.add(new City(lineaSep[0], lineaSep[1]));
					}
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
	
	@Override
	public int hashCode() {
		return Objects.hash(countryID);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Country && this.hashCode()==obj.hashCode();
	}


	private String ciudadesToString() {
		StringBuilder sb = new StringBuilder();
		
		for(City c: listCities) {
			sb.append(c+"\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return String.format("CountryID %s, Nombre %s%nCiudades:%n	%s", countryID, countryName, ciudadesToString());
	}
	
	
	
}
