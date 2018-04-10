package kernel.relation.statefull;

import kernel.relation.Schema;

public class Fullfile extends Statefull {

	private String uri;
	private String name;
	
	public Fullfile(Schema schema) {
		super(schema);
		
	}

	/**
	 * Write
	 */
	public void save() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * read
	 */
	public void convert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		
		return "File :"+name+" at "+uri;
	}

	
}
