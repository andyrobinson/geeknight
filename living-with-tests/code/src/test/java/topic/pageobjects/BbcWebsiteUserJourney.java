package topic.pageobjects;

import org.junit.Test;


public class BbcWebsiteUserJourney {
	
	private JourneyContext journeyContext = new JourneyContext("http://www.bbc.co.uk");
	private BbcSteps steps = new BbcSteps(journeyContext);
	private BbcNewsSteps newsSteps = new BbcNewsSteps(journeyContext);
	
	@Test
	public void navigate_to_the_top_news_story() {
		steps.openHomepage();
		
		steps.checkHomepageIsOpen();
		
		newsSteps.openNewsPage();
		
		newsSteps.navigateToTopNewsStory();
		
		newsSteps.checkTopNewsStoryConcerns("NI");
	}

}
