package application;

import entities.Contract;
import org.w3c.dom.ls.LSOutput;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    static void main() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com os dados do contrato: ");

        System.out.print("Número: ");
        int contractNum = Integer.parseInt(sc.nextLine());

        System.out.print("data: ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        double contractValue = Double.parseDouble(sc.nextLine());

        System.out.print("Entre com o numero de parcelas: ");
        int installmentNum = sc.nextInt();

        Contract contract = new Contract(contractDate, contractNum, contractValue);
        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, installmentNum);

        System.out.println(contract.showInstallments());

        sc.close();




    }



}
