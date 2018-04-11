package TypeBD;

public class DoubleBD extends TypePrimitif<Double>{

	protected DoubleBD(double v) {
		super(v);
	}

	@Override
	public int compare(Double o1, Double o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Double o1, Double o2) {
		return o1.equals(o2);
	}
	public String toString2() {
		return "DoubleBD";
	}
}
