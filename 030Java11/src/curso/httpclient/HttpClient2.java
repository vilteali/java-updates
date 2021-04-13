package curso.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
			    .uri(URI.create("https://postman-echo.com/post"))
			    .header("Content-Type", "text/plain")
			    .POST(HttpRequest.BodyPublishers.ofString("Hi there!"))
			    .build();
			var client = HttpClient.newHttpClient();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.statusCode());      // 200
			System.out.println(response.body());
	}

}
