package java15.whatsnew.sealedclasses;

import java.time.LocalDate;
import java.util.Date;

public sealed class Person permits Employee, Manager {
    /**
     * Demonstration of pattern matching for instanceof
     *
     * @param person A Person object
     * @return
     */
    public static void patternMatchingDemo(Person person) {
        if(person instanceof Manager employee) {
            System.out.println("UNO");
            System.out.println(employee.getNombrecito());
        }

        if(person instanceof Employee employee && employee.getHiredDate() != null) {
            LocalDate hiredDate = employee.getHiredDate();
            System.out.println("DOS");
            System.out.println(hiredDate);
        }
    }
    
    public static void main(String[] args) {
		patternMatchingDemo(new Manager());
		patternMatchingDemo(new Employee());
	}
}
