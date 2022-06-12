package com.techelevator.view;

import com.techelevator.Inventory.Products;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {

    private TreeMap<String, Products> productInfo = new TreeMap<>();
    private String slotNumber;

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

    public void printInventory() {

        Products defaultStock = new Products();
        for (Map.Entry<String, Products> entireSlot: productInfo.entrySet()) {

            slotNumber = entireSlot.getKey();
            String productName = entireSlot.getValue().getName();
            Double productPrice = entireSlot.getValue().getPrice();
            String productType = entireSlot.getValue().getType();
            //int currentStock = entireSlot.getValue();

            System.out.println(slotNumber + ": " + productName + " |Price $" + productPrice + " |Type: " + productType + " |CurrentStock: " + defaultStock.getStock());

        }
    }

    public String purchase(String userSelection) {

        Customer customer = new Customer();
        int currentMoney = customer.getCurrentMoney();
        Products currentProduct = productInfo.get(userSelection);

            if (currentMoney >= currentProduct.getPrice()) {
                currentMoney -= currentProduct.getPrice();
                return "You have purchased (1) " + currentProduct.getName() + " Remaining amount: $" + currentMoney;
            }
            return "Insufficient amount of money. Purchase failed!";
        }

}

