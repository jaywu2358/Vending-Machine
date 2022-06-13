package com.techelevator.Inventory;

import java.math.BigDecimal;

public class Candy extends Products {

    public Candy(String name, BigDecimal price) {

        super(name, price);

    }

    public String getDispensingMsg() {
        return "Munch Munch, Yum!";
    }


}
