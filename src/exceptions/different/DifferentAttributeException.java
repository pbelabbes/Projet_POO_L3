package exceptions.different;

public class DifferentAttributeException extends Exception {

	public DifferentAttributeException() {
		System.out.println("Cette attibrut n'existe pas dans la table");
	}
}
