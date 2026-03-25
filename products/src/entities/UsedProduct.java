package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    private LocalDate date;

    public UsedProduct(String name, Double price, LocalDate date) {
        super(name, price);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private String formattedDate(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDate().format(fmt);

    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName())
                .append(" (Used) $")
                .append(getPrice())
                .append(" Manufacture date: (")
                .append(formattedDate())
                .append(")");

        return sb.toString();
    }
}
