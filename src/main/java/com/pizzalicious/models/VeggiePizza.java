package com.pizzalicious.models;

// Signature Veggie Pizza
public class VeggiePizza extends Pizza {

    public VeggiePizza() {

        super(
                PizzaSize.PERSONAL,
                CrustType.REGULAR,
                false
        );

        addRegularTopping(
                new Topping(
                        "Bell Peppers",
                        "REGULAR",
                        1
                )
        );

        addRegularTopping(
                new Topping(
                        "Spinach",
                        "REGULAR",
                        1
                )
        );

        addRegularTopping(
                new Topping(
                        "Olives",
                        "REGULAR",
                        1
                )
        );

        addRegularTopping(
                new Topping(
                        "Onions",
                        "REGULAR",
                        1
                )
        );

        addSauce(
                new Topping(
                        "Marinara",
                        "SAUCE",
                        1
                )
        );

        addCheese(
                new Topping(
                        "Mozzarella",
                        "CHEESE",
                        1
                )
        );
    }
}