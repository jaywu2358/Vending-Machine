package com.techelevator.view;

import com.techelevator.Inventory.Products;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {

    private Map<String, Products> productInfo = new HashMap<>();
    private String slotNumber;

    public Map<String, Products> getProductInfo() {

        File inventoryFile = new File("vendingmachine.csv");
        if(!inventoryFile.exists()) {
            System.out.println("File not found");
        }

        try (Scanner fileScanner = new Scanner(inventoryFile)) {

            String[] arrayOfSlotNumber = new String[4];
            //List<Products> listOfProduct = new ArrayList<>();
            while(fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                arrayOfSlotNumber = line.split("\\|");
                slotNumber = arrayOfSlotNumber[0];
                Double price = Double.parseDouble(arrayOfSlotNumber[2]);
                Products product = new Products(arrayOfSlotNumber[1], price, arrayOfSlotNumber[3]);

//                for ( int i=0; i < maxStock; i ++) {
//                    listOfProduct.add(product);
//                }
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
