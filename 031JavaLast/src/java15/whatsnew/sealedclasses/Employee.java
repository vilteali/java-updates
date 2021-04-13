package java15.whatsnew.sealedclasses;

import java.time.LocalDate;

public non-sealed class Employee extends Person {
    public LocalDate getHiredDate() {
        return LocalDate.now();
    }
}
