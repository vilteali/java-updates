package curso.inferencia;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.Usuario;

public class Inferencia1 {

	public static void main(String[] args) {
		// Java 10
		var userChannels = new HashMap<Usuario, List<String>>();
		var list = new ArrayList<String>(); // infers ArrayList<String>
		var stream = list.stream(); // infers Stream<String>

		var channels = lookupUserChannels();
		channels.forEach(System.out::println);

		var myObject = createUser();
		System.out.println(myObject);
		System.out.println(myObject.getClass());
	}

	public static List<Usuario> lookupUserChannels() {
		List<Usuario> users = new ArrayList<Usuario>();
		users.add(new Usuario("Fer", "ADMIN", LocalDate.now()));
		users.add(new Usuario("Tom", "USER", LocalDate.now()));
		return users;
	}

	public static Object createUser() {
		if (false) {
			return "lalala";
		} else {
			return new Usuario("SILVIA","USER", LocalDate.now(ZoneId.of("Europe/Madrid")));
		}
	}

}
