package kernel.relation;
import javax.xml.bind.TypeConstraintException;

public class Field {

	private Attribute Attribute;
//	private Type value; ERROR, PAS LA BONNE METHODE
	
	public Field(Attribute a, Type value) {
		this.Attribute=a;
//		this.value=value;
	}
}
