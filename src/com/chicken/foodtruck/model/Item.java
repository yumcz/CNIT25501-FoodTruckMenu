package com.chicken.foodtruck.model;
/**
 * Item.java
 * @author Andrew Ngo, Kotaro Tomas
 * Shows results of items
 */

public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean vegetarian;

    public Item(int id, String name, String description, double price, boolean vegetarian) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setVegetarian(vegetarian);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Error. Invalid ID.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error. Invalid name.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Error. Invalid description.");
        }
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Error. Invalid price.");
        }
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Name: " + name
                + " | Description: " + description
                + " | Price: $" + String.format("%.2f", price)
                + " | Vegetarian: " + vegetarian;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        System.out.println(java.time.LocalDateTime.now());
    }
}