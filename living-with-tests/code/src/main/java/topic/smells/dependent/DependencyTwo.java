package topic.smells.dependent;

public class DependencyTwo {
	private String value;

	public DependencyTwo(String value) {
		this.value = value;
	}

	public String someMethod() {
		return value;
	}
}
