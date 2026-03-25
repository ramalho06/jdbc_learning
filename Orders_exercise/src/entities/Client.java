package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Client {

    private String name;
    private String email;

    private LocalDate birthDate;

    public Client(LocalDate birthDate, String email, String name) {
        this.birthDate = birthDate;
        this.email = email;
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String formattedBirthday(){
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
        return getBirthDate().format(fmt2);


    }

}
