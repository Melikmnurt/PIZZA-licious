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

            System.out.print(YELLOW + "\nSelect an option: " + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

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

            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print(YELLOW + "\nSelect an option: " + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

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

        System.out.println("1) Margherita");
        System.out.println("2) Veggie");

        System.out.print(YELLOW + "\nChoice: " + RESET);

        int choice = scanner.nextInt();
        scanner.nextLine();

        Pizza pizza = null;

        switch (choice) {

            case 1:
                pizza = new MargheritaPizza();
                break;

            case 2:
                pizza = new VeggiePizza();
                break;

            default:
                System.out.println(
                        RED + "Invalid pizza selection." + RESET
                );
                return;
        }

        order.addPizza(pizza);

        System.out.println(
                GREEN + "\nPizza added successfully!" + RESET
        );
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

        int choice = scanner.nextInt();
        scanner.nextLine();

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

        System.out.print("Quantity: ");

        int quantity = scanner.nextInt();
        scanner.nextLine();

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

        System.out.print(YELLOW + "\nChoice: " + RESET);

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:

                ReceiptManager receiptManager =
                        new ReceiptManager();

                receiptManager.saveReceipt(order);

                System.out.println(
                        GREEN + "\nOrder completed successfully!" + RESET
                );

                return true;

            case 0:

                System.out.println(
                        RED + "\nCheckout cancelled." + RESET
                );

                return false;

            default:

                System.out.println(
                        RED + "\nInvalid option." + RESET
                );

                return false;
        }
    }
}