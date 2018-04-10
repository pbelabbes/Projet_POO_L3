package kernel.relation;

import TypeBD.*;
import exceptions.notFound.TypeNotFoundException;

public class Attribute {

	private String name;
	private Class type;
	private Attribute foreignKey;


	public Attribute(String name,String type) throws TypeNotFoundException {
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
			throw new TypeNotFoundException();
		}
		
	}

	public Class getType() {
		return this.type;
	}

	public String getName() {
		return this.name;
	}
}
