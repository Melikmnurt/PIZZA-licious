package com.pizzalicious.models;

// Represents a drink that can be added to an order
public class Drink {

    // Size of the drink: SMALL, MEDIUM, or LARGE
    private DrinkSize size;

    // Flavor of the drink, such as Sprite, Coke, Root Beer, etc.
    private String flavor;

    // Constructor
    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // Returns the drink size
    public DrinkSize getSize() {
        return size;
    }

    // Returns the drink flavor
    public String getFlavor() {
        return flavor;
    }

    // Calculates the drink price based on size
    public double calculatePrice() {
        if (size == DrinkSize.SMALL) {
            return 2.00;
        } else if (size == DrinkSize.MEDIUM) {
            return 2.50;
        } else {
            return 3.00;
        }
    }

    // Displays the drink in a clean format
    @Override
    public String toString() {
        return size + " " + flavor;
    }
}