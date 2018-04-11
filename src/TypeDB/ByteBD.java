package TypeBD;

public class ByteBD extends TypePrimitif<Byte> {

	public ByteBD(byte v) {
		super(v);
	}

	@Override
	public int compare(Byte o1, Byte o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Byte o1, Byte o2) {
		return o1.equals(o2);
	}

	public String toString2() {
		return "ByteBD";
	}
}
