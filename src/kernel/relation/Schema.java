package kernel.relation;
import java.util.ArrayList;

import javax.management.AttributeNotFoundException;

import kernel.relation.operator.Request;

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
		this.primaryKey = new ArrayList<Attribute>();
		this.primaryKey.add(primaryKey);
	}
	public Schema(Schema schema,Request r) {
		this.name=name+r.getId();
		this.attributes=schema.attributes;
		this.primaryKey = r.getRelation().getPM();

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

	public ArrayList<Attribute> getPM() {
		return this.primaryKey;
	}

}
