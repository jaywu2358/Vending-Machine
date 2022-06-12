package com.techelevator.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Products {

    private String name;
    private Double price;
    private String type;
    private int stock = 5;
    private int sales;

    public Products (String name, Double price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
        stock = 5;
        sales = 0;
    }

    public Products() {

    }

    public String getDispensingMsg() {
        return "";
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public int getSales() {
        return sales;
    }
}


