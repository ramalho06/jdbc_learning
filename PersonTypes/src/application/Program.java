package application;

import entities.LegalEntity;
import entities.NaturalPerson;
import entities.Person;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Program {

    static void main() {

        Locale.setDefault(Locale.US);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d1 = LocalDate.of(2025,2,10);
        LocalDate d2 = LocalDate.of(2025,2,15);
        System.out.println(ChronoUnit.DAYS.between(d1,d2));


    }
}
