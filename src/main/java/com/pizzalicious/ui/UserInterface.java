package com.pizzalicious.ui;
import com.pizzalicious.models.*;
import com.pizzalicious.models.Order;
import com.pizzalicious.services.ReceiptManager;
import java.util.Scanner;

public class UserInterface {

    // Colors
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    // Starts the application
    public void displayHomeScreen() {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(CYAN + "================================");
            System.out.println("       PIZZA-licious");
            System.out.println("================================" + RESET);

            System.out.println(GREEN + "1) New Order" + RESET);
            System.out.println(RED + "0) Exit" + RESET);

            int choice = readInt(YELLOW + "\nSelect an option: " + RESET);

            switch (choice) {

                case 1:

                    Order order = new Order();
                    displayOrderScreen(order);
                    break;

                case 0:

                    System.out.println(
                            GREEN + "\nThank you for visiting PIZZA-licious!" + RESET
                    );

                    running = false;
                    break;

                default:

                    System.out.println(
                            RED + "\nInvalid option. Please try again." + RESET
                    );
            }
        }
    }

    // Displays the order screen
    private void displayOrderScreen(Order order) {

        boolean ordering = true;

        while (ordering) {

            System.out.println();
            System.out.println(CYAN + "================================");
            System.out.println("          ORDER MENU");
            System.out.println("================================" + RESET);

            displayCurrentOrderItems(order);

            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = readInt(YELLOW + "\nSelect an option: " + RESET);

            switch (choice) {

                case 1:
                    addPizza(order);
                    break;

                case 2:
                    addDrink(order);
                    break;

                case 3:
                    addGarlicKnots(order);
                    break;

                case 4:
                    if (checkout(order)) {
                        ordering = false;
                    }
                    break;

                case 0:

                    System.out.println(
                            RED + "\nOrder cancelled." + RESET
                    );

                    ordering = false;
                    break;

                default:

                    System.out.println(
                            RED + "\nInvalid option. Please try again." + RESET
                    );
            }
        }
    }
    private void addPizza(Order order) {

        System.out.println();
        System.out.println(CYAN + "SELECT PIZZA TYPE" + RESET);

        System.out.println("1) Custom Pizza");
        System.out.println("2) Margherita");
        System.out.println("3) Veggie");
        System.out.println("0) Back");

        int choice = readInt(YELLOW + "\nChoice: " + RESET);

        Pizza pizza = null;

        switch (choice) {

            case 1:
                addCustomPizza(order);
                return;

            case 2:
                pizza = new MargheritaPizza();
                break;

            case 3:
                pizza = new VeggiePizza();
                break;

            case 0:
                return;

            default:
                System.out.println(
                        RED + "Invalid pizza selection." + RESET
                );
                return;
        }

        customizeSignaturePizza(pizza);
        order.addPizza(pizza);

        System.out.println(
                GREEN + "\nPizza added successfully!" + RESET
        );
    }
    private void addCustomPizza(Order order) {

        System.out.println();
        System.out.println(CYAN + "CUSTOM PIZZA" + RESET);

        // Select Size
        System.out.println("\nSelect Size");
        System.out.println("1) Personal");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int sizeChoice = readInt(YELLOW + "Choice: " + RESET);

        PizzaSize size;

        switch (sizeChoice) {

            case 1:
                size = PizzaSize.PERSONAL;
                break;

            case 2:
                size = PizzaSize.MEDIUM;
                break;

            case 3:
                size = PizzaSize.LARGE;
                break;

            default:
                System.out.println(
                        RED + "Invalid size selected." + RESET
                );
                return;
        }

        // Select Crust
        System.out.println("\nSelect Crust");
        System.out.println("1) Thin");
        System.out.println("2) Regular");
        System.out.println("3) Thick");
        System.out.println("4) Cauliflower");

        int crustChoice = readInt(YELLOW + "Choice: " + RESET);

        CrustType crustType;

        switch (crustChoice) {

            case 1:
                crustType = CrustType.THIN;
                break;

            case 2:
                crustType = CrustType.REGULAR;
                break;

            case 3:
                crustType = CrustType.THICK;
                break;

            case 4:
                crustType = CrustType.CAULIFLOWER;
                break;

            default:
                System.out.println(
                        RED + "Invalid crust selected." + RESET
                );
                return;
        }

        // Stuffed Crust
        System.out.println("\nStuffed Crust?");
        System.out.println("1) Yes");
        System.out.println("2) No");

        int stuffedChoice = readInt(YELLOW + "Choice: " + RESET);

        if (stuffedChoice != 1 && stuffedChoice != 2) {
            System.out.println(
                    RED + "Invalid stuffed crust selection." + RESET
            );
            return;
        }

        boolean stuffedCrust = (stuffedChoice == 1);

        // Create Pizza
        Pizza pizza = new Pizza(
                size,
                crustType,
                stuffedCrust
        );

        // Add toppings
        addMeatToppings(pizza);
        addCheeseToppings(pizza);
        addRegularToppings(pizza);
        addSauces(pizza);

        order.addPizza(pizza);

        System.out.println(
                GREEN + "\nCustom pizza added successfully!" + RESET
        );
    }
    private void addMeatToppings(Pizza pizza) {

        while (true) {

            System.out.println("\nADD MEATS");

            System.out.println("1) Pepperoni");
            System.out.println("2) Sausage");
            System.out.println("3) Ham");
            System.out.println("4) Bacon");
            System.out.println("5) Chicken");
            System.out.println("6) Meatball");
            System.out.println("0) Done");

            int choice = readInt(YELLOW + "Choice: " + RESET);

            if (choice == 0) {
                return;
            }

            String meatName;

            switch (choice) {

                case 1:
                    meatName = "Pepperoni";
                    break;

                case 2:
                    meatName = "Sausage";
                    break;

                case 3:
                    meatName = "Ham";
                    break;

                case 4:
                    meatName = "Bacon";
                    break;

                case 5:
                    meatName = "Chicken";
                    break;

                case 6:
                    meatName = "Meatball";
                    break;

                default:
                    continue;
            }

            int quantity = readPositiveInt("Quantity: ");

            pizza.addMeat(
                    new Topping(
                            meatName,
                            "MEAT",
                            quantity
                    )
            );
        }
    }
    private void addCheeseToppings(Pizza pizza) {

        while (true) {

            System.out.println("\nADD CHEESES");

            System.out.println("1) Mozzarella");
            System.out.println("2) Parmesan");
            System.out.println("3) Ricotta");
            System.out.println("4) Goat Cheese");
            System.out.println("5) Buffalo");
            System.out.println("0) Done");

            int choice = readInt(YELLOW + "Choice: " + RESET);

            if (choice == 0) {
                return;
            }

            String cheeseName;

            switch (choice) {

                case 1:
                    cheeseName = "Mozzarella";
                    break;

                case 2:
                    cheeseName = "Parmesan";
                    break;

                case 3:
                    cheeseName = "Ricotta";
                    break;

                case 4:
                    cheeseName = "Goat Cheese";
                    break;

                case 5:
                    cheeseName = "Buffalo";
                    break;

                default:
                    continue;
            }

            int quantity = readPositiveInt("Quantity: ");

            pizza.addCheese(
                    new Topping(
                            cheeseName,
                            "CHEESE",
                            quantity
                    )
            );
        }
    }
    private void addRegularToppings(Pizza pizza) {

        while (true) {

            System.out.println("\nADD REGULAR TOPPINGS");

            System.out.println("1) Tomatoes");
            System.out.println("2) Onions");
            System.out.println("3) Olives");
            System.out.println("4) Bell Peppers");
            System.out.println("5) Spinach");
            System.out.println("6) Basil");
            System.out.println("7) Mushrooms");
            System.out.println("8) Pineapple");
            System.out.println("9) Anchovies");
            System.out.println("0) Done");

            int choice = readInt(YELLOW + "Choice: " + RESET);

            if (choice == 0) {
                return;
            }

            String toppingName;

            switch (choice) {

                case 1:
                    toppingName = "Tomatoes";
                    break;

                case 2:
                    toppingName = "Onions";
                    break;

                case 3:
                    toppingName = "Olives";
                    break;

                case 4:
                    toppingName = "Bell Peppers";
                    break;

                case 5:
                    toppingName = "Spinach";
                    break;

                case 6:
                    toppingName = "Basil";
                    break;

                case 7:
                    toppingName = "Mushrooms";
                    break;

                case 8:
                    toppingName = "Pineapple";
                    break;

                case 9:
                    toppingName = "Anchovies";
                    break;

                default:
                    continue;
            }

            int quantity = readPositiveInt("Quantity: ");

            pizza.addRegularTopping(
                    new Topping(
                            toppingName,
                            "REGULAR",
                            quantity
                    )
            );
        }
    }
    private void addSauces(Pizza pizza) {

        while (true) {

            System.out.println("\nADD SAUCES");

            System.out.println("1) Marinara");
            System.out.println("2) Alfredo");
            System.out.println("3) Pesto");
            System.out.println("4) BBQ");
            System.out.println("5) Buffalo");
            System.out.println("6) Olive Oil");
            System.out.println("0) Done");

            int choice = readInt(YELLOW + "Choice: " + RESET);

            if (choice == 0) {
                return;
            }

            String sauceName;

            switch (choice) {

                case 1:
                    sauceName = "Marinara";
                    break;

                case 2:
                    sauceName = "Alfredo";
                    break;

                case 3:
                    sauceName = "Pesto";
                    break;

                case 4:
                    sauceName = "BBQ";
                    break;

                case 5:
                    sauceName = "Buffalo";
                    break;

                case 6:
                    sauceName = "Olive Oil";
                    break;

                default:
                    continue;
            }

            int quantity = readPositiveInt("Quantity: ");

            pizza.addSauce(
                    new Topping(
                            sauceName,
                            "SAUCE",
                            quantity
                    )
            );
        }
    }
    private void addDrink(Order order) {

        System.out.println();
        System.out.println(CYAN + "ADD DRINK" + RESET);

        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();

        System.out.println("\nSelect Size");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int choice = readInt(YELLOW + "Choice: " + RESET);

        DrinkSize size;

        switch (choice) {

            case 1:
                size = DrinkSize.SMALL;
                break;

            case 2:
                size = DrinkSize.MEDIUM;
                break;

            case 3:
                size = DrinkSize.LARGE;
                break;

            default:
                System.out.println(
                        RED + "Invalid size selected." + RESET
                );
                return;
        }

        Drink drink = new Drink(size, flavor);

        order.addDrink(drink);

        System.out.println(
                GREEN + "\nDrink added successfully!" + RESET
        );
    }
    private void addGarlicKnots(Order order) {

        System.out.println();
        System.out.println(CYAN + "ADD GARLIC KNOTS" + RESET);

        int quantity = readPositiveInt("Quantity: ");

        order.addGarlicKnots(quantity);

        System.out.println(
                GREEN + "\nGarlic knots added successfully!" + RESET
        );
    }
    private boolean checkout(Order order) {

        if (!order.isValidOrder()) {

            System.out.println(
                    RED + "\nOrder must contain at least one item." + RESET
            );

            return false;
        }

        System.out.println();
        System.out.println(CYAN + "CHECKOUT" + RESET);

        System.out.println();
        System.out.println(order);

        System.out.println();
        System.out.println("1) Confirm");
        System.out.println("0) Cancel");

        int choice = readInt(YELLOW + "\nChoice: " + RESET);

        switch (choice) {

            case 1:

                ReceiptManager receiptManager =
                        new ReceiptManager();

                boolean receiptSaved = receiptManager.saveReceipt(order);

                if (!receiptSaved) {
                    System.out.println(
                            RED + "\nOrder was not completed because the receipt could not be saved." + RESET
                    );

                    return false;
                }

                System.out.println(
                        GREEN + "\nOrder completed successfully!" + RESET
                );

                return true;

            case 0:

                System.out.println(
                        RED + "\nCheckout cancelled. Order deleted." + RESET
                );

                return true;

            default:

                System.out.println(
                        RED + "\nInvalid option." + RESET
                );

                return false;
        }
    }

    private void displayCurrentOrderItems(Order order) {

        if (order.getItems().isEmpty()) {
            System.out.println("Current order: empty\n");
            return;
        }

        System.out.println("Current order (newest first):");

        for (int i = order.getItems().size() - 1; i >= 0; i--) {
            System.out.println((order.getItems().size() - i)
                    + ") "
                    + order.getItems().get(i));
        }

        System.out.println();
    }

    private void customizeSignaturePizza(Pizza pizza) {

        boolean customizing = true;

        while (customizing) {

            System.out.println();
            System.out.println(CYAN + "CUSTOMIZE SIGNATURE PIZZA" + RESET);
            System.out.println(pizza);
            System.out.println("\n1) Add Meat");
            System.out.println("2) Add Cheese");
            System.out.println("3) Add Regular Topping");
            System.out.println("4) Add Sauce");
            System.out.println("5) Remove Topping");
            System.out.println("0) Done");

            int choice = readInt(YELLOW + "\nChoice: " + RESET);

            switch (choice) {

                case 1:
                    addMeatToppings(pizza);
                    break;

                case 2:
                    addCheeseToppings(pizza);
                    break;

                case 3:
                    addRegularToppings(pizza);
                    break;

                case 4:
                    addSauces(pizza);
                    break;

                case 5:
                    removeTopping(pizza);
                    break;

                case 0:
                    customizing = false;
                    break;

                default:
                    System.out.println(
                            RED + "Invalid option. Please try again." + RESET
                    );
            }
        }
    }

    private void removeTopping(Pizza pizza) {

        System.out.print("Enter topping name to remove: ");
        String toppingName = scanner.nextLine();

        if (pizza.removeTopping(toppingName)) {
            System.out.println(GREEN + "Topping removed." + RESET);
        } else {
            System.out.println(RED + "Topping not found." + RESET);
        }
    }

    private int readPositiveInt(String prompt) {

        int value = readInt(prompt);

        while (value <= 0) {
            System.out.println(RED + "Please enter a number greater than 0." + RESET);
            value = readInt(prompt);
        }

        return value;
    }

    private int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            if (!scanner.hasNextLine()) {
                System.out.println();
                return 0;
            }

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Please enter a valid number." + RESET);
            }
        }
    }
}
