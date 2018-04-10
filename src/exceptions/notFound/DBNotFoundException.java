package exceptions.notFound;

public class DBNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBNotFoundException() {
		System.out.println("DataBase Not Found !");
	}
}
