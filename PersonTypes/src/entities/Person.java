package entities;

public abstract class Person {

    private String name;
    private double annual_income;

    public Person(double annual_income, String name) {
        this.annual_income = annual_income;
        this.name = name;
    }

    public double getAnnual_income() {
        return annual_income;
    }

    public void setAnnual_income(double annual_income) {
        this.annual_income = annual_income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double totalTaxes();

}
