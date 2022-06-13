package com.techelevator.Inventory;

import java.math.BigDecimal;

public class Chip extends Products {

    public Chip(String name, BigDecimal price) {

        super(name, price);

    }

    public String getDispensingMsg() {
        return "Crunch Crunch, Yum!";
    }



}
