package kernel;

import java.util.ArrayList;

import exceptions.notFound.DBNotFoundException;

public class SGBD {

	/**
	 * List of database
	 */
	private static ArrayList<DB> DBs = new ArrayList<DB>();

	/**
	 * Get the database by Name
	 * @param db_name,name of the database that is looking for
	 * @return the db fund, null if there is no database with the name corresponding to db_name
	 */
	public static DB getDbByName(String db_name){

		DB res = null;
		for(DB db : DBs){
			if(db.getName()==db_name) {
				res = db;
				break;
			}
		}
		try {
			if(res == null)	throw new DBNotFoundException();
			} catch (DBNotFoundException e) {}

	return res;
}
	
	/**
	 * 
	 * @param new_database
	 */
public static void addDB(DB new_database) {
	DBs.add(new_database);
}

}
