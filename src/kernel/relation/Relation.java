package kernel.relation;
import java.util.ArrayList;
import java.util.Iterator;

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
			this.tuples.add(new Tuple(cntTuple,listF));
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

	public void displayTable() {
		System.out.println(this.schema.toString());
		System.out.println("with "+this.tuples.size()+" tuples");
		System.out.println(this.schema.displayAttributesNames());
		for(Tuple t : tuples) {
			System.out.println(t.displayData());
		}
		
	}
}
