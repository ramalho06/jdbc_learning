package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    private OrderStatus stats;

    private final List<OrderItem> list = new ArrayList<>();
    private Client client;

    public Order(Client client, LocalDateTime moment, OrderStatus stats) {
        this.client = client;
        this.moment = moment;
        this.stats = stats;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStats() {
        return stats;
    }

    public void setStats(OrderStatus stats) {
        this.stats = stats;
    }

    public void addItem(OrderItem item){
        list.add(item);
    }

    public void removeItem(OrderItem item){
        list.remove(item);
    }

    public double total(){
        double sum = 0;

        for(OrderItem item : list){
            sum += item.subTotal();
        }

        return sum;

    }

    private String getFormattedMoment(){
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return getMoment().format(fmt2);
    }

    public String toString(){
        Double sum = 0.0;
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(getFormattedMoment()).append("\n");
        sb.append("Order Status: ").append(getStats()).append("\n");
        sb.append("Client: ").append(getClient().getName()).append(" ");
        sb.append(getClient().formattedBirthday()).append(" - ");
        sb.append(getClient().getEmail()).append("\n");
        sb.append("Order items: \n");

        for (OrderItem i : list){
            sb.append(i.getProduct().getName()).append(", ");
            sb.append("Quantity: ").append(i.getQuantity()).append(", ");
            sb.append("Price: $").append(i.getPrice()).append(", ");
            sb.append("Subtotal: $").append(i.subTotal()).append("\n");
            sum+=i.subTotal();
        }
        sb.append("Total price: $").append(sum);
        return sb.toString();
    }

}
