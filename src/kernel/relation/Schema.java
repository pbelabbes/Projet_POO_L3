package kernel.relation;
import java.util.ArrayList;

public class Schema {

	private String name;
	private ArrayList<Attribute> attributes;
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
	
	public String getName() {
		return this.name;
	}
}
