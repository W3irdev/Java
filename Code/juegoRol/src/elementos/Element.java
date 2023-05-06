package elementos;

import java.util.Objects;

public class Element {

	protected ElementType type;

	public Element(ElementType type) {
		super();
		this.type = type;
	}

	public ElementType getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		return String.format("Elemento %s", type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ElementType e && this.hashCode()==e.hashCode();
	}
	
	
	
	
}
