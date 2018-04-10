package TypeBD;

import java.util.Comparator;

/**
 * 
 *
 * @param <T>
 */
public interface TypePrimitif <T> extends Comparator<T>{
	
	/**
	 * Vrais si les 2 objets passés en parametre contiennent les meme valeurs
	 * @param o1 Un objet
	 * @param o2 Un autre objet
	 * @return o1 est egale a o2
	 */
	public boolean equals(T o1, T o2);
	
	public String toString2();
}

