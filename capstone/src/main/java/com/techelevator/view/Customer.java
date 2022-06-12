package com.techelevator.view;

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

    public String getChange() {

        int nickel;
        int dime;
        int quarter;

        return "";
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

}
