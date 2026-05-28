package com.pizzalicious.models;

import java.util.ArrayList;

public class Pizza {

    // pizza size: 8", 12", 16"
    private String size;

    // thin, regular, thick, cauliflower
    private String crustType;

    // stuffed crust yes/no
    private boolean stuffedCrust;

    // premium meat toppings
    private ArrayList<String> meats;

    // premium cheese toppings
    private ArrayList<String> cheeses;

    // regular toppings
    private ArrayList<String> regularToppings;

    // sauces
    private ArrayList<String> sauces;

}