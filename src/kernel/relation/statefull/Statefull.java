package kernel.relation.statefull;

import kernel.relation.Relation;
import kernel.relation.Schema;

public abstract class Statefull extends Relation {

	protected static int CNT = 0;
	protected int id;
	
	public Statefull(Schema schema) {
		super(schema);
		this.id = CNT++;
	}

	
	
	public abstract void save();
	
	public abstract void convert();
	
	public abstract String toString();
}
