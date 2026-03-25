package entities;

public class LegalEntity extends Person {
    private int employeesNum;

    public LegalEntity(double annual_income, String name, int employeesNum) {
        super(annual_income, name);
        this.employeesNum = employeesNum;
    }

    public int getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    @Override
    public double totalTaxes() {
        if (employeesNum<10){
            return getAnnual_income() * 0.16;
        }
        return getAnnual_income() * 0.14;
    }
}
