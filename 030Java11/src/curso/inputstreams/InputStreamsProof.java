package curso.inputstreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamsProof {

	public static void main(String[] args) throws IOException {
		var classLoader = ClassLoader.getSystemClassLoader();
		var inputStream = classLoader.getResourceAsStream("test.txt");
		var tempFile = File.createTempFile("dummy-copy", "txt");
		try (var outputStream = new FileOutputStream(tempFile)) {
			inputStream.transferTo(outputStream);
		}
		System.out.println(tempFile.length());
	}
}
