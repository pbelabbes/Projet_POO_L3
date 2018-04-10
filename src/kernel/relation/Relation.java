package kernel.relation;
import java.util.ArrayList;

public abstract class Relation {
	
	public static int ID =0;
	
	private int id;
	private Schema schema;
	private ArrayList<Tuple> tuples;
	
	public Relation(Schema schema) {
		this.id = ID++;
		this.schema = schema;
	
	}
	
	public void addTuple(Tuple new_tuple) {
		this.tuples.add(new_tuple);
	}
	
	public void removeTuple(Tuple old_tuple) {
		this.tuples.remove(old_tuple);
	}
}
