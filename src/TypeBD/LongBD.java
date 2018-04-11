package TypeBD;

public class LongBD extends TypePrimitif<Long>{

	public LongBD(long v) {
		super(v);
	}

	@Override
	public int compare(Long o1, Long o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Long o1, Long o2) {
		return o1.equals(o2);
	}
	
	public String toString2() {
		return "LongBD";
	}
}
