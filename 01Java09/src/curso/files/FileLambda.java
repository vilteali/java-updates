package curso.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLambda {

    public static void main(String JavaLatte[]) {
        Path path = Paths.get("test.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> System.out.println(s));
        } catch (IOException ex) {
          // do something or re-throw...
        }
    }
}