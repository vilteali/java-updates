package ejswitch;

public class Ejemplo_3 {

	public static void main(String[] args) {

		System.out.println(getTextViaArrow(1));
		System.out.println(getTextViaArrow(3));
		System.out.println(getTextViaArrow(6));
		System.out.println(getTextViaArrow(10));

	}

	private static String getTextViaArrow(int number) {
		String result = switch (number) {
		case 1, 2 -> "one or two";
		case 3 -> "three";
		case 4, 5, 6 -> "four or five or six";
		default -> "unknown";
		};
		return result;
	}

}
