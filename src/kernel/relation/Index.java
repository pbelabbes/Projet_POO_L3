package kernel.relation;

import exceptions.notFound.TypeNotFoundException;

/**
 * @author leoso
 * classe de structure des index des tuples dans une relation
 */
public class Index {

	private int indice;
	
	/**
	 * Methode permettant de definir qu'un index prends des indices
	 * @param indice de type int
	 */
	public Index(int indice) {
		this.indice = 1; 
	}
	
	/**
	 * Methode permettant d'incrementer les indices 
	 * @param bIndex de type index
	 */
	public Index(Index bIndex) {
		this.indice = bIndex.indice+1;
	}

	/**
	 * Methode permettant de recuperer un indice dans l'index
	 * @return indice de type int
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * Methode permettant d'attibuer une valeur d'indice a un indice
	 * @param indice de type int
	 * 
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
}
