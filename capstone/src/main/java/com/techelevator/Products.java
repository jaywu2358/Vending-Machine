package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Products {

    private String name;
    private double price;

    public Products (String slotNumber, List<String> products ) {
        this.name = name;
        this.price = price;

    }

    public Products () {

    }

    public Map<String, Double> getProductInfo() {

        Map<String, Double> productInfoMap = new HashMap<>();

        File inventoryFile = new File("vendingmachine.csv");
        if (!inventoryFile.exists()) {
            System.out.println("Inventory file not found!");
        }

        try (Scanner fileScanner = new Scanner(inventoryFile)) {

            String[] productInfo = new String[4];
            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                productInfo = line.split("\\|");
                name = productInfo[1];
                price = Double.parseDouble(productInfo[2]);
                productInfoMap.put(name, price);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
            System.exit(1);
        }

        return productInfoMap;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
