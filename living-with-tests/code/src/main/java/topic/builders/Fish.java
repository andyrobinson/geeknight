package topic.builders;

public class Fish {

	public enum Type {
		CATFISH, GOLDFISH, UNKNOWN
	}
	
	private final String name;
	private final int age;
	private final Type type;

	public Fish(String name, Type type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public int age() {
		return age;
	}

}
