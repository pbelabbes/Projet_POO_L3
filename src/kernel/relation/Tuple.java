package Noyau;

import java.util.List;

import jus.util.assertion.Require;

public class Tuple {
	protected Index indice;
	protected List<String> valeur;
	
	public Tuple(int indice, List<String> listeValeurs) {
		this.indice = new Index(indice);
		valeur=listeValeurs;
	}
	
	public String getValue(int colonne){
		
		if(colonne<0 || colonne>=valeur.size())		
		return valeur.get(colonne);
	}
	
	
	public List<String> getValeurs(){		
		return valeur;			
	}
	
	public void setValue(int colonne, String nouvelleValeur) {
		
		if(colonne<0 || colonne>=valeur.size())		
		valeur.set(colonne, nouvelleValeur);
	}
	
	public String toString() {
		String retour = "Tuple numero"+indice.getIndex()+" :";
		for(int i=0; i<valeur.size()-1; i++)
			retour+=valeur.get(i)+"|";
		retour+=valeur.get(valeur.size()-1);
		
		return retour;
	}
}
