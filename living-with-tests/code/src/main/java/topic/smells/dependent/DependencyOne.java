package topic.smells.dependent;

public class DependencyOne {
	private String value;

	public DependencyOne(String value) {
		this.value = value;
	}

	public String someMethod() {
		return value;
	}
}
