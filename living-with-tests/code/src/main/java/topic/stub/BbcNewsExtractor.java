package topic.stub;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class BbcNewsExtractor {

	private final String rootUri;

	public BbcNewsExtractor(String rootUri) {
		this.rootUri = rootUri;
	}

	public String latestHeadline() {
		String path = "/news";
		String page = fetchContent(path);
		try {
			return parser(page).extractTagContentForClass("top-story-header");
		}
		catch (Exception e) {
			throw new RuntimeException("Could not find latest headline in page: " + page);
		}
	}

	private HtmlParser parser(String html) {
		return new HtmlParser(html);
	}

	private String fetchContent(String path) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(rootUri + path);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
