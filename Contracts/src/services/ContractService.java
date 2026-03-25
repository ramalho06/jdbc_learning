package services;

import entities.Contract;
import entities.Installment;

public class ContractService {
    private final OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double baseValue = contract.getTotalValue()/months;
        for (int i = 1 ; i <= months ; i++){
            double amount = baseValue + onlinePaymentService.interest(baseValue,i);
            double total = amount + onlinePaymentService.paymentFee(amount);
            contract.getInstallments().add(new Installment(total, contract.getDate().plusMonths(i)));
        }

    }

}
