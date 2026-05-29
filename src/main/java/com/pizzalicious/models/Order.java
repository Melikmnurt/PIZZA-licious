package com.pizzalicious.models;

import java.util.ArrayList;

// Represents a customer's order
public class Order {

    // Items in the order
    private ArrayList<OrderItem> items;
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;

    // Quantity of garlic knots ordered
    private int garlicKnotsQuantity;

    // Constructor
    public Order() {

        items = new ArrayList<>();
        pizzas = new ArrayList<>();
        drinks = new ArrayList<>();
        garlicKnotsQuantity = 0;
    }

    // Adds a pizza to the order
    public void addPizza(Pizza pizza) {
        items.add(pizza);
        pizzas.add(pizza);
    }

    // Adds a drink to the order
    public void addDrink(Drink drink) {
        items.add(drink);
        drinks.add(drink);
    }

    // Adds garlic knots to the order
    public void addGarlicKnots(int quantity) {
        items.add(new GarlicKnots(quantity));
        garlicKnotsQuantity += quantity;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
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

        return !items.isEmpty();
    }

    // Calculates total cost of the order
    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.calculatePrice();
        }

        return total;
    }

    @Override
    public String toString() {

        StringBuilder orderDetails = new StringBuilder();

        orderDetails.append("Order Summary\n");
        orderDetails.append("-------------------------\n");

        for (int i = items.size() - 1; i >= 0; i--) {
            orderDetails.append(items.get(i)).append("\n\n");
        }

        orderDetails.append("\nTotal: $")
                .append(String.format("%.2f", calculateTotal()));

        return orderDetails.toString();
    }
}
