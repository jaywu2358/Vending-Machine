package com.techelevator.view;

import com.techelevator.Inventory.Products;

public class Customer {


    private double currentMoney;

    public String feedMoney(double amountToFeed) {

        if (amountToFeed == 0 ||amountToFeed == 1 || amountToFeed == 5 || amountToFeed == 10 || amountToFeed == 20) {

            currentMoney = currentMoney + amountToFeed;
            return "Current Money Provided: $" + String.valueOf(currentMoney);

        } else {

            return "Money not accepted, Please only insert $1, $5, $10, or $20 bills!";
        }
    }

    public double getChange(double currentMoney) {

        double change;
        Products productPrice = new Products();
        change = currentMoney - productPrice.getPrice();
        return change;
    }

    public String dispenseChange(double change) {

        double cash;
        double nickel = 0.05;
        double dime = 0.10;
        double quarter = 0.25;

    }

    public double getCurrentMoney() {
        return currentMoney;
    }

}
