package TypeBD;

public class FloatBD extends TypePrimitif<Float>{

	public FloatBD(float v) {
		super(v);
	}

	@Override
	public int compare(Float o1, Float o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Float o1, Float o2) {
		return o1.equals(o2);
	}
	public String toString2() {
		return "FloatBD";
	}
	
}
