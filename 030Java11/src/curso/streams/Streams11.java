package curso.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams11 {

	public static void main(String[] args) {

		// Stream.ofNullable construye un stream para un solo elemento
		System.out.println(Stream.ofNullable(null).count()); // 0

		// Stream.dropWhile
		System.out.println(Stream.of(1, 2, 3, 2, 1).dropWhile(n -> n < 3).collect(Collectors.toList()));// [3, 2, 1]

		// Stream.takeWhile
		System.out.println(Stream.of(1, 2, 3, 2, 1).takeWhile(n -> n < 3).collect(Collectors.toList())); // [1, 2]
	}

}
