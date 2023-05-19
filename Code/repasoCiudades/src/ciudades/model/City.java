package ciudades.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

	private String cityID;
	private String cityName;
	private List<Address> listAddress;
	
	public City(String cityID, String cityName) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
		this.listAddress = new ArrayList<>();
		try {
			cargarAddress("files/address.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarAddress(String path) throws Exception {
		File archivo = new File(path);
		if(archivo.exists()) {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String linea = br.readLine();
			
			while(linea != null) {
				String[] lineSep = linea.split(",");
				try {
					
					if(this.cityID.equals(lineSep[4])) {
						listAddress.add(new Address(lineSep[0], lineSep[1]));
					}
				} catch (Exception e) {
				}
				linea=br.readLine();
			}
			br.close();
			fr.close();
			
		}else throw new Exception("El fichero no existe");
		
	}

	public String getCityID() {
		return cityID;
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	public String getCityName() {
		return cityName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityID);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof City && this.hashCode()==obj.hashCode();
	}

	public String addressToString() {
		StringBuilder sb = new StringBuilder();
		
		for(Address a: listAddress) {
			sb.append(a+"\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {

		
		return String.format("CiudadID %s, Nombre %s %n	Calles: %n		%s", cityID, cityName, addressToString());
	}
	
	
	
	
}
