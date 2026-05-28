package com.pizzalicious.models;

// Represents a drink that can be added to an order
public class Drink {

    // Size of the drink
    private DrinkSize size;

    // Flavor of the drink
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

    // Calculates drink price based on size
    public double calculatePrice() {

        switch (size) {

            case SMALL:
                return 2.00;

            case MEDIUM:
                return 2.50;

            case LARGE:
                return 3.00;

            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return size + " " + flavor;
    }
}