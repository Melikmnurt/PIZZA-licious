package com.pizzalicious.models;

// Represents a topping and how many times it was added
public class Topping {

    // Name of the topping
    private String name;

    // Type of topping:
    // MEAT, CHEESE, REGULAR, SAUCE
    private String toppingType;

    // Quantity selected by the customer
    private int quantity;

    // Constructor
    public Topping(String name, String toppingType, int quantity) {
        this.name = name;
        this.toppingType = toppingType;
        this.quantity = quantity;
    }

    // Returns the topping name
    public String getName() {
        return name;
    }

    // Returns the topping type
    public String getToppingType() {
        return toppingType;
    }

    // Returns the quantity
    public int getQuantity() {
        return quantity;
    }

    // Updates the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " x" + quantity;
    }
}