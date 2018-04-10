package TypeBD;

public class CharacterBD implements TypePrimitif<Character>{

	
	@Override
	public int compare(Character o1, Character o2) {
		return o1.compareTo(o2);
	}
	
	@Override
	public boolean equals(Character o1, Character o2) {
		return o1.equals(o2);
	}
	
	public String toString2() {
		return "CharacterBD";
	}

	
}
