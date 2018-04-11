package TypeBD;


public class StringBD extends TypePrimitif<String>{


	public StringBD(String v) {
		super(v);

	}



	@Override
	public int compare(String s1, String s2) {

		if(s1.length()>s2.length())
			return 1;
		else if (s1.length()<s2.length())
			return -1;

		return s1.toString().compareTo(s2.toString());

	}

	@Override
	public boolean equals(String o1, String o2) {
		return o1.equals(o2);
	}

	public String toString2() {
		return "StringBD" + ";" + ((String) (this.value)).length();
	}
}

