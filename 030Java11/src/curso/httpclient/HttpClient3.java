package curso.httpclient;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
			    .uri(URI.create("https://postman-echo.com/basic-auth"))
			    .build();
			var client = HttpClient.newBuilder()
			    .authenticator(new Authenticator() {
			        @Override
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication("postman", "password".toCharArray());
			        }
			    })
			    .build();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.statusCode());      // 200
			System.out.println(response.body());
	}

}
