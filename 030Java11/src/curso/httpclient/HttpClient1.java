package curso.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
			    .uri(URI.create("https://www.google.com"))
			    .build();
			var client = HttpClient.newHttpClient();
			client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			    .thenApply(HttpResponse::body)
			    .thenAccept(System.out::println);
			
			Thread.sleep(5000);
	}

}
