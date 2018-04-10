package kernel.relation;

import java.util.List;

import jus.util.assertion.Require;

public class Tuple {
	protected Index indice;
	protected List<String> valeur;
	
	public Tuple(int indice, List<String> listeValeurs) {
		this.indice = new Index(indice);
		valeur=listeValeurs;
	}
	
	public String getValue(int attributes){	
		return valeur.get(attributes);
	}
	
	
	public List<String> getValeurs(){		
		return valeur;			
	}
	
	public void setValue(int attributes, String nouvelleValeur) {	
		valeur.set(attributes, nouvelleValeur);
	}
	
//	public String toString() {
//		String retour = "Tuple numero"+indice.getIndex()+" :";
//		for(int i=0; i<valeur.size()-1; i++)
//			retour+=valeur.get(i)+"|";
//		retour+=valeur.get(valeur.size()-1);
//		
//		return retour;
//	}
}
