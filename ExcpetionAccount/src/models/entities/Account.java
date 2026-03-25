package models.entities;

import models.exceptions.DomainException;

public class Account {

    private int number;
    private String holder;
    private Double balance;
    private double withdrawLimit;

    public Account(Double balance, String holder, int number, double withdrawLimit) {
        if (withdrawLimit < 0 ){
            throw new DomainException("The withdraw limit must be greater or equal than 0");
        }
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;


    }

    public Double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount){
        if (amount < 0){
            throw new DomainException("The deposit number must be greater than 0");
        }
        amount+=amount;
    }

    public void withdraw(double amount){
        if (amount > withdrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        balance-=amount;
    }


}
