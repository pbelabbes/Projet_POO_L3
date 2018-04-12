package kernel.relation;
import java.util.ArrayList;

import javax.management.AttributeNotFoundException;

public class Schema {

	private String name;
	private ArrayList<Attribute> attributes;
	
	/**
	 * Accesseur a la liste d'attribut
	 * @return attributes de type ArrayList
	 */
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	
	/**
	 * methode permettant de definir les attributs
	 * @param attributes de type
	 */
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	
	private ArrayList<Attribute> primaryKey;

	/**
	 * methode permettant de definir un attribut comme clé primaire
	 * @param name de type String
	 * @param attributes de type ArrayList<Attribute>
	 * @param primaryKey de type ArrayList<Attribute>
	 */
	public Schema(String name, ArrayList<Attribute> attributes, ArrayList<Attribute> primaryKey) {
		this.name=name;
		this.attributes=attributes;
		this.primaryKey=primaryKey;
	}
	
	/**
	 * methode permettant de definir la clé primaire
	 * @param name de type String
	 * @param attributes de type ArrayList<Attribute>
	 * @param primaryKey de type ArrayList<Attribute>
	 */
	public Schema(String name, ArrayList<Attribute> attributes, Attribute primaryKey) {
		this.name=name;
		this.attributes=attributes;
		this.primaryKey = new ArrayList<Attribute>();
		this.primaryKey.add(primaryKey);
	}
	
	/**
	 * methode permettant de recuperer le nom de la relation
	 * @return name de type String
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * methode permettant de retourner les informations du schema
	 * @return info
	 */
	public String toString() {
		String info;
		info = this.name+"(";
		for(Attribute a : attributes) {
			info += a.getName() +":"+a.getType().getSimpleName()+"  ";
		}
		
		return info;
	}
	
	/**
	 * methode permettant de recup le nom des attribut
	 * @return disp 
	 */
	public String displayAttributesNames() {
		String disp="";
		
		for(Attribute a : attributes) {
			disp += a.getName()+"  ";
		}
		
		return disp;
	}
	
	/**
	 * methode permettant de recup un attribut grace a son nom
	 * @return res
	 */
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
