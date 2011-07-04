package topic.smells;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import topic.smells.dependent.DependencyOne;
import topic.smells.dependent.DependencyTwo;
import topic.smells.dependent.DependencyThree;
import topic.smells.dependent.DependencyFour;
import topic.smells.dependent.DependencyFive;
import topic.smells.dependent.DependencySix;
import topic.smells.dependent.HighlyDependentUnit;

public class TooManyDependenciesOnUnitTest {

	HighlyDependentUnit unit;
	@Mock DependencyOne dependencyOne;
	@Mock DependencyTwo dependencyTwo;
	@Mock DependencyThree dependencyThree;
	@Mock DependencyFour dependencyFour;
	@Mock DependencyFive dependencyFive;
	@Mock DependencySix dependencySix;
	
	@Before
	public void setupUnitDependenciesWhichThereSeemToBeALotOf() {
		MockitoAnnotations.initMocks(this);
		unit = new HighlyDependentUnit(dependencyOne, dependencyTwo, dependencyThree, dependencyFour, dependencyFive, dependencySix);
	}
	
	@Test
	public void unitShouldDoSomethingButNeedToStubALotOfStuffToGetToTheLogicWeAreInterestedIn() {
		when(dependencyOne.someMethod()).thenReturn("");
		when(dependencyTwo.someMethod()).thenReturn("");
		when(dependencyThree.someMethod()).thenReturn("");
		when(dependencyFour.someMethod()).thenReturn("");
		when(dependencyFive.someMethod()).thenReturn("");
		when(dependencySix.someMethod()).thenReturn("bar");
		
		assertThat(unit.workSomethingOut("foo"), is("foobar"));
	}
}
