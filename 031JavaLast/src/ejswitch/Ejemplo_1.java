package ejswitch;

public class Ejemplo_1 {
	
	public static void main(String[] args) {

        System.out.println(getTextBefore12(1));
        System.out.println(getTextBefore12(3));
        System.out.println(getTextBefore12(6));
        System.out.println(getTextBefore12(10));

    }

    // Traditional switch statement
    private static String getTextBefore12(int number) {
        String result = "";
        switch (number) {
            case 1:
            case 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
            case 5:
            case 6:
                result = "four or five or six";
                break;
            default:
                result = "unknown";
        };
        return result;
    }


	
}
