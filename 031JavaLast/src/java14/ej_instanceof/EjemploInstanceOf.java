package java14.ej_instanceof;

public class EjemploInstanceOf {

	public static void main(String[] args) {
		String obj = "Lalala";
		//ANTES
		if (obj instanceof String) {
		    String s = (String) obj;
		    // use s
		    System.out.println(s);
		}
		//AHORA
		if (obj instanceof String s) {
		    // use s
			System.out.println(s);
		}
	}
}
