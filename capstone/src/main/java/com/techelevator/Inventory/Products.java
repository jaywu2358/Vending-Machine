package com.techelevator.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public abstract class Products {

    private String name;
    private BigDecimal price;
    private String type;
    private int stock = 5;

    public Products (String name, BigDecimal price){
        this.name = name;
        this.price = price;

    }

    public abstract String getDispensingMsg();

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void sold() {
        stock--;
    }
}


