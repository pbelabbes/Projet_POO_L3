package kernel.relation;
import java.util.ArrayList;
import java.util.Iterator;

import exceptions.different.DifferentAttributeException;


/**
 * Classe de structure de des Relations
 */
public abstract class Relation {

	public static int ID =0;

	private int id;
	private Schema schema;
	private ArrayList<Tuple> tuples;
	private int cntTuple ;


	/**
	 * Methode definissant qu'une relation a un id auto-incremente et un schema 
	 * @param schema de type Schema
	 */
	public Relation(Schema schema) {
		this.id = ID++;
		this.schema = schema;
		this.tuples = new ArrayList<Tuple>();
		this.cntTuple = 0;
	}

	/**
	 * Methode permettant d'ajouter un tuple a la relation
	 * @param listF de type ArrayList<Field>
	 */
	public void addTuple(ArrayList<Field> listF) {
		if (listF.size()==this.schema.getAttributes().size()) {
			this.tuples.add(new Tuple(this,listF));
		}
		
		this.cntTuple++;

	}

	/**
	 * Methode permettant de supprimer un tuple
	 * @param old_tuple de type Tuple
	 */
	public void removeTuple(Tuple old_tuple) {
		this.tuples.remove(old_tuple);
	}

	/**
	 * Methode permettant de recuperer un indice dans l'index
	 * @return le nom de la relation et la taille de la liste de tuples
	 */
	public String toString() {
		return (this.getName()+" : "+this.tuples.size()+" tuples");

	}

	/**
	 * Methode permettant de recuperer le nom de la relation dans le Schema
	 * @return le nom de la relation
	 */
	public String getName() {
		return this.schema.getName();
	}


	/**
	 * Methode permettant d'afficher :
	 * 1/le schema de la reation
	 * 2/le nombre de tuples dans cette relation
	 * 3/les nom des attributs et leurs valeur par tuple
	 */
	public void displayTable() {
		System.out.println(this.schema.toString());
		System.out.println("with "+this.tuples.size()+" tuples");
		System.out.println(this.schema.displayAttributesNames());
		for(Tuple t : tuples) {
			System.out.println(t.displayData());
		}

	}

	public Attribute getAttributeByName(String name) {
		return this.schema.getAttributesByName(name);
	}

	public int getCnt() {
		return this.cntTuple;
	}

	public void attributeExist(Attribute a) {

		this.getAttributeByName(a.getName());

	}

	public ArrayList<Tuple> getTuples() {
		return this.tuples;
	}
}
