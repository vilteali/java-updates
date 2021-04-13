package curso.takewhile;

import java.util.stream.Stream;

public class Iterate {

	public static void main(String[] args) {
		Stream.iterate(1, i -> i <= 100, i -> 2 * i).forEach(System.out::println);
	}

}
