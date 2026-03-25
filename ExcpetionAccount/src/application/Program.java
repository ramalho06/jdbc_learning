package application;

import models.entities.Account;
import models.exceptions.DomainException;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enther account data");
            System.out.print("Number: ");
            int accountNumber = Integer.parseInt(sc.nextLine());
            System.out.print("Holder: ");
            String accountHolder = sc.nextLine();
            System.out.print("Initial Balance: ");
            double accountBalance = Double.parseDouble(sc.nextLine());
            System.out.print("Withdraw limit: ");
            double accountWithdrawLimit = Double.parseDouble(sc.nextLine());
            Account ac = new Account(accountBalance, accountHolder, accountNumber, accountWithdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double valueToWithdraw = Double.parseDouble(sc.nextLine());
            ac.withdraw(valueToWithdraw);
            System.out.println("New balance: " + ac.getBalance());
        }

        catch(DomainException e){
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();

    }
}
