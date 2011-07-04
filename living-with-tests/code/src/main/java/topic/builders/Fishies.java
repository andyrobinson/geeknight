package topic.builders;

import java.util.List;

public class Fishies {

	private List<Fish> fishies;

	public Fishies(List<Fish> fish) {
		this.fishies = fish;
	}

	public Integer lifeMean() {
		return totalAge(fishies) / fishies.size();
	}

	private int totalAge(List<Fish> fishies) {
		int total = 0;
		for (Fish fish : fishies) {
			total += fish.age();
		}
		return total;
	}

	public void addFish(String name, int age) {
		fishies.add(new Fish(name, Fish.Type.UNKNOWN, age));
	}

}
