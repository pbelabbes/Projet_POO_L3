package kernel;
import java.util.ArrayList;

import exceptions.notFound.*;
import kernel.relation.Relation;

public class DB {

	/**
	 * List of tables include in the database
	 */
	private ArrayList<Relation> relations;

	/**
	 * name of the database
	 */
	private String name;

	/**
	 * 
	 * @param name , name of the database
	 */
	public DB(String name ) {
		this.name = name;
		this.relations = new ArrayList<Relation>();
	}

	/**
	 * 
	 * @param name , name of the database 
	 * @param relations 
	 */
	public DB(String name, ArrayList<Relation> relations) {
		this.name = name;
		this.relations = relations;
	}

	/**
	 * 
	 * @param rel table that will be added in the database
	 */
	public void addRelation(Relation rel) {
		this.relations.add(rel);
	}

	/**
	 * 
	 * @param rel talbe that will be deleted in the database
	 */
	public void deleteRelation(Relation rel) {
		this.relations.remove(rel);
	}

	/**
	 * 
	 * @return the name of the database
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * show all the tables in the database
	 */
	public void showTables() {
		if(this.relations.isEmpty()) System.out.println("No table in the database");
		for(Relation table : this.relations) {
			System.out.println(table.toString());
		}
	}

	/**
	 * 
	 * @param table_name 
	 * @return
	 */
	public Relation getTableByName(String table_name) {
		
		Relation res = null;
		for(Relation table : relations){
			if(table.getName()==table_name) {
				res = table;
				break;
			}
		}
		try {
			if(res == null)	throw new RelationNotFoundException();
			} catch (RelationNotFoundException e) {}

	return res;
	}
}
