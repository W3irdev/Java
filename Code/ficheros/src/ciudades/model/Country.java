package ciudades.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country {

	private String id;
	private String name;
	private List<City> listCities;
	public Country(String id, String name) throws IOException {
		super();
		this.id = id;
		this.name = name;
		this.listCities = new ArrayList<>();
		setCities();
		this.listCities.sort(new OrdenNumeroDireccionesComparator());

	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	private void setCities() throws IOException {
		FileReader cities = new FileReader(new File("files/city.txt"));
		BufferedReader br = new BufferedReader(cities);
		br.readLine();
		String line = br.readLine();
		String[] singleLine;
		while(line!=null) {
			singleLine=line.split(",");
			if(singleLine[2]!=null && singleLine[2].equals(this.id)) this.listCities.add(new City(singleLine[0], singleLine[1]));
			line = br.readLine();
		}
	}

	
	public String citiesToString() {
		StringBuilder sb = new StringBuilder();
		for(City c:this.listCities) {
			if(c!=null) {
				sb.append(c.toString());
			}
		}
		return sb.toString();
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Country && this.hashCode()==obj.hashCode();
	}
	@Override
	public String toString() {
		
	
		return String.format("id pais: %s, nombre pais: %s%n"
				+ "	Ciudades:%s %n"
				+ "		%s"
			, this.id, this.name, this.listCities.size(), citiesToString());
	}
	
	
	
	
}
