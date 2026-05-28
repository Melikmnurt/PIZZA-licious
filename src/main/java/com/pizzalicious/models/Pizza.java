package com.pizzalicious.models;

import java.util.ArrayList;

// Represents a pizza ordered by a customer
public class Pizza {

    // Pizza information
    private PizzaSize size;
    private CrustType crustType;
    private boolean stuffedCrust;

    // Pizza toppings
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

    // Methods for adding toppings

    public void addMeat(Topping topping) {
        meats.add(topping);
    }

    public void addCheese(Topping topping) {
        cheeses.add(topping);
    }

    public void addRegularTopping(Topping topping) {
        regularToppings.add(topping);
    }

    public void addSauce(Topping topping) {
        sauces.add(topping);
    }
    public double calculatePrice() {
        return 0;
    }
}