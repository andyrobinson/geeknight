package topic.smells.inject;

import java.util.ArrayList;
import java.util.List;

public class ObjectRepository {

	public List<FetchedObject> fetchAll() {
		
		// NB: in real world does something all heavyweight
		doSomethingHeavy();
		
		List<FetchedObject> all = new ArrayList<FetchedObject>();
		all.add(new FetchedObject("bob"));
		all.add(new FetchedObject("carol"));
		all.add(new FetchedObject("geez"));
		return all;
	}

	private void doSomethingHeavy() {
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
