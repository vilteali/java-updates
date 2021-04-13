package curso.factoria;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Factorias {

	public static void main(String[] args) {

		//INICIALIZACIÓN
		List<String> list = List.of("a", "b", "c");

		Set<String> set = Set.of("a", "b", "c");

		Map<String, Integer> map = Map.of("a", 1);
		
		
		//USO
		Map<Integer, String> mapa = Map.of(1, "cecilio", 2, "antonio", 3, "gema");
		System.out.println(mapa.get(1));
		
		Set<Integer> lista2=Set.of(1,2,3,4,5,6);
		lista2.forEach(System.out::println);
		
		List<String> lista=List.of("hola ","que ","tal ","estas");
        lista.forEach(System.out::print);
	}

}
