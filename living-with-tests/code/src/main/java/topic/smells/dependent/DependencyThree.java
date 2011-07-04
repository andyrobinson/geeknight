package topic.smells.dependent;

public class DependencyThree {
	private String value;

	public DependencyThree(String value) {
		this.value = value;
	}

	public String someMethod() {
		return value;
	}
}
