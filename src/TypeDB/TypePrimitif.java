package TypeDB;

import java.util.Comparator;

/**
 * 
 *
 * @param <T>
 */
public abstract class TypePrimitif <T> implements Comparator<T>{
	
	
	protected Object value;
	
	
	protected TypePrimitif(Object v){
		this.value = v;
	}
	/**
	 * Vrais si les 2 objets passés en parametre contiennent les meme valeurs
	 * @param o1 Un objet
	 * @param o2 Un autre objet
	 * @return o1 est egale a o2
	 */
	public abstract boolean equals(T o1, T o2);
	
	public abstract String toString2();
}

=======
package TypeBD;

import java.util.Comparator;

/**
 * 
 *
 * @param <T>
 */
public abstract class TypePrimitif <T> implements Comparator<T>{
	
	
	protected Object value;
	
	
	protected TypePrimitif(Object v){
		this.value = v;
	}
	/**
	 * Vrais si les 2 objets passés en parametre contiennent les meme valeurs
	 * @param o1 Un objet
	 * @param o2 Un autre objet
	 * @return o1 est egale a o2
	 */
	public abstract boolean equals(T o1, T o2);
	
	public abstract String toString2();
	
	public Object getValue() {
		return this.value;
	}
	
}

>>>>>>> 00b62458be7ed1695fe034bb7cf30000877a214f:src/TypeBD/TypePrimitif.java
