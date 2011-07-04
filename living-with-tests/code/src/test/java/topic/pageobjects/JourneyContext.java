package topic.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JourneyContext {

	private WebDriver driver = new FirefoxDriver();
	private final String rootUri;

	public JourneyContext(String rootUri) {
		this.rootUri = rootUri;
	}

	public WebDriver driver() {
		return driver ;
	}

	public String uri(String path) {
		return rootUri + path;
	}

}
