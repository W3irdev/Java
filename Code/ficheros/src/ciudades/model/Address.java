package ciudades.model;

import java.util.Objects;

public class Address implements Comparable<Address>{

	private String id;
	private String name;
	public Address(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		boolean equal = this == obj;
		
		if (obj!=null && !equal && (obj instanceof Address a)) {
			equal = this.id == a.id;
		}
		return equal;
	}
	@Override
	public String toString() {
		return String.format("id: %s, nombre: %s%n", id, name);
	}
	@Override
	public int compareTo(Address o) {
		return this.name.compareTo(o.name);
	}
	
	
	
	
}
