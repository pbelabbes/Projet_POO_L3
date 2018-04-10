package kernel;

import java.util.ArrayList;

public class SGBD {
	
	private static ArrayList<DB> DBs = new ArrayList<DB>();

	public static DB getDbByName(String db_name) {
		return null;
	}
	
	public static void addDB(DB new_database) {
		DBs.add(new_database);
	}
	
}
