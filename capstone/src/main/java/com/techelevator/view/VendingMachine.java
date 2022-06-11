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

        Products defaultStock = productInfo.get(slotNumber);
        for (Map.Entry<String, Products> entireSlot: productInfo.entrySet()) {

            slotNumber = entireSlot.getKey();
            String productName = entireSlot.getValue().getName();
            Double productPrice = entireSlot.getValue().getPrice();
            String productType = entireSlot.getValue().getType();
            //int currentStock = entireSlot.getValue();

            System.out.println(slotNumber + ": " + productName + " |Price $" + productPrice + " |Type: " + productType + " |CurrentStock: " + defaultStock.getStock());

        }
    }

    public String getSlotNumber() {
        return slotNumber;
    }


}


//    Map<String, Double> productInfoMap = new HashMap<>();
//
//    File inventoryFile = new File("vendingmachine.csv");
//        if (!inventoryFile.exists()) {
//                System.out.println("Inventory file not found!");
//                }
//
//                try (Scanner fileScanner = new Scanner(inventoryFile)) {
//
//                String[] productInfo = new String[1];
//                while (fileScanner.hasNextLine()) {
//
//                String line = fileScanner.nextLine();
//                productInfo = line.split("\\|");
//                name = productInfo[0];
//                productInfoMap.put(name, Inventory);
//                }
//                } catch (FileNotFoundException e) {
//                System.out.println("File not found!!");
//                System.exit(1);
//                }
//
//                return productInfoMap;
