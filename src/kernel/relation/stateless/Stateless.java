package kernel.relation.stateless;

import kernel.relation.Relation;
import kernel.relation.Schema;
import kernel.relation.operator.Request;

public abstract class Stateless extends Relation {

	Request req;
	
	public Stateless(Schema schema) {
		super(schema);
	}
	

}
