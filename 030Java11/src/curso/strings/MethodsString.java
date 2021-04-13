package curso.strings;

public class MethodsString {

	public static void main(String[] args) {
		
		System.out.println(" ".isBlank());                // true
		System.out.println(" Foo Bar ".strip());          // "Foo Bar"
		System.out.println(" Foo Bar ".stripTrailing());  // " Foo Bar"
		System.out.println(" Foo Bar ".stripLeading());   // "Foo Bar "
		System.out.println("Java".repeat(3));             // "JavaJavaJava"
		System.out.println("A\nB\nC".lines().count());    // 3
	}

}
