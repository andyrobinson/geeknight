package topic.pageobjects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.hamcrest.MatcherAssert;

public class BbcNewsSteps {

	private final JourneyContext context;
	private BbcNewsPage newsPage;

	public BbcNewsSteps(JourneyContext context) {
		this.context = context;
		newsPage = new BbcNewsPage(context);
	}

	public void openNewsPage() {
		newsPage.open();
	}

	public void navigateToTopNewsStory() {
		newsPage.clickTopNewsStory();
	}

	public void checkTopNewsStoryConcerns(String storyContent) {
		assertThat(newsPage.topStoryText(), containsString(storyContent));
	}

}
