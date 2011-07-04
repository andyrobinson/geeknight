package topic.stub;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class HtmlParserTest {

	@Test
	public void extractsContentsOfSingleTagWithClass() {
		HtmlParser parser = new HtmlParser("<div class=\"a\">content</div>");
		
		assertThat(parser.extractTagContentForClass("a"), is("content"));
	}

	@Test
	public void extractsContentsOfSingleShortTagWithClass() {
		HtmlParser parser = new HtmlParser("<a class=\"b\">content2</a>");
		
		assertThat(parser.extractTagContentForClass("b"), is("content2"));
	}

	@Test
	public void extractsContentsOfTagOFClassWithAnotherTagInIt() {
		HtmlParser parser = new HtmlParser("<a class=\"b\">xxx<img/></a>");
		
		assertThat(parser.extractTagContentForClass("b"), is("xxx"));
	}
}
