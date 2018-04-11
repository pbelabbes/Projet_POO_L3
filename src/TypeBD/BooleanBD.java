package TypeBD;

public class BooleanBD extends TypePrimitif<Boolean> {

	
	public BooleanBD(boolean v) {
		super(v);
	}

	public int compare(Boolean o1, Boolean o2) {
		return o1.compareTo(o2);
	}

	public boolean equals(Boolean o1, Boolean o2) {
		return o1.equals(o2);
	}
	
	public String toString2() {
		return "BooleanBD";
	}
	
}
