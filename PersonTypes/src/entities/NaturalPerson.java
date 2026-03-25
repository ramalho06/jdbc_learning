package entities;

public class NaturalPerson extends Person {

    private double healthExpenses;

    public NaturalPerson(double annual_income, String name, double healthExpenses) {
        super(annual_income, name);
        this.healthExpenses = healthExpenses;
    }

    public double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double totalTaxes() {
        double v = getHealthExpenses() * 0.50;
        if (getAnnual_income() < 20000){
            return getAnnual_income() * 0.15 - v;
        }
        return  getAnnual_income() * 0.25 - v;
    }
}
