package com.techelevator.view;

import com.techelevator.Inventory.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import static com.techelevator.view.Log.log;

public class VendingMachine {

    TreeMap <String, Products> productInfo = new TreeMap<>();
    String slotNumber;
    String productName;
    BigDecimal productPrice;
    BigDecimal remainingBalance = BigDecimal.valueOf(0);

    public Map<String, Products> getProductInfo() {

        File inventoryFile = new File("vendingmachine.csv");
        if(!inventoryFile.exists()) {
            System.out.println("File not found");
        } else if (!inventoryFile.isFile()) {
            System.out.println("Invalid file type!!");
            System.exit(1);
        }

        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while(fileScanner.hasNextLine()) {

                String[] arrayOfSlotInfo;
                String line = fileScanner.nextLine();
                arrayOfSlotInfo = line.split("\\|");
                slotNumber = arrayOfSlotInfo[0];
                productName = arrayOfSlotInfo[1];
                productPrice = BigDecimal.valueOf(Double.parseDouble(arrayOfSlotInfo[2]));

                if(arrayOfSlotInfo[3].equals("Chip")) {
                    Products product = new Chip(productName, productPrice);
                    productInfo.put(slotNumber, product);
                }

                if(arrayOfSlotInfo[3].equals("Drink")) {
                    Products product = new Drink(productName, productPrice);
                    productInfo.put(slotNumber, product);
                }

                if(arrayOfSlotInfo[3].equals("Gum")) {
                    Products product = new Gum(productName, productPrice);
                    productInfo.put(slotNumber, product);
                }

                if(arrayOfSlotInfo[3].equals("Candy")) {
                    Products product = new Candy(productName, productPrice);
                    productInfo.put(slotNumber, product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }
        return productInfo;
    }

    public void printInventory() {

        for (Map.Entry<String, Products> entireSlot: productInfo.entrySet()) {

            slotNumber = entireSlot.getKey();
            productName = entireSlot.getValue().getName();
            productPrice = entireSlot.getValue().getPrice();
            int currentStock = entireSlot.getValue().getStock();
            if(currentStock == 0){
                System.out.println(slotNumber + ": " + productName + "  --> Price $" + productPrice + "  --> CurrentStock: SOLD OUT");
            } else {

                System.out.println(slotNumber + ": " + productName + "  --> Price $" + productPrice + "  --> CurrentStock: " + currentStock);
            }
        }
    }

    public void dispenseItem(Customer customer, String userSelection) throws FileNotFoundException {

        BigDecimal currentMoney = customer.getRemainingBalance();
        Products currentProduct = productInfo.get(userSelection);

        if(currentProduct.getStock() == 0) {
            System.out.println("This item is SOLD OUT. Please select other option!");
        }
        if(currentProduct.getStock() > 0) {
            if (currentMoney.compareTo(currentProduct.getPrice()) >= 0) {
                currentProduct.sold();
                remainingBalance = customer.change(currentProduct.getPrice());

                String formattedPrice = "$" + String.format("%.2f", currentProduct.getPrice());
                System.out.println("You have purchased (1) " + currentProduct.getName() + ", Remaining balance: $" + remainingBalance + "\n" + currentProduct.getDispensingMsg());
                log(currentProduct.getName() + " " + userSelection + " " + formattedPrice + " $" + customer.getRemainingBalance());
            } else {
                System.out.println("Insufficient amount. Purchase failed!");
            }
        }
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }



//    public double getChange() {
//
//        double change;
//
//        change = currentMoney;
//        return change;
//    }

    public String dispenseChange(double change) {

        double cash;
        int nickel = 0;
        int dime = 0;
        int quarter = 0;

        while(change >= 0.25) {
            quarter++;
            change -= 0.25;
        } while(change >= 0.10) {
            dime++;
            change -= 0.10;
        } while(change >= 0.05) {
            nickel++;
            change -= 0.05;
        }
        return quarter + " quarters " + dime + " dime " + nickel + " nickels ";

    }

}

