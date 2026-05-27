// handles formatted display logic for customer order summaries
package com.tacos.services;

import com.tacos.models.*;

public class OrderService {

    private final PricingService pricingService;

    public OrderService() {

        pricingService = new PricingService();
    }

    public void displayOrder(Order order) {

        System.out.println("\n===== ORDER DETAILS =====\n");

        // individual tacos
        for (Taco taco : order.getTacos()) {

            System.out.println(taco.getReceiptText());
        }

        for (Drink drink : order.getDrinks()) {

            System.out.println(drink.getReceiptText());
        }

        for (ChipsAndGuac chips : order.getChips()) {

            System.out.println(chips.getReceiptText());
        }

        // combo orders
        for (ComboOrder combo : order.getCombos()) {

            System.out.println(combo.getReceiptText());
        }

        System.out.printf("""
                
                =========================
                ORDER TOTAL: $%.2f
                =========================
                %n""",
                pricingService.calculateOrderTotal(order));
    }
}
