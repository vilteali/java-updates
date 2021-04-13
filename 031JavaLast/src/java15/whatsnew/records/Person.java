package java15.whatsnew.records;

/**
 * Java record with a header indicating 2 fields.
 */
public record Person(String name, int age) {
    /**
     * Public constructor that does some basic validation.
     */
    public Person {
        if (age < 18) {
            throw new IllegalArgumentException("No se permiten menores de edad");
        }
    }
}
