package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {

    private String slotNumber;
    private int stock;

    public VendingMachine(String slotNumber) {
        this.slotNumber = slotNumber;

    }

    public Map<String, Integer> vendingMachine () {

        Map<String, Integer> vendingMachineInfoMap = new HashMap<>();

        File inventoryFile = new File("vendingmachine.csv");
        if (!inventoryFile.exists()) {
            System.out.println("Inventory file not found!");
        }

        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            stock = 5;
            String[] productInfo = new String[4];
            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                productInfo = line.split("\\|");
                slotNumber = productInfo[0];
                vendingMachineInfoMap.put(slotNumber, stock);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
            System.exit(1);
        }

        return vendingMachineInfoMap;

    }


    public String getSlotNumber() {
        return slotNumber;
    }

    public int getStock() {
        return stock;
    }
}
