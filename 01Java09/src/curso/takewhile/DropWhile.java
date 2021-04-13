package curso.takewhile;

import java.util.stream.Stream;

public class DropWhile {

	public static void main(String[] args) {
		Stream.of("a", "b", "c", "de", "f").dropWhile(s -> s.length() <= 1).forEach(System.out::print);	
	}

}
