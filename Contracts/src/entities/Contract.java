package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final int number;
    private LocalDate date;
    private double totalValue;

    private final List<Installment> installments = new ArrayList<>();

    public Contract(LocalDate date, int number, double totalValue) {
        this.date = date;
        this.number = number;
        this.totalValue = totalValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public String showInstallments(){
        StringBuilder sb = new StringBuilder();
        for (Installment inst : installments){
            sb.append(inst.getDueDate().format(fmt))
                    .append(" - ")
                    .append(inst.getAmount())
                    .append("\n");
        }
        return sb.toString();
    }

}
