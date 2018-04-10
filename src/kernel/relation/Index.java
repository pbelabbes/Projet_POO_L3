package kernel.relation;

public class Index {

	private int indice;

	public Index(int indice) {
		this.indice = 1; 
	}
	
	
	public Index(Index bIndex) {
		this.indice = bIndex.indice+1;
	}


	public int getIndice() {
		return indice;
	}


	public void setIndice(int indice) {
		this.indice = indice;
	}
	
}
