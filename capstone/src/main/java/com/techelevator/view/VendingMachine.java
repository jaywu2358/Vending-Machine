package com.techelevator.view;

import com.techelevator.Inventory.Products;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {

    private TreeMap<String, Products> productInfo = new TreeMap<>();
    private String slotNumber;
    private double amountDeposited;
    private double currentMoney;

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
                Double price = Double.parseDouble(arrayOfSlotInfo[2]);
                Products product = new Products(arrayOfSlotInfo[1], price, arrayOfSlotInfo[3]);
                productInfo.put(slotNumber, product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }

        return productInfo;

    }

    public void printInventory(Products product) {


        for (Map.Entry<String, Products> entireSlot: productInfo.entrySet()) {

            slotNumber = entireSlot.getKey();
            String productName = entireSlot.getValue().getName();
            Double productPrice = entireSlot.getValue().getPrice();
            String productType = entireSlot.getValue().getType();
            //int currentStock = entireSlot.getValue();

            System.out.println(slotNumber + ": " + productName + " |Price $" + productPrice + " |Type: " + productType + " |CurrentStock: " + product.getStock());

        }
    }

    public String purchase(Customer customer, String userSelection) {

        double currentMoney = customer.getCurrentMoney();
        Products currentProduct = productInfo.get(userSelection);
        if(currentProduct.getStock() == 0) {
            return "Sold out. Please select another item.";
        }
            if (currentMoney >= currentProduct.getPrice()) {
                currentMoney -= currentProduct.getPrice();
                currentProduct.sold();

                return "You have purchased (1) " + currentProduct.getName() + ", Remaining amount: $" + currentMoney;
            }
            return "Insufficient amount of money. Purchase failed!";
        }

    public double getChange() {

        double change;

        change = currentMoney;
        return change;
    }

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

