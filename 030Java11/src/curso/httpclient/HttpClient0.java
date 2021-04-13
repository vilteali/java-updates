package curso.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient0 {

	public static void main(String[] args) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
			    .uri(URI.create("https://www.google.com"))
			    .GET()
			    .build();
			var client = HttpClient.newHttpClient();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
	}

}
