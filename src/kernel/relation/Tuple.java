package kernel.relation;

import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeNotFoundException;

import jus.util.assertion.Require;

public class Tuple {
	protected Index indice;
	protected ArrayList<Field> valeur;
	protected Relation r;

	public Tuple(Relation r, ArrayList<Field> listeValeurs) {
		this.r = r;
		this.indice = new Index(r.getCnt());
		valeur=listeValeurs;
	}

	public Tuple(Tuple t) {
		this.r = null;
		this.valeur = t.valeur;
		this.indice = null;
	}

	public void setRelation(Relation r) {
		this.r = r;
		this.indice = new Index(r.getCnt());
	}

	public String getValue(int attributes){

		if(attributes<0 || attributes>=valeur.size())
			throw new Require("Il faut une valeur comprise entre 0 et "+(valeur.size()-1));

		return valeur.get(attributes).toString();
	}


	public ArrayList<Field> getValeurs(){		
		return valeur;			
	}


	public Field getFieldByAttribute(Attribute a) {
		Field res = null;
		for(Field f : valeur) {
			if(f.getAttribut().getName() == a.getName()) {
				res = f;
				break;
			}
		}
		
		return res;
	}


	public String toString() {
		String retour = "Tuple numero"+indice.getIndice()+" :";
		for(int i=0; i<valeur.size()-1; i++)
			retour+=valeur.get(i)+"|";
		retour+=valeur.get(valeur.size()-1);

		return retour;
	}

	public String displayData() {
		String disp="";

		for(Field f : valeur) {
			disp += f.getValue()+"  ";
		}

		return disp;
	}

	public ArrayList<Field> getFields() {
		return this.getValeurs();
	}
}

