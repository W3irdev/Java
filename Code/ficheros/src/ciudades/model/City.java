package ciudades.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class City {

	private String id;
	private String name;
	private Set<Address> listAddress;
	public City(String id, String name) throws IOException {
		super();
		this.id = id;
		this.name = name;
		this.listAddress = new HashSet<>();
		setAddresses();
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public int sizeAddresses() {
		return this.listAddress.size();
	}
	
	private void setAddresses() throws IOException {
		FileReader addresses = new FileReader(new File("files/address.txt"));
		BufferedReader br = new BufferedReader(addresses);
		br.readLine();
		String line = br.readLine();
		String[] singleAddress;
		while(line!=null) {
			singleAddress=line.split(",");
			try {
				if(singleAddress[4].equals(this.id)) this.listAddress.add(new Address(singleAddress[0], singleAddress[1]));
				
			}catch (ArrayIndexOutOfBoundsException e) {
				e.getStackTrace();
			}
			line = br.readLine();
			
		}
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof City && this.hashCode()==obj.hashCode();
	}
	@Override
	public String toString() {
		return String.format("id: %s, nombre: %s Numero de direcciones: %s %n		", id, name, sizeAddresses());
	}
	
	
	
	
}
