package com.techelevator.Inventory;

import java.math.BigDecimal;

public class Gum extends Products {

    public Gum(String name, BigDecimal price) {

        super(name, price);

    }

    public String getDispensingMsg() {
        return "Chew Chew, Yum!";
    }

}
