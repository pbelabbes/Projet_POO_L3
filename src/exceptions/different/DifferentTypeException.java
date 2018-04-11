package exceptions.different;

public class DifferentTypeException extends Exception {

	public DifferentTypeException() {
		System.out.println("Type of value doesn't matche with type of attributes");
	}
}
