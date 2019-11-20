package com.catalog.models;

public class ProductType1{
    private String name;
    private String description;
    private String productType;
    private double price;

    public ProductType1(String name, String description, String productType, double price) {
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
