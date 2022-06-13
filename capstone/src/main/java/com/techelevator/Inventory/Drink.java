package com.techelevator.Inventory;

import java.math.BigDecimal;

public class Drink extends Products {

    public Drink(String name, BigDecimal price) {

        super(name, price);

    }

    public String getDispensingMsg() {
        return "Glug Glug, Yum!";
    }

}
