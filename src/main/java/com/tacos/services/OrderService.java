// handles formatted display logic for customer order summaries
package com.tacos.services;

import static com.tacos.ui.ConsoleColors.*;

import com.tacos.models.*;

public class OrderService {

    private final PricingService pricingService;

    public OrderService() {
        this.pricingService = new PricingService();
    }

    public void displayOrder(Order order) {

        System.out.println(BOLD_CYAN + "\n===================================" + RESET);
        System.out.println(BOLD_CYAN + "          ORDER DETAILS            " + RESET);
        System.out.println(BOLD_CYAN + "===================================\n" + RESET);

        if (!order.getTacos().isEmpty()) {

            System.out.println(YELLOW + "----- TACOS -----" + RESET);

            for (Taco taco : order.getTacos()) {
                System.out.println(taco.getReceiptText());
            }

            System.out.println();
        }

        if (!order.getDrinks().isEmpty()) {

            System.out.println(CYAN + "----- DRINKS -----" + RESET);

            for (Drink drink : order.getDrinks()) {
                System.out.println(drink.getReceiptText());
            }

            System.out.println();
        }

        if (!order.getChips().isEmpty()) {

            System.out.println(GREEN + "----- CHIPS & SALSA -----" + RESET);

            for (ChipsAndGuac chips : order.getChips()) {
                System.out.println(chips.getReceiptText());
            }

            System.out.println();
        }

        if (!order.getCombos().isEmpty()) {

            System.out.println(RED + "----- COMBOS -----" + RESET);

            for (ComboOrder combo : order.getCombos()) {
                System.out.println(combo.getReceiptText());
            }

            System.out.println();
        }

        System.out.println(BOLD_CYAN + "===================================" + RESET);

        System.out.printf(
                BOLD_CYAN + "ORDER TOTAL: $%.2f%n" + RESET,
                pricingService.calculateOrderTotal(order)
        );

        System.out.println(BOLD_CYAN + "===================================\n" + RESET);
    }
}