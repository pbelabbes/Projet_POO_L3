package kernel.relation;
import java.util.ArrayList;

import javax.management.AttributeNotFoundException;

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
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		String info;
		info = this.name+"(";
		for(Attribute a : attributes) {
			info += a.getName() +":"+a.getType().getSimpleName()+"  ";
		}
		
		return info;
	}

	public String displayAttributesNames() {
		String disp="";
		
		for(Attribute a : attributes) {
			disp += a.getName()+"  ";
		}
		
		return disp;
	}

	public Attribute getAttributesByName(String name) {
		Attribute res =null;
		for(Attribute a: attributes) {
			if(a.getName() == name) res = a;
		}
		
		if(res == null)
			try {
				throw new AttributeNotFoundException();
			} catch (AttributeNotFoundException e) {
				e.printStackTrace();
			}
		return res;
	}

}
