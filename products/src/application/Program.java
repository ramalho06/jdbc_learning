package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n  = Integer.parseInt(sc.nextLine());

        for(int i = 1 ; i <= n ; i++ ){
            System.out.println("Product #" + i + " Data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            String typeProduct = sc.nextLine();

            System.out.print("Name: ");
            String productName = sc.nextLine();

            System.out.print("Price: ");
            double productPrice = Double.parseDouble(sc.nextLine());

            if (typeProduct.equals("u")) {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String s_date = sc.nextLine();
                LocalDate manufactureDate = LocalDate.parse(s_date,fmt);
                list.add(new UsedProduct(productName, productPrice, manufactureDate));
            }

            else {
                System.out.print("Customs fee: ");
                double fee = Double.parseDouble(sc.nextLine());
                list.add(new ImportedProduct(productName, productPrice, fee));
            }

        }

        System.out.println("PRICE TAGS: ");
        for(Product item : list){
            System.out.println(item.priceTag());
        }

    }

}
