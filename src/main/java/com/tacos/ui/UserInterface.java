package com.tacos.ui;

import com.tacos.enums.ShellType;
import com.tacos.enums.TacoSize;
import com.tacos.models.*;
import com.tacos.services.OrderService;
import com.tacos.services.PricingService;
import com.tacos.services.ReceiptService;

import java.util.Scanner;

import static com.tacos.ui.ConsoleUI.*;

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

    // main menu
    public void display() {

        boolean running = true;

        while (running) {

            title("""
                    
                    ===== TACOVERSE =====
                    1) New Order
                    0) Exit
                    """);

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> newOrder();

                case "0" -> {
                    running = false;
                    success("Thank you for supporting TacoVerse!");
                }

                default -> error("Invalid option.");
            }
        }
    }

    // order flow
    private void newOrder() {

        Order order = new Order();
        boolean ordering = true;

        while (ordering) {

            title("""
                    
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

                        error("Order cannot be empty.");
                        break;
                    }

                    checkout(order);
                    ordering = false;
                }

                case "0" -> {
                    warning("Order canceled.");
                    ordering = false;
                }

                default -> error("Invalid option.");
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

        line("""
                
                Select Taco Size:
                1) Single Taco
                2) 3-Taco Plate
                3) Burrito
                """);

        switch (scanner.nextLine()) {

            case "1" -> taco.setSize(TacoSize.SINGLE);
            case "2" -> taco.setSize(TacoSize.THREE_TACO);
            case "3" -> taco.setSize(TacoSize.BURRITO);

            default -> {
                warning("Invalid option. Defaulting to SINGLE.");
                taco.setSize(TacoSize.SINGLE);
            }
        }
    }

    private void selectShell(Taco taco) {

        line("""
                
                Select Shell Type:
                1) Corn
                2) Flour
                3) Hard Shell
                """);

        switch (scanner.nextLine()) {

            case "1" -> taco.setShell(ShellType.CORN);
            case "2" -> taco.setShell(ShellType.FLOUR);
            case "3" -> taco.setShell(ShellType.HARD_SHELL);

            default -> {
                warning("Invalid option. Defaulting to FLOUR.");
                taco.setShell(ShellType.FLOUR);
            }
        }
    }

    private void addMeat(Taco taco) {

        line("""
                Select Meat:
                - Carne Asada
                - Al Pastor
                - Pollo
                """);

        taco.getMeats().add(scanner.nextLine());

        line("Extra meat? (yes/no)");
        taco.setExtraMeat(scanner.nextLine().equalsIgnoreCase("yes"));
    }

    private void addCheese(Taco taco) {

        line("""
                Select Cheese:
                - Queso
                - Cotija
                - Cheddar
                """);

        taco.getCheeses().add(scanner.nextLine());

        line("Extra cheese? (yes/no)");
        taco.setExtraCheese(scanner.nextLine().equalsIgnoreCase("yes"));
    }

    private void addRegularToppings(Taco taco) {

        while (true) {

            line("""
                    
                    Add Topping:
                    (type DONE when finished)
                    """);

            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")) break;

            taco.getToppings().add(topping);
        }
    }

    private void addSauces(Taco taco) {

        while (true) {

            line("""
                    
                    Add Sauce:
                    (type DONE when finished)
                    """);

            String sauce = scanner.nextLine();

            if (sauce.equalsIgnoreCase("done")) break;

            taco.getSauces().add(sauce);
        }
    }

    private void askIfCovered(Taco taco) {

        line("Covered in salsa & queso? (yes/no)");
        taco.setCovered(scanner.nextLine().equalsIgnoreCase("yes"));
    }

    // ================= SIGNATURE ITEMS =================
    private void addSignatureTaco(Order order) {

        line("""
                
                Signature Tacos:
                1) Street Taco
                2) Super Burrito
                """);

        switch (scanner.nextLine()) {

            case "1" -> {
                order.getTacos().add(new StreetTaco());
                success("Street Taco added!");
            }

            case "2" -> {
                order.getTacos().add(new SuperBurrito());
                success("Super Burrito added!");
            }

            default -> error("Invalid option.");
        }
    }

    private void addCombo(Order order) {

        line("""
                
                ===== COMBO MENU =====
                1) Street Taco Combo
                2) Taco Snack Combo
                """);

        switch (scanner.nextLine()) {

            case "1" -> {
                order.getCombos().add(new StreetTacoCombo());
                success("Street Taco Combo added!");
            }

            case "2" -> {
                order.getCombos().add(new TacoSnackCombo());
                success("Taco Snack Combo added!");
            }

            default -> error("Invalid option.");
        }
    }

    private void addDrink(Order order) {

        line("""
                
                Drink Size:
                1) Small
                2) Medium
                3) Large
                """);

        String size = switch (scanner.nextLine()) {
            case "2" -> "Medium";
            case "3" -> "Large";
            default -> "Small";
        };

        line("Enter flavor:");
        String flavor = scanner.nextLine();

        order.getDrinks().add(new Drink(size, flavor));

        success("Drink added!");
    }

    private void addChips(Order order) {

        line("Select salsa:");
        String salsa = scanner.nextLine();

        order.getChips().add(new ChipsAndGuac(salsa));

        success("Chips & Salsa added!");
    }

    private void checkout(Order order) {

        title("\n===== ORDER SUMMARY =====\n");

        orderService.displayOrder(order);

        double total = pricingService.calculateOrderTotal(order);

        divider();
        System.out.printf("TOTAL: $%.2f%n", total);
        divider();

        line("""
                
                1) Confirm Order
                0) Cancel Order
                """);

        if (scanner.nextLine().equals("1")) {

            receiptService.saveReceipt(order, total);
            success("Receipt saved!");

        } else {
            error("Order canceled.");
        }
    }
}