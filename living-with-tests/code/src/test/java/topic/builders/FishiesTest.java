package topic.builders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FishiesTest {

	private HeavyweightFishiesRepository testFishiesRepository;

	@Before
	public void loadTestData() throws Exception {
		testFishiesRepository = new HeavyweightFishiesRepository("aquarial-test-data.properties");
	}
	
	@Test
	public void testFishMeansSomethingSurprising() {
		Fishies fishies = testFishiesRepository.getFishiesFor("bob");
		
		assertThat(fishies.lifeMean(), is(42));
	}
	
	@Test
	public void testFishMeanWithAllTheInformation() {
		List<Fish> listOfFish = new ArrayList<Fish>();
		listOfFish.add(new Fish("luke", Fish.Type.CATFISH, 40));
		listOfFish.add(new Fish("matthew", Fish.Type.GOLDFISH, 44));
		Fishies fishies = new Fishies(listOfFish);
		
		assertThat(fishies.lifeMean(), is(42));
	}

	@Test
	public void testFishLifeMeanOfAgesWithSomeNoiseFoldedAwayIntoMethods() {
		List<Fish> listOfFish = new ArrayList<Fish>();
		listOfFish.add(aFishWithTypeAndAge(Fish.Type.CATFISH, 40));
		listOfFish.add(aFishWithTypeAndAge(Fish.Type.GOLDFISH, 44));
		Fishies fishies = new Fishies(listOfFish);
		
		assertThat(fishies.lifeMean(), is(42));
	}

	@Test
	public void testFishLifeMeanUsingABuilderToRemoveSomeMoreCreationNoise() {
		Fishies fishies = new FishiesBuilder()
			.withCatfishAged(40)
			.withGoldfishAged(44)
			.build();
		
		assertThat(fishies.lifeMean(), is(42));
	}

	@Test
	public void lifeMeanShouldBeAverageOfFishAges() {
		Fishies fishies = new FishiesBuilder()
    		.withAFishAged(40)
			.withAFishAged(44)
			.build();
		
		assertThat(fishies.lifeMean(), is(42));
	}

	@Test
	public void lifeMeanShouldBeMeanOfAllFishAges() {
		Fishies fishies = new FishiesBuilder()
    		.withFishesAged(40, 41, 42, 43, 44)
			.build();
		
		assertThat(fishies.lifeMean(), is(42));
	}

	private Fish aFishWithTypeAndAge(Fish.Type type, int age) {
		return new Fish("fishname", Fish.Type.CATFISH, age);
	}
}
