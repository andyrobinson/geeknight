package topic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BbcNewsPage {

	private final JourneyContext context;

	public BbcNewsPage(JourneyContext context) {
		this.context = context;
	}

	public void open() {
		driver().get(context.uri("/news"));
	}

	public void clickTopNewsStory() {
		driver().findElement(By.className("top-story-header")).findElement(By.tagName("a")).click();
	}

	private WebDriver driver() {
		return context.driver();
	}

	public String topStoryText() {
		return driver().findElement(By.className("story-header")).getText();
	}

}
