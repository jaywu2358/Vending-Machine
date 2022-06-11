package com.techelevator.view;

public class Transaction {


    private int currentMoney;

    public String feedMoney(int amountToFeed) {

        if (amountToFeed == 1 || amountToFeed == 5 || amountToFeed == 10 || amountToFeed == 20) {

            currentMoney += amountToFeed;

            return amountToFeed + " dollar(s) accepted";
        }
            return "Amount not accepted";
    }



}
