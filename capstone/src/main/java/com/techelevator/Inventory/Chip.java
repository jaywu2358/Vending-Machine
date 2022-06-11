package com.techelevator.Inventory;

public class Chip extends Products {

    public Chip(String name, Double price, String type) {

        super(name, price, type);

    }

    @Override
    public String getDispensingMsg() {
        return "Crunch Crunch, Yum!";
    }



}
