package kernel.relation;

import java.util.ArrayList;
import java.util.List;

import jus.util.assertion.Require;

public class Tuple {
	protected Index indice;
	protected ArrayList<Field> valeur;
	
	public Tuple(int indice, ArrayList<Field> listeValeurs) {
		this.indice = new Index(indice);
		valeur=listeValeurs;
	}
	
	public String getValue(int attributes){
		
		if(attributes<0 || attributes>=valeur.size())
			throw new Require("Il faut une valeur comprise entre 0 et "+(valeur.size()-1));
		
		return valeur.get(attributes).toString();
	}
	
	
	public ArrayList<Field> getValeurs(){		
		return valeur;			
	}
	
	public String toString() {
		String retour = "Tuple numero"+indice.getIndex()+" :";
		for(int i=0; i<valeur.size()-1; i++)
			retour+=valeur.get(i)+"|";
		retour+=valeur.get(valeur.size()-1);
		
		return retour;
	}

	public String displayData() {
		String disp="";
		
		for(Field f : valeur) {
			disp += f.getValue();
		}
		return disp;
	}
}
