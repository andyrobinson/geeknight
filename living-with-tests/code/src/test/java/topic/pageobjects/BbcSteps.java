package topic.pageobjects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BbcSteps {

	private final JourneyContext context;
	private BbcHomePage homePage;

	public BbcSteps(JourneyContext journeyContext) {
		this.context = journeyContext;
		homePage = new BbcHomePage(context);
	}

	public void openHomepage() {
		homePage.open();
	}

	public void checkHomepageIsOpen() {
		assertThat(homePage.isOpen(), is(true));
	}
}
