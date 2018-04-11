package kernel.relation;
import javax.xml.bind.TypeConstraintException;

import TypeBD.TypePrimitif;
import exceptions.different.DifferentTypeException;

public class Field<T> {

	private Attribute attribute;
	private TypePrimitif<T> value;
	
	public Field(Attribute a, TypePrimitif<T> value) throws DifferentTypeException {
		this.attribute=a;
		
		if( value.getClass() != attribute.getClass()) throw new DifferentTypeException();
		this.value=value;
	}

	public TypePrimitif<T> getValue() {
		return this.value;
	}
}
