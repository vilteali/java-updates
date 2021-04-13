package curso.collections;

import java.util.ArrayList;
import java.util.List;

public class Copy {

	public static void main(String[] args) {
		var list = new ArrayList<String>();
		var copy = List.copyOf(list);
		System.out.println(list == copy);   // false
		
		var list2 = List.of("A", "B", "C");
		var copy2 = List.copyOf(list2);
		System.out.println(list2.get(0).hashCode()); 
		System.out.println(copy2.get(0).hashCode()); 
		System.out.println(list2 == copy2);   // true
		
		var list3 = List.of(new Usuario("Fer"), new Usuario("Silvia"));
		var copy3 = List.copyOf(list3);
		System.out.println(list3.get(0).hashCode()); 
		System.out.println(copy3.get(0).hashCode()); 
		list3.get(0).setNombre("Fernando"); 
		System.out.println(copy3.get(0).getNombre());
		System.out.println(list3 == copy3);   // true
		
	}

}
