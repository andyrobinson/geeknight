package topic.smells.dependent;

public class DependencySix {
	private String value;

	public DependencySix(String value) {
		this.value = value;
	}

	public String someMethod() {
		return value;
	}
}
