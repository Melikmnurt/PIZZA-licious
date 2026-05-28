package com.pizzalicious.app;

import com.pizzalicious.models.Drink;
import com.pizzalicious.models.DrinkSize;
import com.pizzalicious.models.Topping;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to PIZZA-licious!");

        Topping pepperoni = new Topping("Pepperoni", "MEAT", 2);
        System.out.println(pepperoni);

        Drink sprite = new Drink(DrinkSize.LARGE, "Sprite");
        System.out.println(sprite);
        System.out.println(sprite.calculatePrice());
    }
}