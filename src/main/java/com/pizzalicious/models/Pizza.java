package com.pizzalicious.models;

import java.util.ArrayList;

// Represents a pizza ordered by a customer
public class Pizza {

    private PizzaSize size;
    private CrustType crustType;
    private boolean stuffedCrust;

    private ArrayList<Topping> meats;
    private ArrayList<Topping> cheeses;
    private ArrayList<Topping> regularToppings;
    private ArrayList<Topping> sauces;

    // Constructor
    public Pizza(PizzaSize size, CrustType crustType, boolean stuffedCrust) {

        this.size = size;
        this.crustType = crustType;
        this.stuffedCrust = stuffedCrust;

        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        regularToppings = new ArrayList<>();
        sauces = new ArrayList<>();
    }

    // Getters

    public PizzaSize getSize() {
        return size;
    }

    public CrustType getCrustType() {
        return crustType;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public ArrayList<Topping> getMeats() {
        return meats;
    }

    public ArrayList<Topping> getCheeses() {
        return cheeses;
    }

    public ArrayList<Topping> getRegularToppings() {
        return regularToppings;
    }

    public ArrayList<Topping> getSauces() {
        return sauces;
    }

    // Add toppings

    public void addMeat(Topping topping) {

        for (Topping existing : meats) {

            if (existing.getName().equalsIgnoreCase(topping.getName())) {

                existing.setQuantity(
                        existing.getQuantity()
                                + topping.getQuantity()
                );

                return;
            }
        }

        meats.add(topping);
    }

    public void addCheese(Topping topping) {

        for (Topping existing : cheeses) {

            if (existing.getName().equalsIgnoreCase(topping.getName())) {

                existing.setQuantity(
                        existing.getQuantity()
                                + topping.getQuantity()
                );

                return;
            }
        }

        cheeses.add(topping);
    }

    public void addRegularTopping(Topping topping) {

        for (Topping existing : regularToppings) {

            if (existing.getName().equalsIgnoreCase(topping.getName())) {

                existing.setQuantity(
                        existing.getQuantity()
                                + topping.getQuantity()
                );

                return;
            }
        }

        regularToppings.add(topping);
    }

    public void addSauce(Topping topping) {

        for (Topping existing : sauces) {

            if (existing.getName().equalsIgnoreCase(topping.getName())) {

                existing.setQuantity(
                        existing.getQuantity()
                                + topping.getQuantity()
                );

                return;
            }
        }

        sauces.add(topping);
    }

    // Calculate pizza price
    public double calculatePrice() {

        double total = 0;

        // Base pizza price
        switch (size) {

            case PERSONAL:
                total += 8.50;
                break;

            case MEDIUM:
                total += 12.00;
                break;

            case LARGE:
                total += 16.50;
                break;
        }

        // Meat pricing
        for (Topping meat : meats) {

            int quantity = meat.getQuantity();

            if (size == PizzaSize.PERSONAL) {

                total += 1.00;

                if (quantity > 1) {
                    total += (quantity - 1) * 0.50;
                }

            } else if (size == PizzaSize.MEDIUM) {

                total += 2.00;

                if (quantity > 1) {
                    total += (quantity - 1) * 1.00;
                }

            } else {

                total += 3.00;

                if (quantity > 1) {
                    total += (quantity - 1) * 1.50;
                }
            }
        }

        // Cheese pricing
        for (Topping cheese : cheeses) {

            int quantity = cheese.getQuantity();

            if (size == PizzaSize.PERSONAL) {

                total += 0.75;

                if (quantity > 1) {
                    total += (quantity - 1) * 0.30;
                }

            } else if (size == PizzaSize.MEDIUM) {

                total += 1.50;

                if (quantity > 1) {
                    total += (quantity - 1) * 0.60;
                }

            } else {

                total += 2.25;

                if (quantity > 1) {
                    total += (quantity - 1) * 0.90;
                }
            }
        }

        // Stuffed crust has no additional charge
        return total;
    }

    @Override
    public String toString() {

        StringBuilder pizzaDetails = new StringBuilder();

        pizzaDetails.append(size)
                .append(" Pizza\n");

        pizzaDetails.append("Crust: ")
                .append(crustType)
                .append("\n");

        if (stuffedCrust) {
            pizzaDetails.append("Stuffed Crust\n");
        }

        if (!meats.isEmpty()) {

            pizzaDetails.append("Meats:\n");

            for (Topping topping : meats) {
                pizzaDetails.append("  - ")
                        .append(topping)
                        .append("\n");
            }
        }

        if (!cheeses.isEmpty()) {

            pizzaDetails.append("Cheeses:\n");

            for (Topping topping : cheeses) {
                pizzaDetails.append("  - ")
                        .append(topping)
                        .append("\n");
            }
        }

        if (!regularToppings.isEmpty()) {

            pizzaDetails.append("Regular Toppings:\n");

            for (Topping topping : regularToppings) {
                pizzaDetails.append("  - ")
                        .append(topping)
                        .append("\n");
            }
        }

        if (!sauces.isEmpty()) {

            pizzaDetails.append("Sauces:\n");

            for (Topping topping : sauces) {
                pizzaDetails.append("  - ")
                        .append(topping)
                        .append("\n");
            }
        }

        pizzaDetails.append("Price: $")
                .append(String.format("%.2f", calculatePrice()));

        return pizzaDetails.toString();
    }
}