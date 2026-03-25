package entities;

public class ImportedProduct extends Product{

    private double customsFee;

    public ImportedProduct(String name, Double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    private double totalPrice(){
        return getPrice() + getCustomsFee();
    }

    @Override
    public String priceTag(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append(" $")
                .append(totalPrice())
                .append(" (Customs fee: $")
                .append(getCustomsFee())
                .append(")");

        return sb.toString();
    }

}
