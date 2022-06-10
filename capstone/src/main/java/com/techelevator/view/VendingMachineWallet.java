package com.techelevator.view;

public class VendingMachineWallet extends BankAccount{

    public VendingMachineWallet(int balance) {
        super(balance);
    }

    @Override
    public int feedMoney(int amountToFeed) {

        if(getBalance() - amountToFeed < 0) {
            System.out.println("Insufficient amount of fund to make this transaction!");
        }
        if(amountToFeed <= getBalance()) {
            super.feedMoney(amountToFeed);
        }
        return amountToFeed;
    }
}
