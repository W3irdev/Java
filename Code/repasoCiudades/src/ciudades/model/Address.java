package ciudades.model;

import java.util.Objects;

public class Address {

	private String addressID;
	private String addressDir;
	
	
	public Address(String addressID, String addressDir) {
		super();
		this.addressID = addressID;
		this.addressDir = addressDir;
	}


	@Override
	public int hashCode() {
		return Objects.hash(addressID);
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof Address && this.hashCode()==obj.hashCode();
	}


	public String getAddressDir() {
		return addressDir;
	}


	public String getAddressID() {
		return addressID;
	}


	@Override
	public String toString() {
		return String.format("ID %s, Direccion %s", addressID, addressDir);
	}
	
	
	
	
	
	
}
