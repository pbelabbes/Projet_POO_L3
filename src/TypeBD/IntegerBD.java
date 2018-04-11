package TypeBD;

public class IntegerBD extends TypePrimitif<Integer>{

	protected IntegerBD(int v) {
		super(v);
	}

	@Override
	public boolean equals(Integer o1, Integer o2){
		return o1.equals(o2);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
	public String toString2() {
		return "IntegerBD";
	}
}
