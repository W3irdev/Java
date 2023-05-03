package ciudades;

import java.io.IOException;

import ciudades.model.FileCountryGenerator;

public class Main {

	public static void main(String[] args) {

		try {
			FileCountryGenerator fcg = new FileCountryGenerator();
			fcg.generateFile();
			fcg.generateJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
