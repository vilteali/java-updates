package curso.misc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations1 {

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @interface MyAnnotation {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Hints {
        Hint[] value();
    }

    @Repeatable(Hints.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hint {
        String value();
        String surname();
    }

    @Hint(value="Fer",surname="Gil")
    @Hint(value="Isa",surname="Gonzalez")
    class Person {

    }

    public static void main(String[] args) {
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);   // null

        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);  // 2
        
        for (Hint hint2 : hints2) {
			System.out.println(hint2.value());
			System.out.println(hint2.surname());
		}
    }
}