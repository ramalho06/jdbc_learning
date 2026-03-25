package entities;

import java.time.LocalDate;

public class Installment {

    private LocalDate dueDate;
    private double amount;

    public Installment(double amount, LocalDate dueDate) {
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
