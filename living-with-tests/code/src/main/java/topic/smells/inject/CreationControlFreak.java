package topic.smells.inject;

import java.util.List;

public class CreationControlFreak {

	public FetchedObject fetchSomeObjectCalled(String name) {
		
		ObjectRepository repository = new ObjectRepository();
		List<FetchedObject> all = repository.fetchAll();
		for (FetchedObject candidate : all) {
			if (candidate.isCalled(name)) {
				return candidate;
			}
		}
		return null;
	}

}
