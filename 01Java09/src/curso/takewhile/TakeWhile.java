package curso.takewhile;

import java.util.stream.Stream;

public class TakeWhile {

	public static void main(String[] args) {
		Stream.of("a", "b", "c", "", "e").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);
		//Stream.of("a", "b", "c", "", "e").parallel().takeWhile(s -> !s.isEmpty()).forEach(System.out::print);
	}

}
