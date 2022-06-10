package com.techelevator;

public class Products {

    private String name;
    private int slotNumber;
    private String productType;
    private int price;
    private int availableStock;

    public Products (String name, int slotNumber, String productType, int price, int availableStock) {
        this.name = name;
        this.slotNumber = slotNumber;
        this.productType = productType;
        this.price = price;
        this.availableStock = availableStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }
}
