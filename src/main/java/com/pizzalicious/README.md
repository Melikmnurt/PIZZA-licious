# PIZZA-licious

A Java console-based pizza ordering application that allows customers to create custom pizzas, order signature pizzas, add drinks and garlic knots, checkout, and generate receipts.

## Features

### Home Screen
- Start a new order
- Exit the application

### Pizza Ordering
- Create custom pizzas
- Choose pizza size:
    - Personal
    - Medium
    - Large
- Choose crust type:
    - Thin
    - Regular
    - Thick
    - Cauliflower
- Optional stuffed crust
- Add multiple:
    - Meats
    - Cheeses
    - Regular toppings
    - Sauces
- Support for extra toppings through quantities

### Signature Pizzas
- Margherita Pizza
- Veggie Pizza

### Additional Items
- Drinks
    - Small
    - Medium
    - Large
- Garlic Knots

### Checkout
- View order summary
- Calculate total cost
- Confirm or cancel checkout

### Receipts
- Automatically generates receipt files
- Saves receipts in the `receipts` folder

---

## Object-Oriented Programming Concepts Used

### Inheritance
- `MargheritaPizza` extends `Pizza`
- `VeggiePizza` extends `Pizza`

### Composition
- An `Order` contains:
    - Pizzas
    - Drinks
    - Garlic Knots

### Collections
- `ArrayList` used to store:
    - Pizzas
    - Drinks
    - Toppings

### Enums
- `PizzaSize`
- `DrinkSize`
- `CrustType`

### File I/O
- Receipt generation and storage

---

## Project Structure

```text
src
└── main
    └── java
        └── com.pizzalicious
            ├── app
            ├── models
            ├── services
            └── ui
```

---

## UML Diagram

![UML Diagram](diagrams/uml-diagram.png)

---

## Technologies Used

- Java 17
- Maven
- IntelliJ IDEA
- Git
- GitHub

---

## How to Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA

3. Build the project

4. Run:

```text
com.pizzalicious.app.Main
```

---

## Author

Abdulmelik Tuhaye