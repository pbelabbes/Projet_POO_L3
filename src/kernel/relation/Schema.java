package kernel.relation;
import java.util.ArrayList;

public class Schema {

	private String name;
	private ArrayList<Attribute> attributes;
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	private ArrayList<Attribute> primaryKey;

	
	public Schema(String name, ArrayList<Attribute> attributes, ArrayList<Attribute> primaryKey) {
		this.name=name;
		this.attributes=attributes;
		this.primaryKey=primaryKey;
	}
	
	public Schema(String name, ArrayList<Attribute> attributes, Attribute primaryKey) {
		this.name=name;
		this.attributes=attributes;
		this.primaryKey.add(primaryKey);
	}
	
}
