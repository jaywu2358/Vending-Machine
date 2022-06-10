package com.techelevator.view;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int feedMoney(int amountToFeed) {

        balance -= amountToFeed;
        return balance;

    }


}
