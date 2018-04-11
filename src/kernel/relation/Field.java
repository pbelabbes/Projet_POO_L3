package kernel.relation;
import javax.xml.bind.TypeConstraintException;

import TypeBD.TypePrimitif;
import exceptions.different.DifferentTypeException;
import exceptions.notFound.TypeNotFoundException;


/**
 * classe de structure des champs presents dans les tuples
 */
public class Field<T> {

	private Attribute attribute;
	private TypePrimitif<T> value;
	

	/**
	 * Methode permettant de definir qu'un field est li� a un attribut et  a un type primitif
	 * @param a de type Attribute
	 * @param value de type TypePrimitif<T>
	 * @throws DifferentTypeException au cas ou le type est invalide
	 */
	public Field(Attribute a, TypePrimitif<T> value) throws DifferentTypeException {
		this.attribute=a;
		
//		if( value.getClass() != attribute.getClass()) throw new DifferentTypeException();
		this.value=value;
	}

	/**
	 * Methode permettant de recuperer le type primitif
	 * @return value de type TypePrimitif<T>
	 */
	public Object getValue() {
		return this.value.getValue();
	}
}
