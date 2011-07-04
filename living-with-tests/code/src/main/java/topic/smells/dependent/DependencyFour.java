package topic.smells.dependent;

public class DependencyFour {
	private String value;

	public DependencyFour(String value) {
		this.value = value;
	}

	public String someMethod() {
		return value;
	}
}
