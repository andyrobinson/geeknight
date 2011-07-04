package topic.stub;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

public class BbcNewsExtractorTest {

	@Test
	public void shouldExtractLatestHeadline() {
		assertThat(new BbcNewsExtractor("http://www.bbc.co.uk").latestHeadline(), 
				containsString(""));
	}
	
	@Test
	public void shouldExtractLatestHeadlineFromStub() throws Exception {
		StubHttpServer stub = new StubHttpServer(8081);
		stub.start();

		stub.respondToAllRequestsWith("<html><div class=\"top-story-header\">Greek Doobrie</div></html>", "text/html");
		
		BbcNewsExtractor extractor = new BbcNewsExtractor("http://localhost:8081");
		
		assertThat(extractor.latestHeadline(), containsString("Greek Doobrie"));
	}
	
	
}
