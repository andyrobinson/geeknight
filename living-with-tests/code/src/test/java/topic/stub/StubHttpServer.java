package topic.stub;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;


public class StubHttpServer {

	private Server server;
	private String body;
	private String contentType;
	
	public StubHttpServer(int port) {
		server = new Server(port);
		server.setHandler(new AbstractHandler() {
			
			@Override
			public void handle(String path, Request jettyRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				response.setHeader("Content-Type", contentType);
				response.setStatus(200);
				response.getWriter().print(body);
				jettyRequest.setHandled(true);
			}
			
		});
	}

	public void start() throws Exception {
		server.start();
	}
	
	public void respondToAllRequestsWith(String body, String contentType) {
		this.body = body;
		this.contentType = contentType;
	}
	
	public static void main(String[] args) throws Exception {
		StubHttpServer server = new StubHttpServer(8081);
		server.respondToAllRequestsWith("hello world!", "text/plain");
		server.start();
	}
	
}
