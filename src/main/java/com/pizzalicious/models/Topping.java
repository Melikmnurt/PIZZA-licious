package com.pizzalicious.models;

// Represents a topping and how many times it was added
public class Topping {

    // Name of the topping
    private String name;

    // Quantity selected by the customer
    private int quantity;

    // Constructor
    public Topping(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Returns the topping name
    public String getName() {
        return name;
    }

    // Returns the quantity
    public int getQuantity() {
        return quantity;
    }

    // Updates the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}