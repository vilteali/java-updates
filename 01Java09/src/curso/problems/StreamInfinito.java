package curso.problems;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInfinito {
	
	public static void main(String[] args) {
		// STREAM INFINITO (SIN EL LIMIT)
		//List<Integer> divisibleBy3 = Stream.iterate(3, t -> t+3).collect(Collectors.toList());
		List<Integer> divisibleBy3 = Stream.iterate(3, t -> t+3).limit(100).collect(Collectors.toList());
		System.out.println(divisibleBy3);
	}

}
