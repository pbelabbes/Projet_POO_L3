package kernel.relation;

import TypeBD.*;
import exceptions.notFound.TypeNotFoundException;

/**
 * Classe de structure des attributs
 * 
 */
public class Attribute {
	
	/**
	  * name of the attribute
	  */
	private String name;
	
	/**
	  * Type of the attribute
	  */
	private Class type;
	
	
	/**
	  * Attribute that represent the foreignKey 
	  */
	private Attribute foreignKey;

	/**
	 * Methode permettant de definir un attribut par son nom et son type
	 * @param name de type string
	 * @param type de type string
	 * @throws TypeNotFoundException au cas ou le type entr� ne correspond pas un type primitif defini
	 */
	public Attribute(String name,String type) {
		this.name = name;


		switch (type) {
		case "IntegerBD":
			this.type = IntegerBD.class;
			break;
		case "BooleanBD":
			this.type = BooleanBD.class;
			break;
		case "ByteBD":
			this.type = ByteBD.class;
			break;
		case "CharacterBD":
			this.type = CharacterBD.class;
			break;
		case "DoubleBD":
			this.type = DoubleBD.class;
			break;
		case "FloatBD":
			this.type = FloatBD.class;
			break;
		case "LongBD":
			this.type = LongBD.class;
			break;
		case "ShortBD":
			this.type = ShortBD.class;
			break;
		case "StringBD":
			this.type = StringBD.class;
			break;

		default:
			try {
				throw new TypeNotFoundException();
			} catch (TypeNotFoundException e) {	}
			
		}
		
	}
	
	public Attribute(Attribute a) {
		this.name=a.getName();
		this.type=a.getType();
	}
	
	
	/**
	 * Methode permettant de recuperer le type de l'attribut
	 * @return type de type Type
	 */
	public Class getType() {
		return this.type;
	}

	/**
	 * Methode permettant de recuperer le nom de l'attribut
	 * @return name de type string
	 */
	public String getName() {
		return this.name;
	}
}

