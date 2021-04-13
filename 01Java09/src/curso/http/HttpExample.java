package curso.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpExample {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		jdk.incubator.http.HttpRequest request = jdk.incubator.http.HttpRequest.newBuilder()
				.uri(new URI("http://www.google.com")).GET().build();

		jdk.incubator.http.HttpResponse<String> response = jdk.incubator.http.HttpClient.newHttpClient().send(request,
				jdk.incubator.http.HttpResponse.BodyHandler.asString());
		
		System.out.println(response.body());
	}

}
