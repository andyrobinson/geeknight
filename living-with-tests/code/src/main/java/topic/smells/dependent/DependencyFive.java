package topic.smells.dependent;

public class DependencyFive {
	private String value;

	public DependencyFive(String value) {
		this.value = value;
	}

	public String someMethod() {
		return value;
	}
}
