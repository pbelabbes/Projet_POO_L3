package kernel.relation;

public class Index {

	private int id;

	public Index() {
		this.id = 1; 
	}
	
	
	public Index(Index bIndex) {
		this.id = bIndex.id+1;
	}
}
