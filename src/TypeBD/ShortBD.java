package TypeBD;

public class ShortBD extends TypePrimitif<Short> {

	public ShortBD(short v) {
		super(v);
	}

	@Override
	public int compare(Short o1, Short o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Short o1, Short o2) {
		return o1.equals(o2);
	}
	
	public String toString2() {
		return "ShortBD";
	}
}
