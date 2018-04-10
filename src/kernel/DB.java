package kernel;
import java.util.ArrayList;

import kernel.relation.Relation;

public class DB {

	private ArrayList<Relation> relations;
	
	private String name;
	
	public DB(String name ) {
		this.name = name;
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
	
	
}
