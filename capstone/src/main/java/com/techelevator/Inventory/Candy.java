package com.techelevator.Inventory;

public class Candy extends Products {

    public Candy(String name, Double price, String type) {

        super(name, price, type);

    }

    @Override
    public String getDispensingMsg() {
        return "Munch Munch, Yum!";
    }


}
