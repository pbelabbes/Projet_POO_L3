package kernel.relation;
import java.util.ArrayList;

public abstract class Relation {
	
	public static int ID =0;
	
	private int id;
	private Schema schema;
	private ArrayList<Tuple> tuples;
	private int cntTuple = 0;
	
	public Relation(Schema schema) {
		this.id = ID++;
		this.schema = schema;
	
	}
	
	public void addTuple(ArrayList<Field> listF) {
		if (listF.size()==this.schema.getAttributes().size()) {
			this.tuples.add(new_Tuple(listF,cntTuple));
		}
			
	}
	
	public void removeTuple(Tuple old_tuple) {
		this.tuples.remove(old_tuple);
	}

	public String toString() {
		return (this.getName()+" : "+this.tuples.size()+" tuples");
		
	}
	
	public String getName() {
		return this.schema.getName();
	}
}
