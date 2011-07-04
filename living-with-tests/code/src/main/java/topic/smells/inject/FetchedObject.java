package topic.smells.inject;

public class FetchedObject {

	private String name;

	public FetchedObject(String name) {
		this.name = name;
	}

	public boolean isCalled(String name) {
		return this.name.equals(name);
	}

}
