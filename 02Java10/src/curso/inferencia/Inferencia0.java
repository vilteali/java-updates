package curso.inferencia;

import java.util.List;

import modelo.Usuario;

public class Inferencia0 {

	public static void main(String[] args) {
		//como lo escribo
		var diez = 10;
		var usuario = new Usuario();
		var miLista = List.of("1","2","3","4","5");
		
		System.out.println(diez);
		System.out.println(usuario);
		System.out.println(miLista);
		
		
		//como está después del compilado
		//int diez = 10;
		//Usuario usuario = new Usuario();
		//List<String> miLista = List.of("1","2","3","4","5");
	}

}
