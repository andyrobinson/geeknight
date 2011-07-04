package topic.pageobjects;

import org.openqa.selenium.WebDriver;


public class BbcHomePage implements OpenablePage {

	private final JourneyContext context;

	public BbcHomePage(JourneyContext context) {
		this.context = context;
	}

	public void open() {
		driver().get(context.uri("/"));
	}
	
	public boolean isOpen() {
		return driver().getTitle().startsWith("BBC - Homepage");
	}

	private WebDriver driver() {
		return context.driver();
	}
}
