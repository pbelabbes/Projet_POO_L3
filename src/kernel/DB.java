package kernel;
import java.util.ArrayList;

import exceptions.notFound.*;
import kernel.relation.Relation;

public class DB {

	private ArrayList<Relation> relations;

	private String name;

	public DB(String name ) {
		this.name = name;
		this.relations = new ArrayList<Relation>();
	}

	public DB(String name, ArrayList<Relation> relations) {
		this.name = name;
		this.relations = relations;
	}

	public void addRelation(Relation rel) {
		this.relations.add(rel);
	}

	public void deleteRelation(Relation rel) {
		this.relations.remove(rel);
	}

	public String getName() {
		return this.name;
	}

	public void showTables() {
		if(this.relations.isEmpty()) System.out.println("No table in the database");
		for(Relation table : this.relations) {
			System.out.println(table.toString());
		}
	}


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
