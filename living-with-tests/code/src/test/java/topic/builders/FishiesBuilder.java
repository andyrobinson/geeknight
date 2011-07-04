package topic.builders;

import java.util.ArrayList;
import java.util.List;

public class FishiesBuilder {

	private List<Fish> fish = new ArrayList<Fish>();

	public FishiesBuilder withCatfishAged(int age) {
		addFish(age, Fish.Type.CATFISH);
		return this;
	}

	public FishiesBuilder withGoldfishAged(int age) {
		addFish(age, Fish.Type.GOLDFISH);
		return this;
	}

	public Fishies build() {
		return new Fishies(fish);
	}

	public FishiesBuilder withAFishAged(int age) {
		return withCatfishAged(age);
	}

	private void addFish(int age, Fish.Type type) {
		fish.add(new Fish(defaultNameForType(type), type, age));
	}

	private String defaultNameForType(Fish.Type type) {
		return "a " + type.name().toLowerCase();
	}

	public FishiesBuilder withFishesAged(int... ages) {
		for (int age : ages) {
			withAFishAged(age);
		}
		return this;
	}
}
