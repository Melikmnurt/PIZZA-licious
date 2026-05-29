package com.pizzalicious.models;

import java.util.ArrayList;

// Represents a customer's order
public class Order {

    // Items in the order
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;

    // Quantity of garlic knots ordered
    private int garlicKnotsQuantity;

    // Constructor
    public Order() {

        pizzas = new ArrayList<>();
        drinks = new ArrayList<>();
        garlicKnotsQuantity = 0;
    }

    // Adds a pizza to the order
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // Adds a drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // Adds garlic knots to the order
    public void addGarlicKnots(int quantity) {
        garlicKnotsQuantity += quantity;
    }

    // Returns all pizzas
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    // Returns all drinks
    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    // Returns garlic knot quantity
    public int getGarlicKnotsQuantity() {
        return garlicKnotsQuantity;
    }

    // Checks if the order satisfies the assignment requirements
    public boolean isValidOrder() {

        return !(pizzas.isEmpty()
                && drinks.isEmpty()
                && garlicKnotsQuantity == 0);
    }

    // Calculates total cost of the order
    public double calculateTotal() {

        double total = 0;

        // Add pizza prices
        for (Pizza pizza : pizzas) {
            total += pizza.calculatePrice();
        }

        // Add drink prices
        for (Drink drink : drinks) {
            total += drink.calculatePrice();
        }

        // Add garlic knots
        total += garlicKnotsQuantity * 1.50;

        return total;
    }

    @Override
    public String toString() {

        StringBuilder orderDetails = new StringBuilder();

        orderDetails.append("Order Summary\n");
        orderDetails.append("-------------------------\n");

        for (Pizza pizza : pizzas) {
            orderDetails.append(pizza).append("\n\n");
        }

        for (Drink drink : drinks) {
            orderDetails.append(drink).append("\n");
        }

        if (garlicKnotsQuantity > 0) {
            orderDetails.append("Garlic Knots x")
                    .append(garlicKnotsQuantity)
                    .append("\n");
        }

        orderDetails.append("\nTotal: $")
                .append(String.format("%.2f", calculateTotal()));

        return orderDetails.toString();
    }
}