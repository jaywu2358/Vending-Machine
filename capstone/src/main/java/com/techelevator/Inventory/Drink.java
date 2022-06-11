package com.techelevator.Inventory;

public class Drink extends Products {

    public Drink(String name, Double price, String type) {

        super(name, price, type);

    }

    @Override
    public String getDispensingMsg() {
        return "Glug Glug, Yum!";
    }

}
