package com.tacos.ui;

import com.tacos.enums.ShellType;
import com.tacos.enums.TacoSize;
import com.tacos.models.*;
import com.tacos.services.OrderService;
import com.tacos.services.PricingService;
import com.tacos.services.ReceiptService;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final PricingService pricingService;
    private final ReceiptService receiptService;
    private final OrderService orderService;

    public UserInterface() {

        scanner = new Scanner(System.in);

        pricingService = new PricingService();
        receiptService = new ReceiptService();
        orderService = new OrderService();
    }

    public void display() {

        boolean running = true;

        while (running) {

            System.out.println("""
                    
                    ===== TACOVERSE =====
                    1) New Order
                    0) Exit
                    """);

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> newOrder();

                case "0" -> {
                    running = false;
                    System.out.println("Thank you for supporting TacoVerse!");
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void newOrder() {

        Order order = new Order();

        boolean ordering = true;

        while (ordering) {

            System.out.println("""
                
                ===== ORDER MENU =====
                1) Add Taco
                2) Add Signature Taco
                3) Add Combo
                4) Add Drink
                5) Add Chips & Salsa
                6) Checkout
                0) Cancel Order
                """);

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> order.getTacos().add(buildCustomTaco());

                case "2" -> addSignatureTaco(order);

                case "3" -> addCombo(order);

                case "4" -> addDrink(order);

                case "5" -> addChips(order);

                case "6" -> {

                    if (order.getTacos().isEmpty()
                            && order.getDrinks().isEmpty()
                            && order.getChips().isEmpty()
                            && order.getCombos().isEmpty()) {

                        System.out.println("Order cannot be empty.");
                        break;
                    }

                    checkout(order);

                    ordering = false;
                }

                case "0" -> {

                    System.out.println("Order canceled.");

                    ordering = false;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }

    private Taco buildCustomTaco() {

        Taco taco = new Taco();

        selectTacoSize(taco);

        selectShell(taco);

        addMeat(taco);

        addCheese(taco);

        addRegularToppings(taco);

        addSauces(taco);

        askIfCovered(taco);

        return taco;
    }

    private void selectTacoSize(Taco taco) {

        System.out.println("""
                
                Select Taco Size:
                1) Single Taco
                2) 3-Taco Plate
                3) Burrito
                """);

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> taco.setSize(TacoSize.SINGLE);

            case "2" -> taco.setSize(TacoSize.THREE_TACO);

            case "3" -> taco.setSize(TacoSize.BURRITO);

            default -> {
                System.out.println("Invalid option. Defaulting to SINGLE.");
                taco.setSize(TacoSize.SINGLE);
            }
        }
    }

    private void selectShell(Taco taco) {

        System.out.println("""
                
                Select Shell Type:
                1) Hard Shell
                2) Flour
                3) Corn
                """);

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> taco.setShell(ShellType.CORN);

            case "2" -> taco.setShell(ShellType.FLOUR);

            case "3" -> taco.setShell(ShellType.HARD_SHELL);

            default -> {
                System.out.println("Invalid option. Defaulting to FLOUR tortilla.");
                taco.setShell(ShellType.FLOUR);
            }
        }
    }

    private void addMeat(Taco taco) {

        System.out.println("""
                
                Select Meat:
                - Carne Asada
                - Al Pastor
                - Pollo
                """);

        String meat = scanner.nextLine();

        taco.getMeats().add(meat);

        System.out.println("Would you like extra meat? (yes/no)");

        taco.setExtraMeat(scanner.nextLine().equalsIgnoreCase("yes"));
    }

    private void addCheese(Taco taco) {

        System.out.println("""
                
                Select Cheese:
                - Queso
                - Cotija
                - Cheddar
                """);

        String cheese = scanner.nextLine();

        taco.getCheeses().add(cheese);

        System.out.println("Would you like extra cheese? (yes/no)");

        taco.setExtraCheese(scanner.nextLine().equalsIgnoreCase("yes"));
    }

    private void addRegularToppings(Taco taco) {

        boolean addingToppings = true;

        while (addingToppings) {

            System.out.println("""
                    
                    Add Topping:
                    - Cilantro
                    - Onions
                    - Tomatoes
                    - Jalapenos
                    - Radishes
                    - Pico de Gallo
                    - Guacamole
                    - Corn
                    - Lettuce
                    - Pickled Onion
                    - Lime
                    - Slaw
                    - Sour Cream
                    - Cheese
                    
                    Type DONE when finished.
                    """);

            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")) {

                addingToppings = false;

            } else {

                taco.getToppings().add(topping);
            }
        }
    }

    private void addSauces(Taco taco) {

        boolean addingSauces = true;

        while (addingSauces) {

            System.out.println("""
                    
                    Add Sauce:
                    - Salsa Verde
                    - Salsa Roja
                    - Chipotle
                    - Habanero
                    - Mild
                    - Extra Hot
                    - Lime Guacamole
                    - Regular Guacamole
                    
                    Type DONE when finished.
                    """);

            String sauce = scanner.nextLine();

            if (sauce.equalsIgnoreCase("done")) {

                addingSauces = false;

            } else {

                taco.getSauces().add(sauce);
            }
        }
    }

    private void askIfCovered(Taco taco) {

        System.out.println("""
                
                Would you like your taco/burrito
                covered in salsa and queso?
                (yes/no)
                """);

        taco.setCovered(scanner.nextLine().equalsIgnoreCase("yes"));
    }

    private void addSignatureTaco(Order order) {

        System.out.println("""
                
                Signature Tacos:
                1) Street Taco
                2) Super Burrito
                """);

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> {

                Taco streetTaco = new StreetTaco();

                order.getTacos().add(streetTaco);

                System.out.println("Street Taco added!");
            }

            case "2" -> {

                Taco superBurrito = new SuperBurrito();

                order.getTacos().add(superBurrito);

                System.out.println("Super Burrito added!");
            }

            default -> System.out.println("Invalid option.");
        }
    }

    private void addCombo(Order order) {

        System.out.println("""
            
            ===== COMBO MENU =====
            1) Street Taco Combo
               - 3 Street Tacos
               - Medium Drink
            
            2) Taco Snack Combo
               - 1 Taco
               - Chips & Salsa
            """);

        String choice = scanner.nextLine();

        switch (choice) {

            case "1" -> {

                ComboOrder combo = new StreetTacoCombo();

                order.getCombos().add(combo);

                System.out.println("Street Taco Combo added!");
            }

            case "2" -> {

                ComboOrder combo = new TacoSnackCombo();

                order.getCombos().add(combo);

                System.out.println("Taco Snack Combo added!");
            }

            default -> System.out.println("Invalid option.");
        }
    }

    private void addDrink(Order order) {

        System.out.println("""
                
                Drink Sizes:
                1) Small
                2) Medium
                3) Large
                """);

        String sizeChoice = scanner.nextLine();

        String size = switch (sizeChoice) {

            case "1" -> "Small";

            case "2" -> "Medium";

            case "3" -> "Large";

            default -> "Small";
        };

        System.out.println("Enter drink flavor:");

        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);

        order.getDrinks().add(drink);

        System.out.println("Drink added!");
    }

    private void addChips(Order order) {

        System.out.println("""
                
                Select Salsa Type:
                - Salsa Verde
                - Salsa Roja
                - Mild
                - Extra Hot
                - Lime Guacamole
                - Regular Guacamole
                """);

        String salsa = scanner.nextLine();

        ChipsAndGuac chips = new ChipsAndGuac(salsa);

        order.getChips().add(chips);

        System.out.println("Chips & Salsa added!");
    }

    private void checkout(Order order) {

        System.out.println("\n===== ORDER SUMMARY =====\n");

        orderService.displayOrder(order);

        double total = pricingService.calculateOrderTotal(order);

        System.out.printf("%nTOTAL: $%.2f%n", total);

        System.out.println("""
                
                1) Confirm Order
                0) Cancel Order
                """);

        String choice = scanner.nextLine();

        if (choice.equals("1")) {

            receiptService.saveReceipt(order, total);

            System.out.println("Receipt saved successfully!");

        } else {

            System.out.println("Order canceled.");
        }
    }
}
