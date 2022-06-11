package com.techelevator.Inventory;

public class Gum extends Products {

    public Gum(String name, Double price, String type) {

        super(name, price, type);

    }

    @Override
    public String getDispensingMsg() {
        return "Chew Chew, Yum!";
    }

}
