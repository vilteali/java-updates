package ejswitch;

public class Ejemplo_2 {
	
	public static void main(String[] args) {

        System.out.println(getTextMultipleLabels(1));
        System.out.println(getTextMultipleLabels(3));
        System.out.println(getTextMultipleLabels(6));
        System.out.println(getTextMultipleLabels(10));

    }

	private static String getTextMultipleLabels(int number) {
        String result = "";
        switch (number) {
            case 1, 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4, 5, 6:
                result = "four or five or six";
                break;
            default:
                result = "unknown";
        };
        return result;
    }


	
}
