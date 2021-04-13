package curso.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColeccionesInmodificables {

	public static void main(String[] args) {
		Set<Integer> setx = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableSet());
		List<Integer> listx = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList());
		Map<Integer, Integer> mapx = Stream.of(1, 2, 3)
				.collect(Collectors.toUnmodifiableMap(Function.identity(), Function.identity()));

		System.out.println(setx);
		System.out.println(listx);
		System.out.println(mapx);

		//listx.add(4);

		var list = new ArrayList<String>();
		list.add("kilo");
		var copy = List.copyOf(list);
		System.out.println(copy);
		System.out.println(list == copy); // false
		//copy.add("litro");

		list.add("34"); // java.lang.UnsupportedOperationException
		System.out.println(list);
		System.out.println(copy);

	}

}
