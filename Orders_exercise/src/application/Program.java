package application;

import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Program {
    static void main(String[] args){
        LocalDateTime data = LocalDateTime.now();

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter the client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("Email: ");
        String clientEmail = sc.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        LocalDate clientBrithDate = LocalDate.parse(sc.nextLine(), fmt);

        Client client = new Client(clientBrithDate,clientEmail,clientName);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();

        Order order = new Order(client,data, OrderStatus.valueOf(status));

        System.out.print("How many items to this order: ");
        int n = Integer.parseInt(sc.nextLine());

        for(int i = 1 ; i<=n ; i++){
            System.out.println("Enter #" + i + " item data");
            System.out.print("Product Name: ");
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            double productPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Quantity: ");
            int productQuantity = Integer.parseInt(sc.nextLine());
            OrderItem orderItem = new OrderItem(productPrice, new Product(productName,productPrice), productQuantity);
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}
