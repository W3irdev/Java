package ciudades.main;

import ciudades.model.City;
import ciudades.model.FileGenerator;

public class main {

	public static void main(String[] args) {


		FileGenerator countries = new FileGenerator();
		countries.toJSON("files/CountriesJSON.json");
		countries.toCSV("files/CountriesCSV.csv");
		countries.toXML("files/CountriesXML.xml");
		System.out.println(countries);
		
	}

}
