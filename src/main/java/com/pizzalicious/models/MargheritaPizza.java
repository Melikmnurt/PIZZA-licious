package com.pizzalicious.models;

// Signature Margherita Pizza
public class MargheritaPizza extends Pizza {

    public MargheritaPizza() {

        super(
                PizzaSize.MEDIUM,
                CrustType.REGULAR,
                false
        );

        addCheese(
                new Topping(
                        "Mozzarella",
                        "CHEESE",
                        1
                )
        );

        addRegularTopping(
                new Topping(
                        "Tomatoes",
                        "REGULAR",
                        1
                )
        );

        addRegularTopping(
                new Topping(
                        "Basil",
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

        addSauce(
                new Topping(
                        "Olive Oil",
                        "SAUCE",
                        1
                )
        );
    }
}