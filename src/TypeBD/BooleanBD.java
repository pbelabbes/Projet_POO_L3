package TypeBD;

public class BooleanBD implements TypePrimitif<Boolean> {

	@Override
	public int compare(Boolean o1, Boolean o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Boolean o1, Boolean o2) {
		return o1.equals(o2);
	}
	
	public String toString2() {
		return "BooleanBD";
	}
	
}
