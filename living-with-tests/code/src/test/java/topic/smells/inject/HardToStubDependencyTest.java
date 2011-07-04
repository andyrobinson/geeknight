package topic.smells.inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class HardToStubDependencyTest {

	@Test
	public void wantToStubDependencyButCannot() {
		CreationControlFreak unitUnderTest = new CreationControlFreak();
		
		assertThat(unitUnderTest.fetchSomeObjectCalled("bob"), is(notNullValue()));
	}

}
