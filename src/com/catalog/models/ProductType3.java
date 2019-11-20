package com.catalog.models;

public class ProductType3{
    private String name;
    private String includes;
    private double price;

    public ProductType3(String name, String includes, double price) {
        this.name = name;
        this.includes = includes;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncludes() {
        return includes;
    }

    public void setIncludes(String includes) {
        this.includes = includes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
