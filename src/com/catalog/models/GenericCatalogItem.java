package com.catalog.models;

import java.util.Objects;

public class GenericCatalogItem {
    private String name;
    private String description;
    private int category;
    private double price;

    public GenericCatalogItem() {
    }

    public GenericCatalogItem(String name, String description, int category, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericCatalogItem that = (GenericCatalogItem) o;
        return category == that.category &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, category, price);
    }

    @Override
    public String toString() {
        return "GenericCatalogItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
