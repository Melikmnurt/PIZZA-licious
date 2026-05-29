package com.pizzalicious.models;

public class GarlicKnots implements OrderItem {

    private int quantity;

    public GarlicKnots(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculatePrice() {
        return quantity * 1.50;
    }

    @Override
    public String toString() {
        return "Garlic Knots x"
                + quantity
                + " - $"
                + String.format("%.2f", calculatePrice());
    }
}
