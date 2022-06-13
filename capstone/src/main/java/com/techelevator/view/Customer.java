package com.techelevator.view;

import com.techelevator.Inventory.Products;

import java.io.FileNotFoundException;
import java.lang.invoke.VarHandle;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import static com.techelevator.view.Log.log;

<<<<<<< HEAD
public class Customer {

=======
    private double change;
    private double currentMoney;
>>>>>>> 41646aee3a824811c16afa635f799224328b359b

    VendingMachine vendingMachine = new VendingMachine();
    BigDecimal remainingBalance = vendingMachine.getRemainingBalance();

    public void feedMoney(BigDecimal amountToFeed) throws FileNotFoundException {

        Set<BigDecimal> inputAmount = new HashSet<>();
        inputAmount.add(BigDecimal.valueOf(1));
        inputAmount.add(BigDecimal.valueOf(5));
        inputAmount.add(BigDecimal.valueOf(10));
        inputAmount.add(BigDecimal.valueOf(20));
        if (inputAmount.contains(amountToFeed)) {
            remainingBalance = remainingBalance.add(amountToFeed);
            log("FEED MONEY: $" + amountToFeed.doubleValue() + " $" + remainingBalance.doubleValue());
            System.out.println("Current money provided: " + remainingBalance);

        } else {
            System.out.println("Money not accepted, Please only insert $1, $5, $10, or $20 bills!");

        }
    }
//        if(amountToFeed.compareTo(amountToFeed) == 0 || amountToFeed.compareTo(amountToFeed) == 5 || amountToFeed.compareTo(amountToFeed) == 10 || amountToFeed.compareTo(amountToFeed) == 20) {
//            currentMoney = currentMoney.add(amountToFeed);
//            System.out.println("Current money provided: " + currentMoney);
//
//        } else if (amountToFeed.compareTo(amountToFeed) != 0 || amountToFeed.compareTo(amountToFeed) != 5 || amountToFeed.compareTo(amountToFeed) != 10 || amountToFeed.compareTo(amountToFeed) != 20) {
//
//            System.out.println("Money not accepted, Please only insert $1, $5, $10, or $20 bills!");
//        }

    public BigDecimal change (BigDecimal itemPrice) {

        remainingBalance = remainingBalance.subtract(itemPrice);
        return remainingBalance;
    }

    public BigDecimal finishTransaction(boolean finishTransaction) {
        if (finishTransaction) {
            remainingBalance = BigDecimal.valueOf(0);
        }
            return remainingBalance;
    }

<<<<<<< HEAD

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void returnChange(BigDecimal change) throws FileNotFoundException {

        int nickel = 0;
        int dime = 0;
        int quarter = 0;
        double changeInDouble  = change.doubleValue() * 100;

        while (changeInDouble  >= 25) {
=======
>>>>>>> 41646aee3a824811c16afa635f799224328b359b

            quarter++;
            changeInDouble-=25;
            //change.subtract(BigDecimal.valueOf(0.25));

        }
        while (changeInDouble >= 10) {

            dime++;
            changeInDouble-=10;
            //change.subtract(BigDecimal.valueOf(0.10));

        }
        while (changeInDouble  >= 5) {

            nickel++;
            changeInDouble-=5;
            //change.subtract(BigDecimal.valueOf(0.05));

        }
        log("GIVE CHANGE: $" + remainingBalance + " $" + changeInDouble);
        System.out.println("Thank you for your purchase!! Remaining balance: $" + remainingBalance );
        System.out.println("Here is your change: " + quarter + " quarters, " + dime + " dimes, " + nickel + " nickels.");
        System.out.println("Remaining balance: $" + changeInDouble);
    }
}
